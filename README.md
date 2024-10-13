**Email Service Microservice**
**Overview**
  The Email Service Microservice is a Spring Boot-based application designed to handle email sending operations. 
  This service listens to Kafka topics for email event notifications and sends emails based on the event data. 
  The emails are sent using the Gmail SMTP server, with the sender's credentials securely managed using Spring's @Value annotation to retrieve values from configuration properties.
  
**Features**
Kafka Consumer: Listens for email event messages from a Kafka topic and processes the event to send an email.
SMTP Email Sending: Uses Gmail’s SMTP server to send emails.

**Prerequisites**
To run this project, you need:
Java 11 or higher
Maven
Kafka installed and running (for Kafka-based communication)
A Gmail account with App Password configured for sending emails
