package com.sms.repository;

import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;

public class StudentRepository {

	
	
	public StudentRepository() {
		// TODO Auto-generated constructor stub
	}
	private final List<Student> students = new ArrayList<>() ;
	
	public boolean add(Student student) {
		if(findById(student.getStudentId()) != null || findByEmail(student.getEmail()) != null) {
			return false;
		}
		return students.add(student);
	}
	
	public Student findById(int id) {
		for(Student student : students) {
			if(student.getStudentId() == id)  {
				return student;
				
			}
		}
		return null;
	}
	
public Student findByEmail(String email) {
	for(Student student : students) {
		if(student.getEmail().equalsIgnoreCase(email)) {
			return student;
		}
	}
	
	
	
	return null;
}

public List<Student> findAll(){
	return new ArrayList<>(students);
}

public boolean update(int id,Student updated) {
	Student existing = findById(id);
	if(existing == null) {
		return false;
	}
	Student emailOwner = findByEmail(updated.getEmail());
	if(emailOwner != null && emailOwner.getStudentId() != id) {
		return false;
		}
	
	
	existing.setStudentName(updated.getStudentName());
	existing.setEmail(updated.getEmail());
	existing.setDepartment(updated.getDepartment());
	existing.setPhoneNumber(updated.getPhoneNumber());
	return true;
}


public boolean delete(int id) {
	Student existing = findById(id);
	return existing != null && students.remove(existing);
}
	
}
