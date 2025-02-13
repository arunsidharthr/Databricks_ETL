# First stage: Build the application using Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Second stage: Create a smaller runtime image with JDK
FROM openjdk:17-alpine
WORKDIR /app

# Set the necessary Java options to handle permissions
ENV JDK_JAVA_OPTIONS="--add-opens=java.base/java.nio=ALL-UNNAMED \
                      --add-opens=java.base/java.lang.invoke=ALL-UNNAMED \
                      --add-opens=java.base/java.util=ALL-UNNAMED \
                      --add-opens=java.base/sun.nio.ch=ALL-UNNAMED \
                      -Dio.netty.tryReflectionSetAccessible=true"

# Set the Spark master URL for the container
ENV SPARK_MASTER_URL=spark://spark-master:7077

# Copy the JAR file built in the first stage
COPY --from=build /app/target/databricks_etl-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8081 (if needed)
EXPOSE 8081

# Run the application with the production profile
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]