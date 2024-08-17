package com.Destroyer_BLUE.Project.blue1.repository;

import com.Destroyer_BLUE.Project.blue1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
