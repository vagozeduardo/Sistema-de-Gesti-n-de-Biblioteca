# API RESTful con Spring Boot
Para la gestion de una biblioteca (prueba)

Proyecto base para el desarrollo de una API REST utilizando:
* **Java 21**
* **Spring Boot 3.5.9**
* **Maven**
* **MySQL 8.0.33**

## Requisitos
* JDK 17
* Maven

## Como probar el pequeño proyecto desde docker
## Tutorial: Instalar y ejecutar una imagen de Docker Hub en local

## 1. Prerrequisitos
- Tener instalado **Docker Desktop** o Docker Engine en tu máquina.
- Verificar la instalación:
  ```bash
  docker --version
## 2. Descargar la imagen desde Docker Hub
- link a dockerHub:
  ```bash
  docker pull eduardovazquezgo/sistema-biblioteca:v2
  
## 3. Verificar que la imagen se descargó
-
  ```bash
  docker images

## 4. Ejecutar un contenedor en local
- Usa `docker run` para levantar la imagen:
  ```bash
  docker run -d -p 8080:8080 --name biblioteca-api eduardovazquezgo/sistema-biblioteca:v2

## 5. cosas adicionales
- Acceso rápido
  ```bash
  API Base: http://localhost:8080/api/libros
- documentacion con swagger
  ```BASH
  Documentación: http://localhost:8080/swagger-ui/index.html

### Guía de los metodos de controller o Endpoints

|Método|Endpoint|Descripción|
|------|--------|-------------|
|GET|/api/libros o /api/books?size=5&page=0 |trae todos lo datos paginados por defecto en 5 datos si no se ingresa el valor|
|GET|/api/books/{id} |Busca el libro por el id|
|POST|/api/books|Crea un dato de tipo libro, si los datos son correctos se crea|
|PUT|/api/books/{id}|se modifica el libro si el id existe|
|GET|/api/books/search?termino=metro&page=0&size=6|Busca los datos que coincidad con el temino ingresado, puede ser titulo o autor, ademas estra paginado|
|DELETE|/api/books/{id}|Elimina el dato con el id ingresado|







