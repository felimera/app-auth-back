# Application for accessing the resources of a microservice.

## Introduction

This microservice is designed to provide the necessary approach to managing the accessibility of a system's resources in order to protect information exposed to the public and thus determine which resources can be viewed and which should not be displayed.

## Description

The microservice was developed in the Spring framework with the following components:
* Java version 17
* Spring boot version 3.2.4
* H2 in-memory database.
* Spring JPA for data persistence.
* Spring Security for authentication and access control framework.
* Validation for validation of input data.

## Setting

1. You must clone the repository https://github.com/felimera/app-auth-back.git
2. You can use IntelliJ IDEA to open the project.
3. After loading all project dependencies, you can run the project.

## How to use

To start using system endpoints. The registration of user data must be taken into account in order to obtain the authorization token. This starts like this:

### Create user
At this point, the system allows the creation of users from two endpoints.

In the first we can create the user on a specific endpoint, if we provide the necessary data it will respond with an affirmation or denial response. If the answer is affirmative, we must use another endpoint where we will enter the requested data and it will return the authorization token. But if the answer is negative, the system will indicate which data was the one that failed.

- [**`User creation through two endpoints`**](readmefiles/01-usercreation/README.md)

In the second it will allow us to create the user and will return a response with the data of the created user and the token will be added immediately.

- [**`User creation through a single endpoint`**](readmefiles/02-usercreation/README.md)

With these endpoints we can obtain the authorization token that will be useful to make requests to the microservice.

### Additional endpoints

As an additional option, two more endpoints were created. One does not need to use authorization token the other if it is necessary. These have the function of answering the necessary data for a side menu in which the potential client will have access to the application information.

- [**`Guest access`**](readmefiles/01-accessuser/README.md)
- [**`Access as user`**](readmefiles/02-accessuser/README.md)

## Deployment

To deploy this microservice, the Render service (https://render.com/) was used, where it provides me with enough functions to be able to test the App-Auth. If you want to test this microservice you can use the endpoints defined above and you just have to change the localhost to the render url. 
Example:

Original URL: http://localhost:81/auth/user

Deployed URL: https://app-auth-back.onrender.com/auth/user

This will be the case with the other endpoints.