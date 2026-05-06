# API de Usuarios - Chakray Consulting

## Descripción general

API RESTful desarrollada con Spring Boot para la gestión de usuarios.  
Creada como parte de una evaluación técnica para el puesto de Desarrollador/Programador Mid.

La API permite crear, consultar, actualizar y eliminar usuarios, con validaciones de campos y manejo de errores estándar.

## Tecnologías

- Java 17
- Spring Boot
- Maven
- Jakarta Validation
- Swagger (OpenAPI)

## Arquitectura

Arquitectura por capas simple:

- **Controller**: manejo de peticiones HTTP
- **Service**: lógica de negocio
- **Model**: representación de datos
- **DTO**: objetos de petición y respuesta


## Endpoints principales

| Método | Endpoint           | Descripción               |
|--------|--------------------|---------------------------|
| POST   | /api/usuarios      | Crear un nuevo usuario    |
| GET    | /api/usuarios      | Obtener lista de usuarios |
| GET    | /api/usuarios/{id} | Obtener usuario por ID    |
| PUT    | /api/usuarios/{id} | Actualizar usuario        |
| DELETE | /api/usuarios/{id} | Eliminar usuario          |


## Inicio rápido

### Requisitos previos

- Java 17 instalado
- Maven 3.9 o superior

### Ejecutar el proyecto

```bash
mvn spring-boot:run
```

## Disponibilidad de la API
```text
http://localhost:8080
```

## Documentacion interactiva (Swagger)
```text
http://localhost:8080/swagger-ui/index.htm
```


## Testing de la API
El proyecto incluye una colección de Postman:
```text
/postman/collection.json
```
