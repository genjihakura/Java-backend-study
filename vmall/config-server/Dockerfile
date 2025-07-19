FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./configs ./configs
ENTRYPOINT ["java","-jar","/app.jar"]