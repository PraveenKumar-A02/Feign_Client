# Feign Client Demo

This project demonstrates how to use **Spring Cloud OpenFeign** to enable communication between two microservices: **course-service** and **student-service**.

---

## 🚀 Overview

* **Course-Service (Provider)** → Exposes REST APIs to provide course details.
* **Student-Service (Consumer)** → Uses Feign Client to consume Course-Service APIs.

Communication is established using **Feign Client**, avoiding boilerplate `RestTemplate` code.

---

## 🏗️ Architecture

```
User → Student-Service (8082) → Feign Client → Course-Service (8081) → JSON Response
```

* Student-Service exposes `/students/courses` and `/students/courses/{id}`.
* Internally, Student-Service uses Feign Client to call Course-Service APIs (`/courses` and `/courses/{id}`).
* Course data is returned to the User via Student-Service.

---

## 📂 Project Structure

```
Feign_Client_Demo-main/
├── course-service/         # Provides course data
│   ├── controller/         # Course REST endpoints
│   ├── dto/                # Course & Rating DTOs
│   ├── service/            # Business logic
│   ├── resources/          # application.properties + courses.json
│
└── student-service/        # Consumes course data using Feign
    ├── client/             # Feign client + wrapper service
    ├── controller/         # Student REST endpoints
    ├── dto/                # Mirrors Course DTOs
    ├── service/            # Business logic
    ├── resources/          # application.properties + application.yml
```

---

## ⚙️ Setup & Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Feign_Client_Demo.git
cd Feign_Client_Demo-main
```

### 2. Run Course-Service

```bash
cd course-service
mvn spring-boot:run
```

Course-Service will start on **`http://localhost:8081`**.

### 3. Run Student-Service

```bash
cd student-service
mvn spring-boot:run
```

Student-Service will start on **`http://localhost:8082`**.

---

## 📌 API Endpoints

### Course-Service (Provider)

* `GET /courses` → Get all courses
* `GET /courses/{id}` → Get course by ID

### Student-Service (Consumer)

* `GET /students/courses` → Fetch all courses (via Feign)
* `GET /students/courses/{id}` → Fetch course by ID (via Feign)

---

## 📝 Example Request & Response

### Request (to Student-Service):

```http
GET http://localhost:8082/students/courses
```

### Response:

```json
[
  {
    "id": 101,
    "name": "Spring Boot",
    "price": 499.99,
    "rating": { "rate": 4, "count": 120 }
  },
  {
    "id": 102,
    "name": "Microservices",
    "price": 699.99,
    "rating": { "rate": 5, "count": 200 }
  }
]
```

---

## 🔑 Key Learnings

* **Feign Client** simplifies inter-service communication.
* Eliminates boilerplate REST client code.
* Provides a declarative way to call REST APIs between microservices.
* Easy integration with service discovery (Eureka) and load balancing.

---

## 📖 Tech Stack

* Java 21+
* Spring Boot
* Spring Cloud OpenFeign
* Maven

---




