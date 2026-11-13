# Student Course Management System

## Project Description
The **Student Course Management System** is a simple console-based Java application developed to manage course information. It allows users to add courses, view available courses, search for a course, calculate total credit units, and save or load course records using file handling.

## Features
- Add new courses with course code, course title, and credit units.
- View all available courses.
- Search for a course using its course code.
- Calculate the total credit units of all courses.
- Save course records to a file.
- Load previously saved course records from a file.
- Exit the application.

## Technologies Used
- **Programming Language:** Java
- **Code Editor:** Visual Studio Code (VS Code)
- **Storage:** Text file (`courses.txt`)

## Project Structure

```text
StudentCourseManagement/
│
├── Course.java
├── StudentCourseManagement.java
├── courses.txt
└── README.md
```

## Requirements
To run this application, you need:
- Java Development Kit (JDK 17 or later).
- Visual Studio Code.
- Java extensions for VS Code.

## How to Run the Application

1. Open the project folder in Visual Studio Code.
2. Open the VS Code terminal.
3. Compile the Java files by running:

   ```bash
   javac Course.java StudentCourseManagement.java
   ```

4. Run the application:

   ```bash
   java StudentCourseManagement
   ```

5. Follow the menu displayed in the terminal to use the system.

## Concepts Demonstrated
This project demonstrates the use of:
- Classes and objects.
- Constructors and methods.
- Conditional statements.
- Loops.
- Recursion.
- Exception handling.
- File reading and writing.
- Java collections (`ArrayList`).

## File Storage
Course records are saved in a text file named `courses.txt`. The application can load previously saved records when the user selects the load option.

## Author
**Felix Priscillia**

## Course
COS 201 – Computer Programming 1

## Project Title
Student Course Management System