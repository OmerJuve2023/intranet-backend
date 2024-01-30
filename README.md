# Intranet Backend

Este README proporciona una descripción general de la aplicación Intranet Backend, incluyendo su estructura,
funcionalidad y configuración.

## ⚠️ **Nota de Exención de Responsabilidad:**

Este proyecto se proporciona con la intención de ser una herramienta educativa y para propósitos legítimos. El autor y
los colaboradores no se hacen responsables del uso indebido de esta herramienta con fines maliciosos o no éticos.

**Por favor, ten en cuenta:**

- Utiliza esta herramienta de manera ética y legal.
- No utilices esta herramienta para acceder, manipular o dañar datos sin permiso.
- Respeta la privacidad y los derechos de los demás usuarios.

Cualquier uso indebido de esta herramienta va en contra de los principios éticos y legales. El autor y los colaboradores
no apoyan ni promueven actividades ilegales o maliciosas.

## Tabla de Contenidos

- [Visión General](#visión-general)
- [Requisitos Previos](#requisitos-previos)
- [Entidad Usuario](#entidad-usuario)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
- [Puntos Fin de API](#puntos-fin-de-api)
- [Configuración de la Base de Datos](#configuración-de-la-base-de-datos)
- [Registro](#registro)
- [Ejecutar Pruebas](#ejecutar-pruebas)

## Visión General

Intranet Backend es una aplicación Spring Boot que proporciona servicios backend para la gestión de
usuarios en un sistema de intranet. Utiliza Spring Data JPA para el acceso a datos y PostgreSQL
como base de datos.

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrese de tener instalados los siguientes requisitos previos:

1. [x] Java 8 o posterior
2. [x] Base de datos PostgreSQL
3. [x] Maven

## Entidad Usuario

La entidad `User` representa la información del usuario en la base de datos. Aquí está la estructura de la tabla:

| Campo    | Tipo      | Descripción         |
|----------|-----------|---------------------|
| id       | Long      | Identificador único |
| username | String    | Nombre de usuario   |
| password | String    | Contraseña          |
| fecha    | LocalDate | Fecha de creación   |

Para obtener más detalles, consulte el código fuente y los comentarios en los archivos del proyecto.

## Instalación

Clonar el repositorio

```bash
git clone https://github.com/OmerJuve2023/intranet-faustino.git
```

crear la base de datos

```yaml
version: '3.8'
services:
  intranet-backend:
    container_name: intranet-backend
    image: postgres
    restart: always
    environment:
      POSTGRES_DB: db-intranet
      POSTGRES_USER: user
      POSTGRES_PASSWORD: root
    ports:
      - "4000:4000"
    expose:
      - 4000
    command: -p 4000
```

```bash 
docker-compose up -d
```

Navegar al directorio del proyecto

```bash 
cd intranet-backend
```

Construir el proyecto Maven

```bash 
mvn clean install
```

Construir la imagen de Docker

```bash
docker buildx build -t intranet-backend
```

## Configuración

La aplicación puede configurarse mediante el archivo application.yml en el
directorio [src/main/resources](src/main/resources). Asegúrese de configurar las propiedades de
conexión a la base de datos:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://<PROD_DB_HOST>:<PROD_DB_PORT>/<PROD_DB_NAME>
    username: <PROD_DB_USERNAME>
    password: <PROD_DB_PASSWORD>
    driver-class-name: org.postgresql.Driver
  # ... (otras propiedades de configuración)
```

## Uso

```bash
docker run -p 8080:8080 intranet-backend

```

La aplicación se iniciará y estará accesible en http://localhost:8080.

## Puntos Fin de API

### Obtener Todos los Usuarios

    Punto Final: /api/user/findAll
    Método: GET
    Descripción: Recuperar una lista de todos los usuarios.

**Agregar Usuario**

    Punto Final: /api/user/add

    Método: POST

    Descripción: Agregar un nuevo usuario al sistema.

**Cuerpo de la Solicitud:**

```json
{
  "username": "nuevoUsuario",
  "password": "nuevaContraseña"
}
```

## Configuración de la Base de Datos

La aplicación utiliza PostgreSQL como base de datos. Asegúrese de crear
una base de datos con las propiedades especificadas en el archivo application.yml.
Las tablas de la base de datos se crearán automáticamente al iniciar la aplicación debido a la
propiedad `hibernate.ddl-auto: create`.

## Registro

La aplicación utiliza la configuración de registro predeterminada de Spring Boot. Los niveles de registro para el
paquete org.springframework están configurados en INFO. Puede personalizar la configuración de registro en el archivo
`application.yml`.

## Ejecutar Pruebas

Para ejecutar las pruebas, puedes utilizar el siguiente comando:

```bash
./mvnw test
```