# Usar una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/PruebaDocker-0.0.1-SNAPSHOT.jar /app/PruebaDocker-0.0.1-SNAPSHOT.jar

# Exponer el puerto 8081
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/PruebaDocker-0.0.1-SNAPSHOT.jar"]