-- Use yesterday's database
USE day01_practice;

-- Create departments table
CREATE TABLE departments(
dept_id INT PRIMARY KEY AUTO_INCREMENT,
dept_name VARCHAR(100),
location VARCHAR(100)
);

-- Insert departments
INSERT INTO departments(dept_name, location) VALUES
('Computer Science', 'Block A'),
('Mechanical', 'Block B'),
('Electrical', 'Block C'),
('Civil', 'Block D');

-- Add dept_id to students table
ALTER TABLE students ADD COLUMN dept_id INT;

-- Update students with dept_id
UPDATE students SET dept_id = 1 WHERE course = 'Computer Science';
UPDATE students SET dept_id = 2 WHERE course = 'Mechanical';
UPDATE students SET dept_id = 3 WHERE course = 'Electrical';
UPDATE students SET dept_id = 4 WHERE course = 'Civil';

-- INNER JOIN - students with their departments
SELECT students.name, students.age, departments.dept_name,departments.location
FROM students
INNER JOIN departments ON students.dept_id = departments.dept_id;

-- LEFT JOIN - all students (even if no department)
SELECT students.name,departments.dept_id
FROM students
LEFT JOIN departments ON students.dept_id = departments.dept_id;

-- Count students per department
SELECT departments.dept_name,COUNT(students.id) as student_count
FROM departments
LEFT JOIN students ON departments.dept_id = students.dept_id
GROUP BY departments.dept_name;

-- Students with department location
SELECT students.name, students.course, departments.location
FROM students 
INNER JOIN departments ON students.dept_id = departments.dept_id
WHERE departments.location = 'Block A';

-- Average age per department
SELECT AVG(students.age) as avg_age, departments.dept_name
FROM students 
INNER JOIN
departments ON students.dept_id = departments.dept_id
GROUP BY departments.dept_name;

-- Get students 'from block b'
SELECT students.name, departments.location
FROM students
INNER JOIN departments ON students.dept_id = departments.dept_id
WHERE departments.location = 'Block B';

-- adding student with location block b
INSERT INTO students (name, age, course, email, city, dept_id) VALUES
('Shubham', 24, 'Computer Science','xyyyz@gmail.com','Gwalior',2); 

-- count students in each location
SELECT COUNT(students.id) as noOfStudents ,departments.location
FROM students
INNER JOIN departments ON students.dept_id = departments.dept_id
GROUP BY departments.location;

-- find departments with more than 2 students
SELECT departments.dept_name, COUNT(students.id) AS noofStudents
FROM students 
INNER JOIN departments ON students.dept_id = departments.dept_id
GROUP BY departments.dept_name
HAVING noofstudents > 2;