# Stage 1: Build mã nguồn bằng Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Môi trường chạy ứng dụng siêu nhẹ (JRE)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/redirect-0.0.1-SNAPSHOT.jar app.jar

# Expose Cổng 80 (Đã cấu hình trong application.properties)
EXPOSE 80

# Lệnh khởi chạy Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
