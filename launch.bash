#!/bin/bash

java -jar axonserver/axonserver-4.4.1.jar &
java -jar routingms/target/routingms-1.0.jar &
java -jar handlingms/target/handlingms-1.0.jar &
java -jar trackingms/target/trackingms-1.0.jar &
#####
java -jar bookingms/target/bookingms-1.0.jar &

