#Use a imagem Maven com Eclipse Temurin JDK 21
FROM maven:3.9.6-amazoncorretto-21 as build

#Define o diretório de trabalho
WORKDIR /app

#copia o arquivo pom.xml e os arquivos de origem
COPY . .


#Executa o comando Maven para compilar e empacotar
RUN mvn clean package -X -DskipTests 

#define a imagem base para a execução da aplicação
FROM openjdk:21-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./informacoes_turisricas-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar ./informacoes_turisricas-0.0.1-SNAPSHOT.jar