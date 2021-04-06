#!/bin/bash
echo "################ Start booking ######################"
bookId=$(curl --header "Content-Type: application/json" \
  --request POST \
  --data '{ "bookingAmount": 53, 
            "originLocation": "X1", 
	    "destLocation" : "X5", 
	    "destArrivalDeadline" : "2020-10-28"
          }' http://localhost:8081/droneboxbooking)

echo "Booking ID got:**$bookId**"
sleep 3
echo "################ Get booking ID ######################"
curl --header "Content-Type: application/json" \
  --request GET \
  http://localhost:8081/droneboxview/$bookId

