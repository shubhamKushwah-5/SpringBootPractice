CREATE DATABASE day01_practice;

USE day01_practice;

CREATE TABLE students (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
age INT,
course VARCHAR(50),
email VARCHAR(100),
city VARCHAR(50)

);

INSERT INTO students(name, age , course, email, city) VALUES
('Rahul Kumar', 22, 'Computer Science', 'rahul@email.com', 'Delhi'),
('Priya Sharma', 21, 'Mechanical', 'priya@email.com', 'Mumbai'),
('Amit Singh', 23, 'Electrical', 'amit@email.com', 'Bangalore'),
('Sneha Patel', 20, 'Civil', 'sneha@email.com', 'Pune'),
('Vikram Reddy', 22, 'Computer Science', 'vikram@email.com', 'Hyderabad'),
('Anjali Mehta', 21, 'Computer Science', 'anjali@email.com', 'Chennai'),
('Rohan Gupta', 24, 'Mechanical', 'rohan@email.com', 'Delhi'),
('Divya Iyer', 22, 'Electrical', 'divya@email.com', 'Mumbai'),
('Karthik Nair', 23, 'Computer Science', 'karthik@email.com', 'Kochi'),
('Pooja Desai', 21, 'Civil', 'pooja@email.com', 'Ahmedabad');

-- 1. Get all students
SELECT * FROM students;

-- 2. Get only names and courses
SELECT name,course FROM students;

-- 3. Get students older than 21
SELECT * FROM students WHERE age>21;

-- 4. Get Computer Science students
SELECT * FROM students WHERE course = "Computer Science";

-- 5. Get students from Delhi
SELECT * FROM students WHERE city = "Delhi";

-- 6. Count total students
SELECT COUNT(*) AS  total_students FROM students;

-- 7. Count students per course
SELECT course, COUNT(*) as student_count
FROM Students
GROUP BY course;

-- 8. Get average age
SELECT AVG(age) as average_age FROM students;

-- 9. Get oldest student
SELECT * FROM students ORDER BY age DESC LIMIT 1;

-- 10. Get students aged 21 or 22
SELECT * FROM students WHERE age IN(21,22);

-- 11. Get students whose name starts with 'A'
SELECT * FROM students WHERE name LIKE 'A%';

-- 12. Get students sorted by name
SELECT * FROM students ORDER BY name ASC;

-- 13. Update a student's age
UPDATE students SET age = 25 WHERE name = 'Rahul Kumar';

-- 14. Delete a student
DELETE FROM students WHERE name = 'Rohan Gupta';

-- 15. Verify changes
SELECT * FROM students;
