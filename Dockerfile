FROM eclipse-temurin:19-jdk

WORKDIR /app

COPY target/manage-people-0.0.1-SNAPSHOT.jar /app/manage-people-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/manage-people-0.0.1-SNAPSHOT.jar"]
