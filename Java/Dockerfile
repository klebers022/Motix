# ===== Stage de build =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o projeto inteiro
COPY . .

# Compila e gera o JAR empacotado do Spring Boot (pula testes)
RUN mvn -B -e -DskipTests package spring-boot:repackage

# ===== Stage de runtime =====
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o JAR gerado do estágio de build
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]