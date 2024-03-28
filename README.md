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

In the second it will allow us to create the user and will return a response with the data of the created user and the token will be added immediately.

To create a user we can follow the following steps:

#### User creation through two endpoints

1. Open your preferred REST Client (Postman).
2. Change the request option to a Post.
3. Add the url to the patch http://localhost:81/signup , then go to the body option in raw segment and add the following body:


```json
{
  "name":"User test",
  "email":"user-test@test.com",
  "password":"password"
}
```

4. In the body you can modify the name, email and password data to your preference.
5. Then execute the request.
6. Next, you should see the response of the request with a 201 Created with the body:

```json
{ 
  "code": "201", 
  "message": "User created successfully."
}
```

#### Get the Token
After creating the user you can do the following:

1. Open another tab of the REST Client (PostMan) and enter this url http://localhost:81/login
2. Change the request option to a Post.
3. Then go to the body option in raw segment and add the following body:

````json
{
     "email":"user-test@test.com",
     "password":"password"
}
````

4. In the body you can modify the name, email and password data to your preference.
5. Then execute the request.
6. Next, you should see the response of the request with a 200 Ok with the body:

````json
{
  "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXNAYW5kcmVzLmNvbSIsImlhdCI6MTcwOTg1NzU3NCwiZXhwIjoxNzEyNDQ5NTc0fQ.CtJLViMFyxhvnTIr1ZDtzqWa-NdV542 "Vlkp8Cx2HJS0"
}
````

