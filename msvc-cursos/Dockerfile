FROM amazoncorretto:17.0.6 as builder

WORKDIR /app/msvc-cursos

#Copiar pom de parent
COPY ./pom.xml /app
#Wrapper de maven
COPY ./msvc-cursos/.mvn ./.mvn
#Ejecutable maven wrapper
COPY ./msvc-cursos/mvnw .
#POM del proyecto
COPY ./msvc-cursos/pom.xml .

#Sólo baja las dependencias
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#Copiar el código fuente
COPY ./msvc-cursos/src ./src

RUN ./mvnw clean package -DskipTests

#Se genera segunda imagen para sólo tener el jar y optimizar espacio
FROM amazoncorretto:17.0.6

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]