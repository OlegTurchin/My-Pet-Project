# Pet project based on Spring Cloud + Spring Secutity w/ JWT Auth

###### This pet project is based on the final version of the Spring Boot application from the VTB Advanced JAVA course, which can be found in the corresponding repository. It served me the sole purpose - diving deeper into the Spring Framework.
### This project consists of two steps:

#### 1. `Spring Boot` monolithic application + `Spring Security` w/ basic auth utilizing `WebSecurityConfigurerAdapter`

#### 2. `Spring Cloud` application in separated microservices + `Spring Security` w/ `securityFilterChain` auth utilizing `JSON Web Token`

###### It is important to note that you can run an application on microservices with basic authorization and a working frontend, but JWT Authentication and Token Refresh will only work through a request from a browser, Postman, or any other application that suits you, because there simply isn't a suitable frontend for that.


![img_1.png](img_1.png)