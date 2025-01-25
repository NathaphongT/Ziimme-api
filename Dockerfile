# Official Images for Maven
FROM maven:3.9.9-amazoncorretto-8-alpine AS builder

# Set the Current Working Directory inside the container
WORKDIR /opt/app

# Copy the source from the current directory to the Working Directory inside the container
COPY . .

# Install dependencies and convert mvnw to Unix format, then grant execute permission
RUN apk add --no-cache ca-certificates \
  && update-ca-certificates 

# Run the Maven wrapper to build the project
RUN mvn clean package

# Official Images for Maven
FROM eclipse-temurin:21.0.5_11-jre-alpine

# Set the Current Working Directory inside the container
WORKDIR /opt/app

# Install dependencies and convert mvnw to Unix format, then grant execute permission
RUN apk add --no-cache ca-certificates \
  && update-ca-certificates

# Create a non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy the source from the current directory to the Working Directory inside the container
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar

# Change ownership of the binary
RUN chown appuser:appgroup /opt/app/*.jar

# Switch to the non-root user
USER appuser

# Set expose port
EXPOSE 8080

# Command line for run java app
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]