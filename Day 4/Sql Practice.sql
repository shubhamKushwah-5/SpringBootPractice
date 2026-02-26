USE day01_practice;
 -- Subqueries practice
-- 1. Students older than average age
SELECT name, age FROM students
WHERE age > (SELECT AVG(age) FROM students);

-- 2. Department with most students
SELECT  dept_name 
FROM departments
WHERE dept_id = (
      SELECT dept_id FROM students
      WHERE dept_id IS NOT NULL
      GROUP BY dept_id
      ORDER BY COUNT(*) DESC
      LIMIT 1
);

-- 3. Students with above average grades (using enrollments)
SELECT s.name , e.grade
FROM students s
JOIN 
enrollments e ON s.id = e.student_id
WHERE e.grade = 'A';

-- INDEXES (understand why they matter)
-- Without index, MySQL scans every row
-- With index, it jumps directly to the data
-- Create an index
SELECT * 
FROM students;

SHOW INDEXES FROM students;

CREATE INDEX name_idx
ON students(name);

SELECT * FROM students
WHERE name = 'shubham';

-- multi column indexes
CREATE INDEX id_name_idx
ON students(id,name);
-- deleting index
ALTER TABLE students
DROP INDEX name_idx;

-- SELECT * FROM students 
-- WHERE id = 1 AND name = 'shubham' -- for our index it will benefit
-- WHERE id = 1              -- benefit by our index id, name
-- WHERE  name = 'shubham'   -- benefit by our index id, name
-- WHERE name = 'shubham' AND  id = 1 -- not benefit by our index id, name as name come first
-- Create an index
CREATE INDEX idx_course ON students(course);
CREATE INDEX idx_name ON students(name);

-- Now searches are faster
SELECT * FROM students WHERE course = 'Computer Science';
SELECT * FROM students WHERE name LIKE 'A%';

