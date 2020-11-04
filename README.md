# CS370MavenProject

Authors: Jake Mismas, Michael Webb, Seth Schwanke

Project Description:

The purpose of this project is to demonstrate the advantages of a docker containerized smart home system, through the containerization of Google Assistant. Docker containers have some distinct advantages over virtual machines, from low resource overhead to fast start up times. This project aims to create a Google Assistant instance within a docker container that can be interacted with. More specifically, using Google Assistant API to respond to questions sent as requests. To add an additional layer of depth, each question and its answer will be logged, and then reused if the same question is asked. Please see the following flowchart:

RestfulServer.class: Parses request body into a string, and sends string to BackEnd.class. ->
BackEnd.class: Checks if string is a question, then sends string to questionHistory.class (containerized). -> 
questionHistory.class: Checks if question was already asked in last 24 HOURS, if not returns false. ->
BackEnd.class: Sends never asked question to Google Assistant API (containerized) ->
GoogleAssistantAPI: Answers question, returns string. ->
BackEnd.class: Updates history with question and answer, sends to RestfulServer.class. ->
RestfulServer.class: Logs the answer. 

If this project is used in a containerized smart home system, multiple smart devices and products could be used in conjunction, with minimal effect on one another.  

Usage:
javac ./java
javac RestfulServer.java
java RestfulServer


How to build and run...
Webserver
Project

Docker:
how to build docker image
docker build -t myapp .

run image as container
docker run -it --name=myapp -p 8080 myapp
