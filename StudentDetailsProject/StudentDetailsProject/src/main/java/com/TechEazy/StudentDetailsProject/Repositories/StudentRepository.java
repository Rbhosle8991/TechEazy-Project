package com.TechEazy.StudentDetailsProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechEazy.StudentDetailsProject.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
