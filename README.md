# Job Listing Application Backend (Spring Boot + MongoDB)

This repository contains the backend code for a simple job listing application built using **Spring Boot** and **MongoDB**. The application allows employers to post job listings and job seekers to search for available jobs based on various criteria.

## Table of Contents
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Setup and Installation](#setup-and-installation)
- [API Endpoints]
- [Search Functionality]
- [MongoDB Aggregation]

## Tech Stack
- **Backend**: Spring Boot (Java)
- **Database**: MongoDB (MongoDB Atlas for cloud-based storage)
- **REST API**: Spring REST Controllers
- **Data Mapping**: MongoDB Spring Data
- **Search**: MongoDB Aggregation
- **Frontend (CORS enabled)**: React (or any frontend hosted at `localhost:3000`)

## Features
- **Create Job Postings**: Employers can add new job posts with details such as job profile, description, experience required, and technologies needed.
- **Search Job Postings**: Job seekers can search job listings based on keywords like job profile, description, and technologies.
- **RESTful API**: Backend exposes REST API endpoints for interacting with the job listings.

## Setup and Installation

### Prerequisites
To run this project locally, you will need:
- Java (version 8 or above)
- Maven
- MongoDB (either local or MongoDB Atlas)

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/job-listing-backend.git
   cd job-listing-backend
2. **Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
