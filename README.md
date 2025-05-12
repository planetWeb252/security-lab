#  🔐  Sercurity Lab - Spring Boot + JWT
Este proyecto es un laboratorio práctico diseñado para aprender a implementar autenticación y autorización en una API REST usando **Spring Boot**, **Spring Security** y **JWT (JSON Web Token)**.

---

## 🚀 Tecnologías usadas

- Java 21
- Spring Boot 3
- Spring Security
- JWT (io.jsonwebtoken)
- Maven
- Lombok
- Postman (para pruebas)

---

## 🛠️ Configuración inicial
1. Clona el repositorio:
   ```bash
   git clone https://github.com/planetWeb252/security-lab.git
   cd security-lab 
   ```
2. Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.).
3. Ejecuta la aplicacion 
   ```bash
   mvn spring-boot:run
   ```
---
## 📂 Estructura del Proyecto
src
└── main
├── java
│ └── com.securitylab
│ ├── auth # Registro y login de usuarios
│ ├── config # Configuración de seguridad y JWT
│ ├── controller # Controladores protegidos y públicos
│ ├── user # Modelo de Usuario y roles
│ └── SecurityLabApp # Clase principal
└── resources
└── application.properties
---
## 🔑 Endpoints disponibles
| Método | Endpoint                | Descripción                               |
|--------|-------------------------|-------------------------------------------|
| POST   | /api/creationUser         | Crea un Usuario                           |
| GET    | /api/login  | Iniciar sesión y obtener un token JWT     |
| GET    | /routeRequiredAuth/authenticated       | Comprueba que el Usuario esta autenticado |
| GET    | //api/admin/hello     | Ruta para Usuarios con Rol Admin          |

## Crear Usuario:
POST /api/creationUser
Crea un nuevo usuario.
Body (JSON)
```json
{
   "username": "testUser",
   "password": "1234",
   "role": [
      {
         "name": "ROLE_USER"
      },
      {
         "name": "ROLE_ADMIN"
      }
   ]
}
```
## Login
POST /api/login
Loguear un Usuario.
Body (JSON)
```json
{
   "username": "testUser",
   "password": "1234",
   "role": [
      {
         "name": "ROLE_USER"
      },
      {
         "name": "ROLE_ADMIN"
      }
   ]
}
```
---
## AUTHENTICATION

GET /routeRequiredAuth/authenticated
Ruta para usuario logueados.
Body (JSON)
```json
{
   "username": "testUser",
   "password": "1234",
   "role": [
      {
         "name": "ROLE_USER"
      },
      {
         "name": "ROLE_ADMIN"
      }
   ]
}
```
---
## ADMIN
GET /api/admin/hello
Ruta para usuarios con rol ADMIN.
Body (JSON)
```json
{
   "username": "testUser",
   "password": "1234",
   "role": [
      {
         "name": "ROLE_USER"
      },
      {
         "name": "ROLE_ADMIN"
      }
   ]
}
```
## 🔒  Rutas Protegidas
Las rutas protegidas requieren un token JWT válido para acceder. Puedes obtener un token JWT al iniciar sesión con un usuario registrado. El token debe ser enviado en el encabezado de autorización de la siguiente manera:
```
Authorization: Bearer <TOKEN_JWT>
```
---
## ⚠️ Problemas Comunes
- **Error 401 Unauthorized**: Asegúrate de que el token JWT es válido y no ha expirado.
- **Error 403 Forbidden**: Asegúrate de que el usuario tiene los roles necesarios para acceder a la ruta.
- **Error 500 Internal Server Error**: Revisa los logs de la aplicación para más detalles sobre el error.
---
## 🧪 Pruebas con Postman

1. **Crear Usuario**: Envía una solicitud POST a `/api/creationUser` con el cuerpo JSON para crear un nuevo usuario.
2. **Iniciar Sesión**: Envía una solicitud POST a `/api/login` con el cuerpo JSON para obtener un token JWT.
3. **Acceder a Rutas Protegidas**: Usa el token JWT obtenido en el paso anterior para acceder a las rutas protegidas. Asegúrate de incluir el token en el encabezado de autorización.

---
## 👤 Autor
Desarrollado por mí, [planetWeb252](https://github.com/planetWeb252), como parte de mi aprendizaje de Spring Security y JWT.
