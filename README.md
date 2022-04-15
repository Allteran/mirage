# MIRAGE
Mirage is a CRM service for phone repair shops network based on microservices architecture. <br>
#### Main chain of services and its teck stack:
* Workshop-service: uses to create and manage every _ReportOrder, OrderStatus, DeviceType_
  + Use MongoDB to store data
* Api-gateway-service: uses to manage routes between microservices
* Eureka-service: standart discovery server
* Config-server: uses to pull configuration updates via github

In future will add visual diagram that displays exaclty connect between microservices and actual teck stack that it uses
