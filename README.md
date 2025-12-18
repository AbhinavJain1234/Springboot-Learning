# Spring Boot Learning Project

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Framework-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-Programming-orange.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)](https://www.postgresql.org/)

**Technologies Used**

- **Spring Boot** - Application framework
- **Spring Web** - REST API development
- **Spring Data JPA** - Database abstraction
- **PostgreSQL** - Database
- **Lombok** - Boilerplate code reduction
- **ModelMapper** - Object mapping
- **Jakarta Validation** - Input validation
- **Maven** - Dependency managementsvg)](https://www.oracle.com/java/)


A comprehensive **Spring Boot learning project** designed to help beginners understand fundamental concepts through practical examples and detailed comments. This project covers dependency injection, REST APIs, database integration, and Spring Boot best practices.

## **What You'll Learn**

### Core Spring Boot Concepts
- **Dependency Injection** - Field vs Constructor injection
- **Auto Configuration** - How Spring Boot magic works
- **Component Scanning** - Automatic bean discovery
- **Conditional Beans** - Configuration-driven component selection
- **Property Configuration** - External configuration management

### Web Development
- **REST API Development** - Complete CRUD operations
- **Request Mapping** - Handling HTTP methods (GET, POST, PUT, DELETE, PATCH)
- **Path Variables & Parameters** - URL data extraction
- **Request/Response Handling** - JSON serialization/deserialization
- **Validation** - Input validation with annotations

### Database Integration
- **Spring Data JPA** - Database abstraction layer
- **Entity Relationships** - ORM concepts
- **Repository Pattern** - Data access abstraction
- **Database Configuration** - PostgreSQL integration

## **Project Structure**

```
src/
├── main/
│   ├── java/com/abhinavjain/projectone/Project_1/
│   │   ├── Project1Application.java              # Main application class
│   │   ├── controller/                           # REST Controllers
│   │   │   ├── WelcomeController.java           # Basic web concepts
│   │   │   └── StudentController.java           # CRUD operations
│   │   ├── learningRestAPI/                     # Complete REST API example
│   │   │   ├── controller/StudentController.java
│   │   │   ├── service/StudentService.java
│   │   │   ├── repository/StudentRepository.java
│   │   │   ├── entity/Student.java
│   │   │   └── dto/StudentDto.java
│   │   └── understandingBeans/                  # Dependency Injection examples
│   │       ├── PaymentService.java              # Interface
│   │       ├── RazorPayPaymentService.java      # Implementation 1
│   │       └── StripePaymentService.java        # Implementation 2
│   └── resources/
│       └── application.properties               # Configuration with examples
└── test/                                        # Unit tests
```

## **Quick Start**

### Prerequisites
- **Java** (latest recommended)
- **Maven** (build tool)
- **PostgreSQL** (optional - for database features)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### 1. Clone the Repository
```bash
git clone https://github.com/AbhinavJain1234/Springboot-Learning.git
cd Springboot-Learning
```

### 2. Database Setup (Optional)
```sql
-- Create database
CREATE DATABASE studentDB;
```

### 3. Run the Application
```bash
# Using Maven
./mvnw spring-boot:run

# Or using your IDE
# Run Project1Application.java
```

### 4. Test the Application
```bash
# Welcome endpoint
curl http://localhost:8080/

# Hello World
curl http://localhost:8080/hello

# Application info
curl http://localhost:8080/info
```

## **Learning Path**

### Beginner Level
1. **Start with WelcomeController** (`/controller/WelcomeController.java`)
   - Basic request mapping
   - Path variables and parameters
   - JSON responses

2. **Understand Dependency Injection** (`/understandingBeans/`)
   - Interface-based programming
   - Multiple implementations
   - Configuration-driven selection

3. **Explore Configuration** (`application.properties`)
   - Property injection
   - Environment-specific configs
   - Database configuration

### Intermediate Level
4. **REST API Development** (`/learningRestAPI/`)
   - Complete CRUD operations
   - Request validation
   - Error handling
   - HTTP status codes

5. **Database Integration**
   - JPA entities and relationships
   - Repository patterns
   - Query methods

## **API Endpoints**

### Basic Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Welcome page with navigation |
| GET | `/hello` | Simple hello world |
| GET | `/hello/{name}` | Personalized greeting |
| GET | `/info` | Application information |
| GET | `/time` | Current server time |
| POST | `/echo` | Echo request data |

### Student CRUD API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Create new student |
| PUT | `/students/{id}` | Update student (full) |
| PATCH | `/students/{id}` | Update student (partial) |
| DELETE | `/students/{id}` | Delete student |

### Example Requests

**Create Student:**
```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 25
  }'
```

**Get All Students:**
```bash
curl http://localhost:8080/students
```

## **Configuration Examples**

### Payment Provider Selection
Switch between payment providers using configuration:

```properties
# Use RazorPay (for Indian market)
payment.provider=razorpay

# Use Stripe (for global market)
payment.provider=stripe
```

### Database Configuration
```properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/studentDB

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## **Key Learning Resources**

### File-by-File Learning Guide

1. **Project1Application.java** - Application entry point and DI concepts
2. **WelcomeController.java** - Basic web development
3. **PaymentService.java** - Interface design and multiple implementations
4. **StudentController.java** - Complete REST API patterns
5. **application.properties** - Configuration management

### Important Annotations Explained

| Annotation | Purpose | Example Usage |
|------------|---------|---------------|
| `@SpringBootApplication` | Main app configuration | Entry point class |
| `@RestController` | REST endpoint handler | Controller classes |
| `@Service` | Business logic layer | Service classes |
| `@Repository` | Data access layer | Repository interfaces |
| `@Component` | Generic Spring bean | Utility classes |
| `@Autowired` | Dependency injection | Field/constructor injection |
| `@Value` | Property injection | Configuration values |
| `@RequestMapping` | URL mapping | Controller methods |
| `@Valid` | Input validation | DTO validation |

## **Technologies Used**

- **Spring Boot 3.5.6** - Application framework
- **Spring Web** - REST API development
- **Spring Data JPA** - Database abstraction
- **PostgreSQL** - Database
- **Lombok** - Boilerplate code reduction
- **ModelMapper** - Object mapping
- **Jakarta Validation** - Input validation
- **Maven** - Dependency management

## **Author**

**Abhinav Jain**
- GitHub: [@AbhinavJain1234](https://github.com/AbhinavJain1234)
- Project: [Springboot-Learning](https://github.com/AbhinavJain1234/Springboot-Learning)

## **Acknowledgments**

- Spring Boot team for the amazing framework
- Java community for continuous support
- All contributors who help improve this learning resource

---

⭐ **Star this repository if it helped you learn Spring Boot!**

🐛 **Found an issue?** Please create an issue to help improve this learning resource.

💡 **Have suggestions?** Feel free to open a discussion or submit a pull request.
