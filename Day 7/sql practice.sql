USE day01_practice;
-- Aggregation practice
-- 1. Count, Sum, Avg, Min, Max
SELECT
   COUNT(*) as total_students,
   AVG(age) as avg_age,
   MIN(age) as youngest,
   MAX(age) as Oldest
FROM students;   

-- 2. Group by with multiple aggregations
SELECT 
     course,
     COUNT(*) as student_count,
     AVG(age) as avg_age,
     MIN(age) as min_age,
     MAX(age) as max_age
FROM students
GROUP BY course
ORDER BY student_count DESC;
-- 3. HAVING clause (filter after grouping)
SELECT 
      course,
      COUNT(*) as student_count
FROM students
GROUP BY course
HAVING COUNT(*) >= 2;  
-- 4. Multiple GROUP BY columns
SELECT
	course,
    city,
    COUNT(*) as student_count
FROM students
GROUP BY course, city
ORDER BY course, city;   
-- 5. DISTINCT values
SELECT DISTINCT city FROM students; 
-- 6. Count distinct
SELECT COUNT(DISTINCT course) as total_courses FROM students;

-- Performance - EXPLAIN keyword
-- Shows how MySQL executes query
EXPLAIN SELECT * FROM students WHERE course = 'Computer Science';

-- Create index to improve performance
CREATE INDEX idx_course ON students(course);

-- Now run EXPLAIN again - see the difference
EXPLAIN SELECT * FROM students WHERE course = 'Computer Science';

-- Show all indexes on a table
SHOW INDEX FROM students;

-- Drop index if needed
-- DROP INDEX idx_course ON students;

DROP INDEX idx_course ON students;

use day01_practice;

INSERT INTO students (name, age,course) VALUES ('New Student',22,'CS');
SELECT * FROM students WHERE name = 'New Student';
UPDATE students set age = 23 WHERE name = 'New Student';
DELETE FROM students WHERE name = 'New Student';

CREATE TABLE test_trades (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
symbol VARCHAR(50),
pnl DOUBLE
);

INSERT INTO test_trades (symbol, pnl) VALUES ('RELIANCE', 500);
INSERT INTO test_trades (symbol, pnl) VALUES ( 'TCS', -200);
INSERT INTO test_trades (symbol, pnl) VALUES ('INFY', 800);

SELECT * FROM test_trades;

DROP TABLE test_trades;