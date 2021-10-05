#! /bin/sh

cd ./employee-service
mvn clean package -DskipTests
docker build -t employee-service:latest .
cd ..

