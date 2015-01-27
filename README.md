# Spring Cloud Netflix OSS demo application

This sample application show how to use the Netflix OSS components in a Spring Boot application. The application consists of 3 parts:

- eureka-server
- giftcard-service
- checkout-service

The demo application support a few different MediaTypes. The interfaces (CheckoutService and GiftCardService) use the Protobuf message format to exchange data:

- application/json
- application/xml
- application/x-protobuf

To be able to build the application make sure the protoc compiler is on your system path (protoc version 2.4.1).

## eureka-server

- Eureka server: service discovery registry ([http://localhost:8761](http://localhost:8761))
- Turbine: for aggregation the Hystrix streams ([http://localhost:8761/turbine.stream?cluster=CHECKOUT](http://localhost:8761/turbine.stream?cluster=CHECKOUT))
- Hystrix Dashboard: for viewing the Hystrix streams from Turbine ([http://localhost:8761/hystrix/](http://localhost:8761/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8761%2Fturbine.stream%3Fcluster%3DCHECKOUT))

## giftcard-service

Dummy service that returns a GiftCard in the response. The service self registers with eureka.

URL: [http://localhost:7777/giftcard/1.json](http://localhost:7777/giftcard/1.json)

## checkout-service

This is where it all comes together. This service calls the GiftCard service and sends an aggregated response back to the caller. The service implements the circuit breaker pattern using Hystrix.

Integration with the GiftCard service is implemented using the Feign REST client builder. Ribbon is transparently used to loadbalance over (multiple) clients.

Implemented Netflix OSS components in this service:

- Eureka Client
- Hystrix
- Ribbon
- Feign

URL: [http://localhost:8888/checkout/1.json](http://localhost:8888/checkout/1.json)
