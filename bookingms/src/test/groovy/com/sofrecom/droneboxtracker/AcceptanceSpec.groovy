package com.sofrecom.droneboxtracking

import groovy.util.logging.Slf4j

import com.sofrecom.droneboxtracker.SampleBookingDTO
import com.sofrecom.droneboxtracker.IntegrationSpec
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Title

import static org.junit.Assert.assertEquals
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Title("Acceptance tests: verifying the end-to-end behavior of a system.")
@Slf4j
class AcceptanceSpec extends IntegrationSpec implements SampleBookingDTO {

    @WithMockUser
    def "Happy path positive scenario"() {
        given: 'I do a command of dronebox booking with amount 100 from X1 to X5'
        MvcResult commandBooking = mockMvc.perform(MockMvcRequestBuilders.post("/droneboxbooking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""" {
                        "bookingAmount": 53,
                        "originLocation": "X1",
                        "destLocation" : "X5",
                        "destArrivalDeadline" : "2020-10-28"
                    } """)).andReturn();
        String bookingIdentifier = commandBooking.getResponse().getContentAsString();
        log.info "------> response bookingIdentifier: " + bookingIdentifier
        Thread.sleep(5000);

        when: 'I query the state of booking '
            ResultActions getBooking = mockMvc.perform(get("/droneboxview/$bookingIdentifier"))
        then: 'I get information to track the dronebox according to specified itinerary'
            getBooking.andExpect(status().isOk())
                .andExpect(content().json("""
                {
                    "DroneboxView": {
                        "booking_id": "$bookingIdentifier",
                        "transport_status": "NOT_STARTED",
                        "routing_status": "ROUTED",
                        "spec_origin_id": "",
                        "spec_destination_id": "From X1 at Tue Aug 25 06:00:00 CET 2020 --> X2 at Wed Aug 26 06:00:00 CET 2020 / From X2 at Thu Aug 27 06:00:00 CET 2020 --> X3 at Fri Aug 28 06:00:00 CET 2020 / From X3 at Sat Aug 29 06:00:00 CET 2020 --> X5 at Sun Aug 30 06:00:00 CET 2020 / "
                    }             
                }"""))

        when: 'First dronebox received at relay point X1'
            String jsonBody = """
                    {
                        "bookingId" : "$bookingIdentifier",
                        "locCode" : "X1",
                        "handlingType" : "RECEIVED",
                        "completionTime": "2020-08-25",
                        "voyageNumber" : ""
                    } """ ;
            def url = 'http://localhost:8088/droneboxhandling'
            def post = new HttpPost(url)

            post.addHeader("content-type", "application/json")
            post.setEntity(new StringEntity(jsonBody))
            def client = HttpClientBuilder.create().build()
            def response = client.execute(post)

            def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
            def jsonResponse = bufferedReader.getText()
            println "------> response Handling: " + jsonResponse

        then: 'I see RECEIVED/X1 notification in tracking'
            assertEquals ( jsonResponse , "Handling Activity Registered");
            Thread.sleep(3000);

            def urlTracking = "http://localhost:8082/droneboxtracking/$bookingIdentifier"
            def get = new HttpGet(urlTracking)
            get.addHeader("content-type", "application/json")

            def clientGet = HttpClientBuilder.create().build()
            def responseGet = clientGet.execute(get)
            def bufferedReaderGet = new BufferedReader(new InputStreamReader(responseGet.getEntity().getContent()))
            def jsonResponseGet = bufferedReaderGet.getText()
            log.info  "------> response Tracking: " + jsonResponseGet

        when: "I post a LOAD handling at relay point X1"
        then: "I see LOAD/X1 notification in tracking"
        when: "I post a UNLOAD handling at relay point X2"
        then: "I see UNLOAD/X2 notification in tracking"
        when: "I post a LOAD handling at relay point X2"
        then: "I see LOAD/X2 notification in tracking"
        when: "I post a UNLOAD handling at relay point X3"
        then: "I see UNLOAD/X3 notification in tracking"
        when: "I post a LOAD handling at relay point X3"
        then: "I see LOAD/X3 notification in tracking"
        when: "I post a UNLOAD handling at relay point X5"
        then: "I see UNLOAD/X5 notification in tracking"
        when: "I post a ARRIVED handling at relay point X5"
        then: "I see ARRIVED/X5 notification in tracking"

    }

}
