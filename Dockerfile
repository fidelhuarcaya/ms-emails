FROM openjdk:17-jdk-alpine
COPY target/ms-emails-0.0.1-SNAPSHOT.jar ms-emails-0.0.1.jar
ENTRYPOINT ["java","-jar","/ms-emails-0.0.1.jar"]
