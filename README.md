📘 Employee Asset Management API

A Spring Boot REST API for managing employees and their assigned assets.

This project uses PostgreSQL as the database

🚀 Features

CRUD operations for Employees and Assets

API Key security configured via @Configuration (no database auth)

PostgreSQL integration with Spring Data JPA

.env file for environment configuration

Built using Spring Boot and Maven

📦 Technologies Used

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Maven

Lombok

java-dotenv (io.github.cdimascio:java-dotenv) for reading .env

⚙️ Getting Started

1️⃣ Clone the Repository

bash

git clone https://github.com/your-username/employee-asset-management.git

cd employee-asset-management

2️⃣ Create a .env File

Create a .env file in the project root with the following content


# Application port 

PORT=8081

# PostgreSQL configuration

DB_URL=jdbc:postgresql://localhost:5432/your_database

DB_USERNAME=your_db_username

DB_PASSWORD=your_db_password


3️⃣ Set Up PostgreSQL

Install and run PostgreSQL

Create a database matching the name in your .env

Ensure your .env username and password are correct

4️⃣ Build and Run the Project

🛠️ Build the project:

bash

mvn clean install

▶️ Run the application:

bash

mvn spring-boot:run

Or run the JAR file directly after build:

bash

java -jar target/employee-asset-management-0.0.1-SNAPSHOT.jar

🔐 API Key Authentication

All routes are protected using a custom API key mechanism defined in a @Configuration class in the config package.

📩 How to Use the API Key

Every request must include the x-api-key header:

makefile

x-api-key: your_api_key_value

Use this header in Postman or any REST client. The value must match the API_KEY set in your .env.

📮 Sample API Endpoints

GET	/api/employees	Get list of all employees

POST	/api/employees	Add a new employee

GET	/api/employees/{id}	Get employee by ID

GET	/api/employees/search	Search employees by name or email

POST	/api/assets	Add a new asset

GET	/api/assets/{id}	Get asset by ID

POST	/api/department	Add a new department

GET	/api/department/{id}	Get department by ID


🧪 Testing & Troubleshooting

Database connection error? Make sure PostgreSQL is running and .env values are correct.

401 Unauthorized? Double-check the x-api-key header in your requests.

App not starting? 

Ensure Java 17 and Maven are correctly installed and run mvn clean install first.

📜 License

This project is licensed under the MIT License.