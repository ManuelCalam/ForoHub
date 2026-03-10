![Java](https://img.shields.io/badge/java-%23FF0000.svg?style=for-the-badge&logo=java&logoColor=white)

# Challenge Alura ONE - API REST de Foro

API REST desarrollada en Java con Spring Boot que permite gestionar tópicos de discusión mediante operaciones CRUD.  
El proyecto implementa autenticación utilizando JWT (JSON Web Token), permitiendo proteger los endpoints y controlar el acceso a la información.

La aplicación permite crear, consultar, actualizar y eliminar tópicos de un foro, almacenando la información en una base de datos mediante Spring Data JPA.

---

# Tecnologías

- Java 17+
- Spring Boot
- Spring Data JPA / Hibernate
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Maven

---

# Funcionalidades del Sistema

La API permite realizar las siguientes operaciones:

## Autenticación de usuario
- Permite iniciar sesión mediante credenciales de usuario.
- Genera un token JWT que se utiliza para acceder a los endpoints protegidos.

## Crear tópico
- Registra un nuevo tópico en el sistema.
- Valida los datos enviados antes de almacenarlos.

## Listar tópicos
- Permite consultar todos los tópicos registrados en el sistema.

## Consultar tópico por ID
- Permite obtener la información detallada de un tópico específico.

## Actualizar tópico
- Permite modificar la información de un tópico existente.

## Eliminar tópico
- Permite eliminar un tópico del sistema.

---

# Seguridad

La API utiliza Spring Security para proteger los endpoints mediante autenticación basada en JWT.

Flujo de autenticación:

1. El usuario envía sus credenciales al endpoint de login.
2. El servidor valida las credenciales.
3. Se genera un token JWT.
4. El cliente utiliza el token en el header `Authorization` para acceder a los endpoints protegidos.
