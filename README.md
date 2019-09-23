# Recipe Service Application 

## The Application allows users to manage your favourite recipes:

This application helps in managing your favourite recipes with the help of dashboard.
The Application shows a list of all available recipes and the options to create, update, fetch, delete and get all the available recipes.
Each recipe has the following below attributes:
- Date and time of creation (formatted as dd-MM-yyyy HH:mm).
- Indicator if the dish is vegetarian.
- Indicator displaying the number of people the dish is suitable for.
- Unstructured list of ingredients.
- Cooking Instructions.

## Tools and Technology used:
Below are the list which we have used to develop our application:
- JAVA8 as a programming language.
- SPRING BOOT as a framework.
- H2 as in memory database.
- JPA as a Hibernate Implementation.
- JWT as a framework for Authentication.
- SPRING SECURITY as a framework to impose security to our API's.
- MOCKITO framework for writing JUnits.
- HAMCREST Library for the Matchers and Assertions in test cases.
- SPRING TEST module for writing Integration test.
- IDE used ( Intellij or Eclipse ).
- MAVEN as a build Tool.
- GIT as a repository for Distributed Version Control System.
- SONARLINT as a pluggin in IDE for code quality.
- POSTMAN as a REST Client.
- SWAGGER for API Documentation.
- APACHE TOMCAT as a embedded server to run our application.

## Project Overview:

Our project consist of several layers. For the simplicity, I have drawn a high level diagram of the various layers and packages used.

- [controller package](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/controller)
- [service package](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/service)
- [repository package](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/dao)
- [model package](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/entity)
- [security package](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/jwt)

You can see the logical representation below of these packages:
 [Application Flow Diagram](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/resources/static/app_diagram.PNG)/app_diagram.PNG)

Let's take a detailed look;

## Server Configuration
&nbsp;&nbsp;&nbsp;&nbsp;The default configuration port is 8080, however we may want to change this. Thus I add the port configuration
&nbsp;&nbsp;&nbsp;&nbsp;as below;
```
#server port
server.port=8080
```
    
## H2 Database Configuration
 &nbsp;&nbsp;&nbsp;&nbspWe also need to specify whether the console is activated, so that we can use H2 database via the console, create
&nbsp;&nbsp;&nbsp;&nbsp;our tables and initialize our db entries.  
```

#H2 configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2
```

## DataSource Configuration
&nbsp;&nbsp;&nbsp;&nbsp;Instead of writing a connection string, we are defining the parameters via our properties file as below;
&nbsp;&nbsp;&nbsp;&nbsp;Notify that we defined our database as a file and the name of the database is "consultantapi". We are going to use it when
&nbsp;&nbsp;&nbsp;&nbsp;we need to connect the database via the console;

```
##Data source configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```

## Spring Security Configuration
&nbsp;&nbsp;&nbsp;&nbsp;To make our application secure, We have used Spring Security.
&nbsp;&nbsp;&nbsp;&nbsp;We have defined the authentication Url's, JWT token, password, refresh token Url's, token expiry time etc in our application.properties file
&nbsp;&nbsp;&nbsp;&nbsp;This ensures our application and various URI's exposed much secure.
```
#Spring Security Configuration
jwt.signing.key.secret=mySecret
jwt.get.token.uri=/authenticate
jwt.refresh.token.uri=/refresh
jwt.http.request.header=Authorization
jwt.token.expiration.in.seconds=604800
```

## Sending And Receiving JSONs With Postman
In this part, I'm going to demonstrate all operations defined in our [RecipeController](https://p-bitbucket.nl.eu.abnamro.com:7999/users/c65598/repos/recipeservice/browse/src/main/java/com/chandan/recipe/webservices/recipeservice/controller) class and how to test them
either with our web browser or with the [Postman tool](https://www.getpostman.com/). We can test our GET methods with any web browser but for
operations that use HTTP POST, PUT, DELETE methods, we cannot execute them with a simple web browser, so I'm
going to use [Postman tool](https://www.getpostman.com/) for that.

You can download Postman via [this link](https://www.getpostman.com/)

## Swagger Documentation ( api-docs ) 
I have provided a detailed description of each API's as a part of API Documentation
Below is the link for it.

[API Documentation](http://localhost:8080/v2/api-docs)

## User Friendly Swagger UI Html:
Last but not the least, have added a user friendly Swagger UI Html.

[Swagger-UI-Html](http://localhost:8080/swagger-ui.html)

- This will help the end user to understand and consume our web services in a easy way.
- Every details is minutely documented with sample Inputs and Outputs.
- Each of the response from our Application is explained and described in a simple human understandable words.

## Thank you and welcome everyone to use our Application..!!!

- For any Queries, please reach out to me on below communication channel
- Email = chandan.kle@gmail.com
- Mobile = +31 644274503