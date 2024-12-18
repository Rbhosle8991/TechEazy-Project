package com.TechEazy.StudentDetailsProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechEazy.StudentDetailsProject.Repositories.SubjectRepository;
import com.TechEazy.StudentDetailsProject.entities.Subject;
import com.TechEazy.StudentDetailsProject.services.Exception.UserNotFoundException;

@Service
public class SubjectServices {

	@Autowired
	private SubjectRepository subjectRepository;
	
	
	public List<Subject> getAllSubjects()
	{
		List<Subject> list = this.subjectRepository.findAll();
		return list;
	}
	
	
	public Subject getSubjectById(Integer sid)
	{
		return this.subjectRepository.findById(sid).orElseThrow(() -> new UserNotFoundException("User with id : " + sid + " does not exists"));
	}
	
	
	public Subject addSubject(Subject subject)
	{
		return this.subjectRepository.save(subject);
	}
	
	public Subject updateSubject(Subject subject , Integer sid)
	{
		Subject std = this.subjectRepository.findById(sid).orElseThrow(() -> new UserNotFoundException("User with id : " + sid + " does not exists"));
		
		std.setSubjectName(subject.getSubjectName());
		
		Subject s = this.subjectRepository.save(std);
		return s;
	}
	
	public void deleteSubject(Integer sid)
	{
		this.subjectRepository.findById(sid).orElseThrow(() -> new UserNotFoundException("User with id : " + sid + " does not exists"));
		this.subjectRepository.deleteById(sid);
	}
}
