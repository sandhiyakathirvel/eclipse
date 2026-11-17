package com.sms.controller;
import java.util.List;

import com.sms.model.Student;
import com.sms.service.StudentService;
public class StudentController {
	private final StudentService service;
	
	public StudentController(StudentService service) {
		this.service=service;
	}
	public boolean add(Student student) {
		return service.addstudent(student);
	}
	public List<Student> getAll(){
		return service.getAllStudent();
	}
	public Student getById(int id) {
		return service.getStudentById(id);
	}
	public boolean update(int id, Student student) {
		return service.updateStudent(id, student);
	}
	public boolean delete(int id) {
		return service.deleteStudent(id);
	}
	}


