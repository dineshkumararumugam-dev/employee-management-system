# employee-management-system
The Employee Management System is a Spring Boot REST API application that performs CRUD (Create, Read, Update, Delete) operations on employees and departments.

This project demonstrates backend development skills using Java, Spring Boot, REST APIs, and database integration.

It is designed as a beginner-friendly project for learning enterprise-level application architecture.

---

## Features

* Add Employee
* Update Employee
* Delete Employee
* Get Employee by ID
* Get All Employees
* Get Employees by Department
* Add Department
* Get All Departments
* Input Validation
* Exception Handling

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST API
* MySQL
* Maven
* Lombok

---

## Project Architecture

Layered Architecture:

Controller → Service → Repository → Database

---

## API Endpoints

### Department APIs

POST
/department

GET
/department

---

### Employee APIs

POST
/employees

PUT
/employees/{id}

GET
/employees

GET
/employees/{id}

GET
/employees/department/{departmentId}

DELETE
/employees/{id}

---

## Database Tables

Employee

* id
* name
* email
* phone
* salary
* department_id

Department

* id
* name
* location

---

## How to Run the Project

1. Install Java 17+
2. Install MySQL
3. Create database:

```sql
create database employee_db;
```

4. Update application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

5. Run the application

```bash
mvn spring-boot:run
```

---

## Future Improvements

* Add Swagger Documentation
* Add Login Authentication (Spring Security)
* Add Pagination
* Add Search API
* Add Frontend (React / Angular)

---

## Author

Dineshkumar
Java Full Stack Developer

  
