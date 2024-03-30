### User creation through two endpoints

1. Open your preferred REST Client (Postman).
2. Change the request option to a Post.
3. Add the url to the patch http://localhost:81/auth/signup , then go to the body option in raw segment and add the following body:


```json
{
  "nombres":"Name User",
  "correo":"nameuser@nameuser.com",
  "contrasenna":"password"
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

### Get the Token
After creating the user you can do the following:

1. Open another tab of the REST Client (PostMan) and enter this url http://localhost:81/auth/login
2. Change the request option to a Post.
3. Then go to the body option in raw segment and add the following body:

````json
{
  "correo":"nameuser@nameuser.com",
  "contrasenna":"password"
}
````

4. In the body you can modify the name, email and password data to your preference.
5. Then execute the request.
6. Next, you should see the response of the request with a 200 Ok with the body:

````json
{
  "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXNAYW5kcmVzLmNvbSIsImlhdCI6MTcwOTg1NzU3NCwiZXhwIjoxNzEyNDQ5NTc0fQ.CtJLViMFyxhvnTIr1ZDtzqWa-NdV542Vlkp8Cx2HJS0"
}
````