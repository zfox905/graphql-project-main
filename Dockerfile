FROM openjdk:20-ea-1-jdk-nanoserver
MAINTAINER baeldung.com
COPY target/graphql-project-0.0.1-SNAPSHOT.jar server-1.0.0.jar
ENTRYPOINT ["java","-jar","/server-1.0.0.jar"]