# Foro Hub
<p align="center">
  
![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
  ![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
  ![MySQL Badge](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

</p>

Este proyecto es una **API REST** desarrollada en Java utilizando el framework **Spring**. Su objetivo es replicar la funcionalidad básica de un foro, permitiendo a los usuarios interactuar con tópicos a través de las operaciones básicas **CRUD** (Crear, Leer, Actualizar y Eliminar). La API sigue las mejores prácticas del modelo REST y cuenta con validaciones, persistencia de datos y un servicio de autenticación para garantizar la seguridad.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java 21
- **Framework:** Spring Boot
- **Base de Datos:** MySQL
- **Manejo de Dependencias:** Maven
- **Librerías Adicionales:**
  - **Spring Data JPA**: Para el manejo de la base de datos relacional y la persistencia de datos.
  - **Spring Security**: Para la autenticación y autorización de usuarios.
  - **Spring Boot Starter Validation**: Para la validación de datos de entrada en la API.
  - **Spring Boot Starter Web**: Para construir y exponer APIs RESTful.
  - **Flyway MySQL**: Gestión de migraciones de la base de datos.
  - **MySQL Connector**: Conector JDBC para la base de datos MySQL.
  - **Lombok**: Para reducir el código repetitivo mediante anotaciones como `@Getter` y `@Setter`.
  - **Java JWT**: Para trabajar con JSON Web Tokens (JWT) en la autenticación.
  - **Spring Boot Starter Test**: Conjunto de herramientas para realizar pruebas unitarias e integración.


---



## ✨ Funcionalidades

La API proporciona las siguientes funcionalidades:

1. [**Login de un usuario:**](#1-login-de-un-usuario) Restringe el acceso a usuarios autenticados.  
2. [**Crear un nuevo tópico:**](#2-crear-un-nuevo-tópico) Los usuarios pueden registrar nuevos temas para discusión.  
3. [**Mostrar todos los tópicos:**](#3-mostrar-todos-los-tópicos) Recupera una lista paginada de todos los tópicos activos.  
4. [**Mostrar un tópico específico:**](#4-mostrar-un-tópico-específico) Consulta los detalles de un tópico utilizando su ID.  
5. [**Actualizar un tópico:**](#5-actualizar-un-tópico) Permite modificar las informaciones de un tópico existente.  
6. [**Eliminar un tópico:**](#6-eliminar-un-tópico) Implementa un borrado lógico, desactivando el tópico sin eliminarlo físicamente de la base de datos por medio de banderas.


---

## 📋 Endpoints de la API

### 1. Login de un usuario
- **Ruta:** `POST /login`
- **Descripción:** Valida los datos de un usuario y lo logea, de ser un usuario valido que existe en la base de datos, la API retorna un JWTtoken que le da acceso a todos los demas endpoints, los tokens caducan cada 2 horas.
Este token se debera agregar como encabezado en cualquier tipo de solicitud para ser válida.

- **Cuerpo de la petición:**
```json
{
	"login": "user",
	"clave": "password"
}
```

- **Respuesta:**
```json
{
	"jwTtoken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaXNzIjoiZm9yb2h1YiIsImlkIjoxLCJleHAiOjE3MzY5Nzk0NzF9.frwMi6xDGm462Ct_P0L-lgMKiJsswAP1ZgobzgxDnu0"
}
```
---

### 2. Crear un nuevo tópico
- **Ruta:** `POST /topicos`
- **Descripción:** Crea un nuevo tópico.
- **Cuerpo de la petición:**
```json
{
    "titulo": "Cómo integrar dependencias en Java",
	"mensaje": "Este tópico discute el uso de dependencias en Java.",
	"fechacreacion": "2025-01-13",
	"status": "ABIERTO",
	"autor": "Daniel",
	"curso": "Fundamentos de Java"
}
```
---
### 3. Mostrar todos los tópicos:
- **Ruta:** `GET /topicos`
- **Descripción:** Crea un nuevo tópico.
- **Respuesta a la petición:**
```json
{
	"content": [
		{
			"id": 1,
			"titulo": "Cómo integrar dependencias en Java",
			"mensaje": "Este tópico discute el uso de dependencias en Java.",
			"fechacreacion": "2025-01-13",
			"status": "ABIERTO",
			"autor": "Daniel",
			"curso": "Fundamentos de Java"
		},
		{
			"id": 2,
			"titulo": "Cómo mejorar el rendimiento en C++",
			"mensaje": "Este tópico discute maneras de optimizar algoritmos en C++.",
			"fechacreacion": "2025-01-14",
			"status": "ABIERTO",
			"autor": "Alberto Talon",
			"curso": "Programación en C++"
		}
	]
}
```
---
### 4. Mostrar un tópico específico
- **Ruta:** `GET /topicos/1`
- **Descripción:** Se muestra el id del topico enviado desde la URI
- **Respuesta a la petición:**
```json
{
	"id": 1,
	"titulo": "Cómo integrar dependencias en Java",
	"mensaje": "Este tópico discute el uso de dependencias en Java.",
	"fechacreacion": "2025-01-13",
	"status": "ABIERTO",
	"autor": "Daniel",
	"curso": "Fundamentos de Java"
}
```
---
### 5. Actualizar un tópico
- **Ruta:** `PUT /topicos`
- **Descripción:** Se actualiza informacion de un usuario por la que encuentre en el cuerpo, los datos que no son enviados se mantienen como se tienen en la base de datos, se debe enviar en el payload el id del tópico a actualizar.

- **Respuesta a la petición:**
```json
	{
		"id": 1,
		"curso": "Objetos en Java"
	}
```
---
### 6. Eliminar un tópico
- **Ruta:** `DELETE /topicos/1`
- **Descripción:** Se elimina el tópico con el ID enviado en la URI, de existir, el tópico se mantiene en la base de datos, pero su campo `activo` se cambia a 0, dandolo de baja, por lo que no sera accesible en las solicitudes GET, solo se podra seguir viendo en la base de datos directamente. Retorna un codigo `204 No Content`


---
## 🗄️ Configuración de la base de datos
Para configurar los datos de acceso a la base de datos en la aplicación, edita el archivo `application.properties` con tu información específica: asegúrate de cambiar `${DB_HOST}` por la dirección de tu servidor MySQL y ajustar `spring.datasource.username` y `spring.datasource.password` con tus credenciales. 

Crea la base de datos `forohub` en tu Workbench y agrega un usuario a la tabla de usuario, asegurate de que la contraseña la encriptes antes de insertarla por seguridad, en este proyecto se utilizo BCRYPT para garantizar la seguridad de la informacion sensible de las contraseñas en la tabla de usuarios.

En internet hay muchas paginas que te ayudan a generar el Hash de un texto, puedes utilizar:
https://bcrypt.online 

Flyway se encargará automáticamente de gestionar las migraciones de la base de datos, asegurando que esté actualizada con los últimos cambios definidos en los scripts SQL.
