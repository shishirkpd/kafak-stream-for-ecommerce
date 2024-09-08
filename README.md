# E-Commerce Event-Driven System with Kafka Streams and Spring Boot

This project demonstrates an event-driven e-commerce system built using Kafka Streams and Spring Boot. The system is designed to process orders in real-time, update inventory, and send notifications using a microservice architecture.

## Features
- **Real-Time Order Processing**: Orders are processed as soon as they are placed.
- **Inventory Management**: Inventory is updated in real-time based on incoming orders.
- **Order Notifications**: Notifications are sent for each processed order.
- **Event-Driven Architecture**: Asynchronous communication between services using Kafka topics.

## Project Structure

This project contains three main services:
1. **Order Service**: Accepts new orders via a REST API and publishes them to Kafka.
2. **Inventory Service**: Listens for order events and updates inventory accordingly.
3. **Notification Service**: Listens for processed orders and sends notifications to customers.

### Kafka Topics
- `orders`: Topic to receive new orders.
- `processed-orders`: Topic where processed orders are sent after handling.
- `inventory-updated`: Topic where inventory updates are published.
- `notifications`: Topic where order notifications are sent.

## Prerequisites

Before running this project, ensure that you have the following:
1. **Kafka**: Install and configure Apache Kafka and ensure it's running locally on `localhost:9092`.
2. **Java**: Java 11 or higher.
3. **Maven**: To build and run the project.

### Installing Kafka Locally

You can follow [this guide](https://kafka.apache.org/quickstart) to install Kafka on your local machine.

## Running the Application

### Step 1: Clone the Repository
```bash
git clone https://github.com/shishirkpd/kafak-stream-for-ecommerce.git
cd kafak-stream-for-ecommerce
```

### Step 2: Set Up Kafka Topics
Make sure the necessary Kafka topics are created. Run the following commands to create the topics:

```bash
# Create topics for orders, processed orders, inventory updates, and notifications
kafka-topics.sh --create --topic orders --bootstrap-server localhost:9092
kafka-topics.sh --create --topic processed-orders --bootstrap-server localhost:9092
kafka-topics.sh --create --topic inventory-updated --bootstrap-server localhost:9092
kafka-topics.sh --create --topic notifications --bootstrap-server localhost:9092
```
### Step 3: Build the Project
Use Maven to build the project:

```bash
mvn clean install
```
### Step 4: Run the Application
Once the project is built, you can run it using Maven:

```bash
mvn spring-boot:run
```

### Step 5: Placing an Order
You can place an order by making a POST request to the /orders endpoint. Here's an example request using curl:

```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
  "orderId": "1001",
  "product": "Laptop",
  "quantity": 2,
  "price": 1500.00
}'
```
Alternatively, you can use Postman or any other REST client to send the request.

