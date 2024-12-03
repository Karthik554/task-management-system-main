HR Task Management App

Project Overview
The HR Task Management App is a full-stack application designed to streamline task management and communication between HR and employees. This app aims to simplify the assignment, monitoring, and completion of tasks within an organization.

App Explanation
The application has two primary user roles:

HR Role:
Task Assignment: HR can assign tasks to employees and set deadlines.
Employee Management: HR can add or remove employees from the system.
Task Management: HR can delete tasks and track progress.
Communication: HR can interact with employees to clarify tasks or provide updates.
Employee Role:
Task Viewing: Employees can log in to view their assigned tasks.
Progress Tracking: Employees can monitor task deadlines and updates.
Communication: Employees can communicate with HR to ask questions or provide status updates.
Technologies Used

Frontend: Angular
Backend: Spring Boot
Database: MySQL
API Testing: Postman
Setup Instructions

Clone Repository
bash

git clone https://github.com/your-username/hr-task-management-app.git  
Backend Setup
bash

cd backend  
./mvnw spring-boot:run  
Frontend Setup
bash

cd frontend  
npm install  
ng serve  
Database Setup
Create a MySQL database:
sql

CREATE DATABASE hr_task_management;  
Configure credentials in application.properties.
API Testing
Use Postman to test API endpoints.
Team Members

Kaushik (AM.EN.U4CSE21078): Frontend (Angular, designed web pages)
Karthik (AM.EN.U4CSE21072): Backend (Spring Boot, API testing)
Sabhya (AM.EN.U4CSE21080): Backend (Spring Boot, API testing)
Raghu (AM.EN.U4CSE21068): Database connection (MySQL, backend integration)
