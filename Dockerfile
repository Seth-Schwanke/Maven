# Linux image
FROM ubuntu:latest
#FROM openjdk:12-alpine

COPY target/CS370MavenProject-*.jar /CS370MavenProject.jar

CMD ["java" , "-jar", "/CS370MavenProject.jar"]