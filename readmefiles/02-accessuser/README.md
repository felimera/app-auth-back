### Access as user

To access as a user you must have previously created the user with the endpoints referred to above and with these to obtain the authorization token. In the system you have the possibility of having two roles as administrator or user. The system by default creates the user with the user type role. If you want to change your role, you must enter the database and change it directly (in a real company, the change is usually requested and a technician in charge changes your role as administrator).

Next, continue with these steps:

1. Open your preferred REST Client (Postman).
2. Change the request option to a Get.
3. Add the url to the patch http://localhost:81/auth/api/access
4. Then in the Params tab in the Query Params option add the key acronym and the value A or U (depending on the option it will generate a different response).
5. Then execute the request.
6. If the request was made with the U option, the response of the request will be 200 Ok with the body:

````json
{
    "idRol": 2,
    "nombreRol": "Usuario",
    "acronimoRol": "U",
    "descripcionRol": "Cliente del establecimiento con limitadas funciones en la aplicacion.",
    "linkList": [
        {
            "id": 1,
            "etiqueta": "Dashboard",
            "icono": "dashboard",
            "url": "/dashboard",
            "descripcion": "Listado de todoslos servicios que ofrece el establecimiento."
        },
        {
            "id": 2,
            "etiqueta": "Database",
            "icono": "database",
            "url": "/database",
            "descripcion": "Acceso completo a las funcionalidades del gesto de appointment."
        },
        {
            "id": 6,
            "etiqueta": "Settings",
            "icono": "settings",
            "url": "/settings",
            "descripcion": null
        }
    ]
}
````

7. But if the request was made with the A option, the endpoint's response will be a 200 Ok with the body:

````json
{
    "idRol": 1,
    "nombreRol": "Administrador",
    "acronimoRol": "A",
    "descripcionRol": "Persona encargar de multiples tareas y permisos adsolutos en la aplicaciona.",
    "linkList": [
        {
            "id": 1,
            "etiqueta": "Dashboard",
            "icono": "dashboard",
            "url": "/dashboard",
            "descripcion": "Listado de todoslos servicios que ofrece el establecimiento."
        },
        {
            "id": 2,
            "etiqueta": "Database",
            "icono": "database",
            "url": "/database",
            "descripcion": "Acceso completo a las funcionalidades del gesto de appointment."
        },
        {
            "id": 3,
            "etiqueta": "Report",
            "icono": "print",
            "url": "/report",
            "descripcion": "Acceso a los reportes de la aplicacion."
        },
        {
            "id": 4,
            "etiqueta": "Security",
            "icono": "security",
            "url": "/security",
            "descripcion": null
        },
        {
            "id": 5,
            "etiqueta": "Extensions",
            "icono": "extension",
            "url": "/extension",
            "descripcion": null
        },
        {
            "id": 6,
            "etiqueta": "Settings",
            "icono": "settings",
            "url": "/settings",
            "descripcion": null
        }
    ]
}
````