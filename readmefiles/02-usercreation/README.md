### User creation through a single endpoint

To create the user, the following steps must be followed:

1. Open your preferred REST Client (Postman).
2. Change the request option to a Post.
3. Add the url to the patch http://localhost:81/auth/signup , then go to the body option in raw segment and add the following body:

````json
{
    "nombres":"Name User",
    "correo":"nameuser@nameuser.com",
    "contrasenna":"password"
}
````

4. In the body you can modify the name, email and password data to your preference.
5. Then execute the request.
6. Next, you should see the response of the request with a 201 Created with the body:

````json
{
    "userDto": {
        "nombres": "Name User",
        "correo": "nameuser@nameuser.com",
        "contrasenna": null
    },
    "loginResponseDto": {
        "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYW1ldXNlckBuYW1ldXNlci5jb20iLCJpYXQiOjE3MTE3MjAzMDYsImV4cCI6MTcxMTgwNjcwNn0.a8AY5zQhrP0GvPnpA22GdOTj4j13nf1CXbLhZPJE-eg"
    }
}
````

