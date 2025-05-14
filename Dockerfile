FROM openjdk:17-alpine AS builder

WORKDIR /app

# Copia los archivos pom.xml y src para aprovechar la caché de Maven
# COPY pom.xml ./
# COPY mvnw ./
# COPY src ./src

COPY . .

RUN chmod +x ./mvnw

# Descarga las dependencias de Maven
RUN ./mvnw dependency:go-offline -B

# Empaqueta la aplicación Spring Boot
RUN ./mvnw package -DskipTests

# --- Segunda etapa: Imagen de ejecución ---
FROM openjdk:17-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR empaquetado desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto en el que se ejecuta la aplicación Spring Boot (ajusta si es necesario)
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
