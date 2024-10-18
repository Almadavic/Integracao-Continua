# Etapa de execução
FROM eclipse-temurin:19-jre-alpine

WORKDIR /app

# Copiar o JAR gerado na etapa de build
COPY target/manage-people-0.0.1-SNAPSHOT.jar ./manage-people-0.0.1-SNAPSHOT.jar

EXPOSE 80

CMD ["java", "-jar", "/app/manage-people-0.0.1-SNAPSHOT.jar"]
