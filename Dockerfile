FROM openjdk:latest
ARG JAR_FILE=target/back-auth-0.0.1.jar
COPY ${JAR_FILE} data/back-auth-0.0.1.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","data/back-auth-0.0.1.jar"]
