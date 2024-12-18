package com.TechEazy.StudentDetailsProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TechEazy.StudentDetailsProject.entities.Student;
import com.TechEazy.StudentDetailsProject.services.StudentServices;

@RestController
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/getstudent")
	public List<Student> getAll()
	{
		List<Student> list = this.studentServices.getAllStudents();
		return list;
	}
	
	@GetMapping("/getbyid")
	public Student getById(@PathVariable Integer id)
	{
		return this.studentServices.getStudentById(id);
	}
	
	@PostMapping("/addstudent")
	public Student add(@RequestBody Student student)
	{
		return this.studentServices.addStudent(student);
	}
	
	@PutMapping("/updatestudent")
	public Student update(@RequestBody Student student , @PathVariable Integer id)
	{
		return this.studentServices.updateStudent(student, id);
	}
	
	@DeleteMapping("/deletestudent")
	public void delete(@PathVariable Integer id)
	{
		this.studentServices.deleteStudent(id);
	}
}
