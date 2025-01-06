FROM eclipse-temurin:21-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/project-employee.jar

ENTRYPOINT ["java", "-jar", "/app/project-employee.jar"]