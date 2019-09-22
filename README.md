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
- SPRING SECURITY as a framework to impose security to our application.
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



