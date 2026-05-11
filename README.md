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


Services Overview
2. Telecom Usage Service
Handles telecom recharge and usage tracking.
Features

Recharge wallet
Consume balance
Recharge history tracking
Usage tracking
Wallet deduction via Feign Client

Endpoints
MethodEndpointDescriptionPOST/usage/rechargeRecharge walletPOST/usage/consumeConsume balanceGET/usage/{customerId}Get usage by customer

3. Investment Service
Handles investment plans and customer investments.
Features

Create investment plans
Fetch available plans
Invest in plans
Redeem investments
Fetch customer investments

Endpoints
MethodEndpointDescriptionPOST/plansCreate an investment planGET/plansFetch available plansPOST/investInvest in a planPOST/redeemRedeem an investmentGET/investments/{customerId}Get investments by customer

4. Portfolio Service
Aggregates data from multiple services into a unified dashboard.
Features

Fetch customer data via Feign
Fetch telecom usage via Feign
Fetch investment data via Feign
Aggregate dashboard response

Endpoints
MethodEndpointDescriptionGET/portfolio/{customerId}Get aggregated portfolio dashboard

5. API Gateway
Central entry point for all client requests.
Features

Request routing
JWT validation
Unauthorized request blocking
Public authentication endpoints

Public Routes
/auth/**

Service Communication
The platform uses:

Eureka Server for service discovery
OpenFeign for inter-service communication
JWT for secure authentication
Gateway routing for centralized API access


Frontend Flow

Frontend communicates only with API Gateway
JWT token stored after login
Dashboard fetched from Portfolio Service
Recharge and investment actions routed via Gateway


Tech Stack
Backend

Java
Spring Boot
Spring Security
Spring Cloud Gateway
Spring Data JPA
OpenFeign
Eureka Discovery Server
JWT Authentication

Database

MySQL / PostgreSQL

DevOps

Docker
Maven


Project Structure
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

Running the Project
Clone Repository
bashgit clone <repo-url>
cd telecom-digital-wealth-platform
Start Eureka Server
bashcd eureka-server
mvn spring-boot:run
Start Services
Run each microservice individually:
bashmvn spring-boot:run

Services will automatically register with Eureka.

Start API Gateway
bashcd api-gateway
mvn spring-boot:run

MVP Completion Checklist

 Customer register/login works
 Wallet deduction works
 Investment functionality works
 Portfolio aggregation works
 Gateway routing works
 All services visible in Eureka


Security

JWT-based authentication
Password encryption using BCrypt
Gateway-level authorization


Future Enhancements

Kafka Event Streaming
Real-time notifications
Advanced analytics dashboard
AI-based investment recommendations
Kubernetes deployment
CI/CD pipelines
Role-based access control


Authors
Developed as a cloud-native microservices MVP project for scalable telecom and digital wealth operations.
