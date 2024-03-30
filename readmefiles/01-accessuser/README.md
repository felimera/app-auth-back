### Guest access

For clients who are only guests, it is not necessary to create a user to access the system for this option this endpoint was created. To access this information, follow the following steps:

1. Open your preferred REST Client (Postman).
2. Change the request option to a Get.
3. Add the url to the patch http://localhost:81/auth/guest
4. Then execute the request.
5. Next, you should see the response of the request with a 200 Ok with the body:

````json
{
    "idRol": 3,
    "nombreRol": "Invitado",
    "acronimoRol": "I",
    "descripcionRol": "Potencial cliente que no sea registrado en el sistema.",
    "linkList": [
        {
            "id": 1,
            "etiqueta": "Dashboard",
            "icono": "dashboard",
            "url": "/dashboard",
            "descripcion": "Listado de todoslos servicios que ofrece el establecimiento."
        }
    ]
}
````



