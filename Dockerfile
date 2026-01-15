FROM eclipse-temurin:21-jdk-alpine
ARG JAR_FILE=target/SistemaBiblioteca-0.0.1.jar
COPY ${JAR_FILE} app_biblioteca.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_biblioteca.jar"]