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

import com.TechEazy.StudentDetailsProject.entities.Subject;
import com.TechEazy.StudentDetailsProject.services.SubjectServices;

@RestController
public class SubjectController {
	
	
	@Autowired
	public SubjectServices subjectServices;
	
	
	@GetMapping("/getsubject")
	public List<Subject> getAll()
	{
		List<Subject> list = this.subjectServices.getAllSubjects();
		return list;
	}
	
	@GetMapping("/getSubjectbyid")
	public Subject getById(@PathVariable Integer sid)
	{
		return this.subjectServices.getSubjectById(sid);
	}
	
	@PostMapping("/addsubject")
	public Subject add(@RequestBody Subject subject)
	{
		return this.subjectServices.addSubject(subject);
	}
	
	@PutMapping("/updatesubject")
	public Subject update(@RequestBody Subject subject , @PathVariable Integer sid)
	{
		return this.subjectServices.updateSubject(subject, sid);
	}
	
	@DeleteMapping("/deletesubject")
	public void delete(@PathVariable Integer sid)
	{
		this.subjectServices.deleteSubject(sid);
	}

}
