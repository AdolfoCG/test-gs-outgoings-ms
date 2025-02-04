#Imagen
FROM alpine/java:17-jdk
#Puerto
EXPOSE 8082
#Directorio
WORKDIR /root
#Archivos
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root
#Dependencias
RUN ./mvnw dependency:go-offline
#Copiar código fuente
COPY ./src /root/src
#Construir app
RUN ./mvnw clean install -DskipTests
#Levantar App
ENTRYPOINT ["java", "-jar", "/root/target/test.gs.outgoings-0.0.1-SNAPSHOT.jar"]