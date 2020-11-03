# Linux image
FROM ubuntu:latest
#FROM openjdk:12-alpine

COPY RestfulServer.java /RestfulServer.java

# Compile
RUN javac RestfulServer.java
ENTRYPOINT java RestfulServer
