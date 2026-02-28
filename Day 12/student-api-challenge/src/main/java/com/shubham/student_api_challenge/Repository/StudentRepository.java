package com.shubham.student_api_challenge.Repository;

import com.shubham.student_api_challenge.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
