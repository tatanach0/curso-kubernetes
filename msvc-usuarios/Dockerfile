FROM amazoncorretto:17.0.6 as builder

WORKDIR /app/msvc-usuarios

#Copiar pom de parent
COPY ./pom.xml /app
#Wrapper de maven
COPY ./msvc-usuarios/.mvn ./.mvn
#Ejecutable maven wrapper
COPY ./msvc-usuarios/mvnw .
#POM del proyecto
COPY ./msvc-usuarios/pom.xml .

#Sólo baja las dependencias
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#Copiar el código fuente
COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

#Se genera segunda imagen para sólo tener el jar y optimizar espacio
FROM amazoncorretto:17.0.6

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ENV PORT 8000
EXPOSE $PORT

CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]