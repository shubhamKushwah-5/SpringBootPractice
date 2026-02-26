USE day01_practice;

-- Create enrollments table(students enrolled in courses)
CREATE TABLE enrollments (
id INT PRIMARY KEY AUTO_INCREMENT,
student_id INT,
course_name VARCHAR(100),
enrollment_date DATE,
grade VARCHAR (2),
FOREIGN KEY (student_id) REFERENCES students(id)
);

-- insert enrollments
INSERT INTO enrollments(student_id, course_name, enrollment_date, grade) VALUES
(1, 'Data Structures', '2024-01-15', 'A'),
(1, 'Algorithms', '2024-01-15', 'B'),
(2, 'Thermodynamics', '2024-01-16', 'A'),
(3, 'Circuits', '2024-01-17', 'B'),
(5, 'Data Structures', '2024-01-15', 'A'),
(6, 'Algorithms', '2024-01-15', 'A');

-- Complex queries practice:

-- 1. Students with their enrollment
SELECT s.name, e.course_name, e.enrollment_date, e.grade
FROM students s
LEFT JOIN enrollments e ON s.id = e.student_id;

-- 2. Count courses per student
SELECT s.name, COUNT(e.id) as total_courses
FROM students s
LEFT JOIN enrollments e ON s.id = e.student_id
GROUP BY s.name ;

-- 3. Students with grade A
SELECT DISTINCT s.name, e.grade
FROM students s
JOIN enrollments e ON s.id = e.student_id
WHERE grade = 'A' ;

-- 4. Average number of enrollments per department
SELECT d.dept_name , AVG(course_count) as avg_enrollments
FROM departments d
LEFT JOIN students s ON d.dept_id = s.dept_id
LEFT JOIN(
      SELECT student_id , COUNT(*)  AS course_count
      FROM enrollments
      GROUP BY student_id
    ) e ON s.id = e.student_id
    GROUP BY d.dept_name;
    
 -- 5. Students not enrolled in any course
 SELECT s.name 
 FROM students s
 LEFT JOIN enrollments e ON s.id = e.student_id
 WHERE  e.id IS NULL ;