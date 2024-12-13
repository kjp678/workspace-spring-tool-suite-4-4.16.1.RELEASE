FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/spring-boot-docker.jar practice
EXPOSE 8080
#ADD target/spring-boot-docker spring-boot-docker
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]