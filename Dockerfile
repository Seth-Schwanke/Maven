# Linux image
#FROM ubuntu:latest
#FROM openjdk:12-alpine
#COPY  target/CS370MavenProject-*.jar /CS370MavenProject.jar/
#COPY target/CS370MavenProject-1.0-SNAPSHOT-jar-with-dependencies.jar /CS370MavenProject.jar/
#CMD ["java" , "-jar", "CS370MavenProject.jar"]

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src/
COPY pom.xml /home/app/
RUN mvn -f /home/app/pom.xml/ clean package

FROM openjdk:11-jre-slim
COPY --from=build /usr/src/app/target/CS370MavenProject-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/CS370MavenProject-1.0-SNAPSHOT-jar-with-dependencies.jar/
EXPOSE 8080
CMD ["java" , "-jar", "CS370MavenProject-1.0-SNAPSHOT-jar-with-dependencies.jar"]
