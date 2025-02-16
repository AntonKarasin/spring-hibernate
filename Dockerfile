FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} spring-hibernate-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker-compose", "-jar", "/spring-hibernate-1.0-SNAPSHOT.jar"]