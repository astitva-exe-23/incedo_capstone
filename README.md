# Telecom Digital Wealth Platform — MVP

A microservices-based Telecom Digital Wealth Platform built using Spring Boot and cloud-native architecture principles.  
This project combines telecom wallet usage, recharge systems, investment plans, and portfolio aggregation into a unified digital wealth ecosystem.

Based on the MVP functional specification. :contentReference[oaicite:0]{index=0}

---

# Architecture Overview

The system follows a distributed microservices architecture with:

- Spring Boot Microservices
- Spring Cloud Gateway
- Eureka Service Discovery
- JWT Authentication
- OpenFeign Inter-Service Communication
- MySQL/PostgreSQL Databases
- REST APIs
- Docker-ready deployment structure

---

# Microservices

## 1. Customer Service

Handles customer authentication, wallet management, and profile operations.

### Features

- Customer registration
- Customer login
- JWT authentication
- Encrypted password storage
- Wallet balance management
- Customer profile retrieval

### Endpoints

```http
POST /auth/register
POST /auth/login
GET /customers/{id}
GET /customers/{id}/wallet
PUT /customers/{id}/wallet/deduct
```
# Telecom Digital Wealth Platform

A cloud-native microservices MVP for scalable telecom and digital wealth operations.

---

## Services Overview

### 2. Telecom Usage Service

Handles telecom recharge and usage tracking.

**Features**
- Recharge wallet
- Consume balance
- Recharge history tracking
- Usage tracking
- Wallet deduction via Feign Client

**Endpoints**

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/usage/recharge` | Recharge wallet |
| POST | `/usage/consume` | Consume balance |
| GET | `/usage/{customerId}` | Get usage by customer |

---

### 3. Investment Service

Handles investment plans and customer investments.

**Features**
- Create investment plans
- Fetch available plans
- Invest in plans
- Redeem investments
- Fetch customer investments

**Endpoints**

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/plans` | Create an investment plan |
| GET | `/plans` | Fetch available plans |
| POST | `/invest` | Invest in a plan |
| POST | `/redeem` | Redeem an investment |
| GET | `/investments/{customerId}` | Get investments by customer |

---

### 4. Portfolio Service

Aggregates data from multiple services into a unified dashboard.

**Features**
- Fetch customer data via Feign
- Fetch telecom usage via Feign
- Fetch investment data via Feign
- Aggregate dashboard response

**Endpoints**

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/portfolio/{customerId}` | Get aggregated portfolio dashboard |

---

### 5. API Gateway

Central entry point for all client requests.

**Features**
- Request routing
- JWT validation
- Unauthorized request blocking
- Public authentication endpoints

**Public Routes**
## Service Communication

The platform uses:

- **Eureka Server** for service discovery
- **OpenFeign** for inter-service communication
- **JWT** for secure authentication
- **Gateway routing** for centralized API access

---

## Frontend Flow

1. Frontend communicates only with API Gateway
2. JWT token stored after login
3. Dashboard fetched from Portfolio Service
4. Recharge and investment actions routed via Gateway

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Cloud Gateway
- Spring Data JPA
- OpenFeign
- Eureka Discovery Server
- JWT Authentication

### Database
- MySQL / PostgreSQL

### DevOps
- Docker
- Maven

---

## Project Structure
telecom-digital-wealth-platform/
│
├── api-gateway/
├── customer-service/
├── usage-service/
├── investment-service/
├── portfolio-service/
├── eureka-server/
│
└── README.md

---

## Running the Project

### Clone Repository

```bash
git clone <repo-url>
cd telecom-digital-wealth-platform
```

### Start Eureka Server

```bash
cd eureka-server
mvn spring-boot:run
```

### Start Services

Run each microservice individually:

```bash
mvn spring-boot:run
```

> Services will automatically register with Eureka.

### Start API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

---

## MVP Completion Checklist

- [x] Customer register/login works
- [x] Wallet deduction works
- [x] Investment functionality works
- [x] Portfolio aggregation works
- [x] Gateway routing works
- [x] All services visible in Eureka

---

## Security

- JWT-based authentication
- Password encryption using BCrypt
- Gateway-level authorization

---

## Future Enhancements

- Kafka Event Streaming
- Real-time notifications
- Advanced analytics dashboard
- AI-based investment recommendations
- Kubernetes deployment
- CI/CD pipelines
- Role-based access control

---

## Authors

Developed as a cloud-native microservices MVP project for scalable telecom and digital wealth operations.
