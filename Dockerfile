FROM amazoncorretto:17-alpine-jdk

COPY target/app-auth-0.0.1-SNAPSHOT.jar app-auth.jar

ENTRYPOINT ["java","-jar","/app-auth.jar"]