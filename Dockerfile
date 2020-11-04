# --- Author: Michael Webb,
FROM maven:latest AS base

RUN mkdir -p /code
WORKDIR /code

# Copy source code into container
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN mvn clean && mvn package

ENTRYPOINT ["java", "-cp", "./target/CS370MavenProject-1.0-SNAPSHOT-jar-with-dependencies.jar", "RestfulServer"]
