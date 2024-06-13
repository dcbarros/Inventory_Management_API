FROM eclipse-temurin:21-alpine as build
WORKDIR /app

# Copiar arquivos necessários para o build do Maven
COPY ./mvnw .
COPY ./.mvn .mvn
COPY ./pom.xml .
COPY src src

# Instalar Maven e construir o projeto
RUN apk add --no-cache maven
RUN mvn wrapper:wrapper
RUN chmod +x ./mvnw
RUN ./mvnw install -DskipTests

# Construir a imagem final
FROM eclipse-temurin:21-alpine
WORKDIR /app

# Copiar o JAR gerado para a imagem final
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} ./app.jar

# Configurar o comando de inicialização
ENTRYPOINT ["java", "-jar", "./app.jar"]