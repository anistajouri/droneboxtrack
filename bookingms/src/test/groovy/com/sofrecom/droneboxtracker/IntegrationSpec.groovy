package com.sofrecom.droneboxtracker

import com.sofrecom.droneboxtracker.bookingms.BookingMSApplication
import com.sofrecom.droneboxtracker.bookingms.infrastructure.config.*
import groovy.transform.TypeChecked
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

// https://www.baeldung.com/groovy-spock
// specifications (spock terminology) describe expected features (properties, aspects) exhibited by a system

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity

@TypeChecked
@SpringBootTest(classes=[BookingMSApplication])
@ActiveProfiles([Profiles.TEST])
@Transactional
@Rollback
abstract class IntegrationSpec extends Specification {
    @Autowired
    private WebApplicationContext webApplicationContext

    // MockMvc provide a powerful way to mock Spring MVC for testing MVC web applications.
    // Through MockMvc, you can send mock HTTP requests to a controller and test how the controller
    // behaves without running the controller within a server.
    MockMvc mockMvc

    @Before
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build()
    }
}
