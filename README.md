# 🧑‍💻 User Registration Microservice

This microservice is responsible for registering user information into a PostgreSQL database and sending this information to another microservice via RabbitMQ for further processing (such as sending a welcome email). The project uses Java with Spring Boot, CloudAMQP for message brokering, and Gmail's SMTP for email services.

![1](https://github.com/user-attachments/assets/7abfbfbe-2d36-4d1f-a4e7-074b69fe3a73)
![2](https://github.com/user-attachments/assets/4d39e130-023f-4a00-8ae7-9ff463b23999)
![3](https://github.com/user-attachments/assets/b6e7bc9b-9935-47bc-a072-09163af4408a)


## 🚀 Technologies

- **Java** ☕
- **Spring Boot** 🌱
  - Spring Web 🌐
  - Spring Data JPA 🗄️
  - Spring AMQP 🐇
  - Spring Validation ✅
  - Spring Mail 📧
- **RabbitMQ** 🐰
- **CloudAMQP** ☁️
- **PostgreSQL** 🐘
- **Maven** 📦

## 💡 Key Features

- **User Registration**: Validates and stores user information in a PostgreSQL database.
- **Message Queue**: Sends user data to another microservice through RabbitMQ for additional processing.
- **Error Handling**: Proper validation and error handling for robust user data management.

## 🛠️ Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-username/user-microservice.git
cd user-microservice
```

### 2. Install dependencies
```bash
mvn clean install
```

### 3. Configure the environment variables

Make sure to configure the following environment variables:

- `DB_URL`: PostgreSQL database connection URL 🐘
- `DB_USERNAME`: PostgreSQL username 🗝️
- `DB_PASSWORD`: PostgreSQL password 🔐
- `RABBITMQ_URL`: CloudAMQP connection URL 🐇
- `MAIL_USERNAME`: Gmail SMTP username 📧
- `MAIL_PASSWORD`: Gmail SMTP password 🔑

You can add them to your `.env` file:

```bash
DB_URL=jdbc:postgresql://localhost:5432/userdb
DB_USERNAME=your-username
DB_PASSWORD=your-password
RABBITMQ_URL=amqps://your-cloudamqp-url
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-email-password
```
### 4. Run the application

```bash
mvn spring-boot:run
```

### 5. Database migration (optional)

If you need to initialize or migrate the PostgreSQL database schema, use the following commands:

```bash
mvn flyway:migrate
```

## 📬 API Endpoints

- `POST /api/v1/users`: Register a new user
  - **Request Body**: 
    ```json
    {
      "name": "John Doe",
      "email": "johndoe@example.com"
    }
    ```
  - **Response**: 
    ```json
    {
      "message": "User successfully registered",
      "userId": 123
    }
    ```

## ⚡ Message Queue

Once a user is registered, the user data is published to a RabbitMQ queue. The message structure is as follows:

```json
{
  "userId": 123,
  "email": "johndoe@example.com",
  "message": "Welcome to our platform!"
}
```
## ✅ Validation

The microservice uses **Spring Validation** to ensure that the provided data is correct:

- `name`: Must not be empty and must contain at least 2 characters.
- `email`: Must be a valid email format.

## 📋 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
