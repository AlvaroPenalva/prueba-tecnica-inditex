# Prueba Técnica Inditex

## Introducción
Este proyecto implementa una arquitectura basada en los principios de la **Arquitectura Hexagonal**, la **Clean Architecture** y el **Domain-Driven Design (DDD)**. Está desarrollado en **Java 21** utilizando **Spring Framework** para estructurar sus componentes. Emplea una base de datos en memoria **H2** que facilita las pruebas y el desarrollo. La gestión de dependencias y el control del ciclo de vida del proyecto se realizan mediante **Maven**.

---

## Requisitos previos
Antes de empezar, necesitas tener instalados:
- **Git**
- **Docker**

---

## Instalación
Sigue estos pasos para instalar y configurar el proyecto:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/AlvaroPenalva/prueba-tecnica-inditex.git

2. Accede al directorio prices que contiene el proyecto 
    ```bash
    cd prueba-tecnica-inditex/prices/

3. Instala las dependencias y compila el proyecto 
    ```bash
    .\mvnw.cmd install

4. Genera la imagen 
    ```bash
    docker build -t prices .

5. Lanza el contenedor 
    ```bash
    docker run -p 8080:8080 prices

6. Ya puedes lanzar tus peticiones contra **http://localhost:8080/prices/search** usando la herramienta que desees, como postman.

---

### Librerías usadas

- **MapStruct**  
  Usada para generar los mappers que transforman entre DTOs y objetos de dominio, reduciendo el desarrollo de estos a clases abstractas sin necesidad de implementar manualmente el mapper.

- **JaCoCo**  
  Usada para recoger el reporte de cobertura de los tests, así como para fijar un mínimo del 90% en líneas de código testeadas, asegurando una alta calidad en el desarrollo.

- **Lombok**  
  Utilizada para delegar la implementación de constructores, getters y setters a anotaciones, reduciendo significativamente el código repetitivo y mejorando la legibilidad del proyecto.

- **Spring Boot Starter**:
  - **WEB**: Usado para implementar la API REST y manejar la comunicación entre los controladores y los clientes.
  - **DATA JPA**: Facilita la interacción de la aplicación con bases de datos relacionales, como la base de datos en memoria H2, mediante repositorios y JPA.
  - **TEST**: Proporciona herramientas como MockMVC y JUnit para el desarrollo de tests unitarios y pruebas de integración, garantizando la fiabilidad del código.

### A saber

Entre los distintos commits realizados en el proyecto, se incluyen diversas correcciones y descartes de ideas, como la eliminación de la gestión de la zona horaria de Madrid.

También se descartó la implementación de un bus de casos de uso, que habría permitido centralizar la gestión de los parámetros pasados a cada caso de uso mediante una interfaz específica.

Además, se optó por no utilizar mapeadores bidireccionales en escenarios donde las entidades pueden ser recuperadas o almacenadas en la base de datos. Todo esto se planteo para aseguurar un mejor desacoplamiento o aumento de eficiencia pero fue descartado para simplificar el código y centrarlo en el caso de uso.

### Propuestas

Para optimizar la eficiencia en la base de datos, se ha implementado un índice que mejora el rendimiento de las búsquedas, limitando estas exclusivamente a los campos necesarios.

En línea con los principios del Domain-Driven Design (DDD) y para mantener la lógica centrada en el dominio, la entidad Price asume la responsabilidad de gestionar la prioridad en las búsquedas. Aunque este enfoque puede reducir la eficiencia de las operaciones en base de datos, garantiza el desacoplamiento entre el dominio y la infraestructura, preservando la integridad del diseño orientado al dominio.

Por otro lado, el tratamiento de excepciones se maneja exclusivamente en la capa de aplicación, ya que estas excepciones están diseñadas para gestionar errores específicos de los casos de uso y no del dominio. Esto asegura una separación clara entre la lógica del negocio y las responsabilidades propias de la aplicación.

En cuanto a los tests, se han desarrollado pruebas de integración para todos los casos de uso solicitados, asegurando que funcionen correctamente dentro del sistema completo. Además, se han implementado pruebas unitarias y de dominio específicas para garantizar la correcta captura de excepciones y la estabilidad de la lógica en niveles más detallados del proyecto.