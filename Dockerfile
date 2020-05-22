FROM adoptopenjdk:11-jre-hotspot
MAINTAINER Leonardo Marinho <leonardo.marinho@gmail.com>
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
