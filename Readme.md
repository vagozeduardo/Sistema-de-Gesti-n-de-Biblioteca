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
- Descarga los 2 archivos que estan en la carpet: `SistemaBiblioteca_ejecutar` que son:
  - data.sql
  - docker-compose.yml

- Guardalos en una carpeta ambos archivos.
> [!IMPORTANT]
> SI el puente esta siendo usado puede realizar lo siguiente:
> |Servicio|Línea en YAML|Qué cambiar si falla|
> |--------|-------------|---------------------|
> |API|	8080:8080|Cambia el primer 8080 por 9090|
> |DB|3307:3306|Cambia el 3307 por 3308|
> 
> pueda que funcione. ._.

## 5. A ejecutar

1. abre la terminal del sistema en la carpeta donde se guardo los archivos descargados.
2. ejecute:
   ```bash
        docker-compose up -d
3. disfrute, ya puede usarlo en el navegador o en postman.

## 6. cosas adicionales
- Acceso rápido
- API Base: 
  ```bash
  http://localhost:8080/api/libros
- documentacion con swagger
- Documentación: 
  ```BASH
  http://localhost:8080/swagger-ui/index.html

### Guía de los metodos de controller o Endpoints

|Método|Endpoint|Descripción|
|------|--------|-------------|
|GET|/api/libros o /api/books?size=5&page=0 |trae todos lo datos paginados por defecto en 5 datos si no se ingresa el valor|
|GET|/api/books/{id} |Busca el libro por el id|
|POST|/api/books|Crea un dato de tipo libro, si los datos son correctos se crea|
|PUT|/api/books/{id}|se modifica el libro si el id existe|
|GET|/api/books/search?termino=metro&page=0&size=6|Busca los datos que coincidad con el temino ingresado, puede ser titulo o autor, ademas estra paginado|
|DELETE|/api/books/{id}|Elimina el dato con el id ingresado|







