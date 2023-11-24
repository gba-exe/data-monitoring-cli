FROM openjdk:17-jdk-slim

WORKDIR /tmp

COPY ./target/data-monitoring-cli-3.0.1.jar .

