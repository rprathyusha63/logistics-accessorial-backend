# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-oracle

# Set a working directory in the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/ServiceRate-0.0.1-SNAPSHOT.jar app.jar

# Inform Docker that the container listens on the specified network ports at runtime
#EXPOSE 8087

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
