FROM openjdk:20
MAINTAINER baeldung.com
COPY target/graphql-project-0.0.1-SNAPSHOT.jar server-1.0.0.jar
ENTRYPOINT ["java","-jar","/server-1.0.0.jar"]