# Student Database Management System using Hibernate

## 📌 Project Overview

The Student Database Management System is a Java-based application developed using Hibernate ORM and MySQL.

The main purpose of this project is to manage student-related information efficiently and perform database operations using Hibernate. The project demonstrates Object-Relational Mapping (ORM), entity relationships, CRUD operations, DAO implementation, and JPQL queries.

## 🎯 Objective

The objective of this project is to develop a simple and efficient student database management system that allows users to manage:

- Department details
- Course details
- Student details
- Teacher details
- Student address details

Hibernate is used to connect the Java application with the MySQL database and perform database operations.

## 🛠️ Technologies Used

- **Programming Language:** Java
- **ORM Framework:** Hibernate
- **Database:** MySQL
- **Build Tool:** Maven
- **IDE:** Eclipse
- **Query Language:** JPQL
- **Version Control:** Git & GitHub

## 🏗️ Project Architecture

The project follows a simple layered approach using Entity classes and DAO classes.

### Entity Classes

The project contains five main entity classes:

1. **Department**
2. **Course**
3. **Student**
4. **Teacher**
5. **Address**

### DAO Classes

DAO (Data Access Object) classes are used to perform database operations such as:

- Insert
- Retrieve
- Update
- Delete

## 🔗 Entity Relationships

The project contains the following relationships:

| Relationship | Type |
|---|---|
| Department → Course | One-to-Many (1:N) |
| Course → Student | One-to-Many (1:N) |
| Student → Teacher | One-to-Many (1:N) |
| Student → Address | One-to-One (1:1) |

### Relationship Explanation

- One **Department** can have multiple **Courses**.
- One **Course** can have multiple **Students**.
- One **Student** can have multiple **Teachers**.
- One **Student** has one **Address**.

## ✨ Features

- Add department details
- Add course details
- Add student details
- Add teacher details
- Add student address details
- Retrieve records from the database
- Update existing records
- Delete records
- Perform CRUD operations using Hibernate
- Manage entity relationships using Hibernate annotations
- Execute JPQL queries
- Integrate Java application with MySQL database

## 🗄️ Database

**MySQL** is used as the relational database.

Hibernate ORM is used to map Java entity classes to database tables.

The database contains tables corresponding to the entity classes:

- Department
- Course
- Student
- Teacher
- Address

## 📂 Project Structure

```text
Student-Database-Management-System-Hibernate
│
├── src
│   └── main
│       ├── java
│       │   └── Entity Classes
│       │       ├── Department.java
│       │       ├── Course.java
│       │       ├── Student.java
│       │       ├── Teacher.java
│       │       └── Address.java
│       │
│       │   └── DAO Classes
│       │       ├── DepartmentDao.java
│       │       ├── CourseDao.java
│       │       ├── StudentDao.java
│       │       ├── TeacherDao.java
│       │       └── AddressDao.java
│       │
│       └── resources
│           └── Hibernate Configuration
│
├── pom.xml
└── README.md


## CRUD Operations

The application supports the following database operations:

### Create

Add new departments, courses, students, teachers, and addresses.

### Read

Retrieve existing records from the database.

### Update

Modify existing records.

### Delete

Remove records from the database.

## 📚 Concepts Used

This project demonstrates the following concepts:

- Java
- Object-Oriented Programming
- Hibernate ORM
- Entity Mapping
- Hibernate Annotations
- One-to-One Mapping
- One-to-Many Mapping
- CRUD Operations
- DAO Pattern
- JPQL
- MySQL Database Connectivity
- Maven
- Git and GitHub

## 🚀 How to Run the Project

### Step 1: Clone the Repository

Clone this repository to your local system.

### Step 2: Open in Eclipse

Import the project into Eclipse as a Maven project.

### Step 3: Configure MySQL

Create the required MySQL database.

### Step 4: Configure Hibernate

Update the Hibernate configuration file with your database details.

> **Note:** Do not upload your actual database username or password to a public GitHub repository.

### Step 5: Update Maven Dependencies

Allow Maven to download the required Hibernate and database dependencies.

### Step 6: Run the Application

Run the main Java application from Eclipse.

## 📖 Learning Outcomes

Through this project, I gained practical knowledge of:

- Hibernate ORM framework
- Mapping Java objects with database tables
- Entity relationships
- CRUD operations
- DAO implementation
- JPQL queries
- MySQL database integration
- Maven project management
- Git and GitHub

## 🔮 Future Enhancements

The project can be enhanced in the future by adding:

- User login and authentication
- Student search functionality
- Pagination
- Web-based user interface
- Spring Boot integration
- REST APIs
- Student report generation
- Advanced search and filtering

## 👩‍💻 Author

**Kalaiselvi I**

Computer Science Engineering Student

### GitHub

**Kalaiselvi-project-work**

## 📄 License

This project is created for educational and learning purposes.



