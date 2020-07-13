FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} indexer.jar
ENTRYPOINT ["java", "-jar", "/indexer.jar"]
