package com.TechEazy.StudentDetailsProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TechEazy.StudentDetailsProject.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
