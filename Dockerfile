FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/sbb-0.0.1.jar
COPY ${JAR_FILE} app.jar
EXPOSE 2222
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]