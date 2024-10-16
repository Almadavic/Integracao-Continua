# Etapa de build - Criada imagem enxuta apenas para gerar o .jar
FROM eclipse-temurin:19-jdk AS build

# Onde será criada a pasta com o app
WORKDIR /app

# Instalar o Maven
RUN apt-get update && apt-get install -y maven

# Copiar o pom.xml e as dependências para cacheamento
COPY pom.xml .
COPY src ./src

# Executar o build do projeto
RUN mvn clean package

# Etapa de execução
FROM eclipse-temurin:19-jre-alpine

WORKDIR /app

# Copiar o JAR gerado na etapa de build
COPY --from=build /app/target/manage-people-0.0.1-SNAPSHOT.jar /app/manage-people-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/manage-people-0.0.1-SNAPSHOT.jar"]
