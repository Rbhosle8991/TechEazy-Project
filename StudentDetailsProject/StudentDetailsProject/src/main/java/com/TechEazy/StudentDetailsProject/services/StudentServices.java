package com.TechEazy.StudentDetailsProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechEazy.StudentDetailsProject.Repositories.StudentRepository;
import com.TechEazy.StudentDetailsProject.entities.Student;
import com.TechEazy.StudentDetailsProject.services.Exception.UserNotFoundException;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudents()
	{
		List<Student> list = this.studentRepository.findAll();
		return list;
	}
	
	
	public Student getStudentById(Integer id)
	{
		return this.studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id : " + id + " does not exists"));
	}
	
	
	public Student addStudent(Student student)
	{
		return this.studentRepository.save(student);
	}
	
	public Student updateStudent(Student student , Integer id)
	{
		Student std = this.studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id : " + id + " does not exists"));
		
		std.setName(student.getName());
		std.setAddress(student.getAddress());
		
		Student s = this.studentRepository.save(std);
		return s;
	}
	
	public void deleteStudent(Integer id)
	{
		this.studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id : " + id + " does not exists"));
		this.studentRepository.deleteById(id);
	}
}
