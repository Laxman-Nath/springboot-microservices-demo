# Spring Boot Microservices Demo

## Overview
A simple learning project demonstrating two Spring Boot microservices communicating via **OpenFeign**.

- **Course Service** (Port 8081): Manages course data and exposes REST APIs.  
- **Student Service** (Port 8082): Fetches student data and calls Course Service using Feign Client.

---

## Running the Project

1. Clone the repo:
```bash
git clone https://github.com/Laxman-Nath/springboot-microservices-demo.git
cd springboot-microservices-demo


cd course-service
mvn spring-boot:run

cd ../student-service
mvn spring-boot:run
