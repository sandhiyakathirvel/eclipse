package com.sms.service;

import java.util.List;

import com.sms.model.Student;
import com.sms.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;// Class Instance

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	private void validate(Student s) {
		if(s == null || s.getStudentName() == null || s.getStudentName().isBlank() || s.getEmail() == null || !s.getEmail().matches("^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+$") |s.getDepartment() == null || s.getDepartment().isBlank() || s.getPhoneNumber() == null || !s.getPhoneNumber().matches("[0-9]{10,15}")) {
			throw new IllegalArgumentException("Enter valid student details.");
		}
	}

	@Override
	public boolean addstudent(Student student) {
		validate(student);

		return studentRepository.add(student);
	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException("ID must be positive.");
		}
		return studentRepository.findById(id);
		}
	public boolean updateStudent(int id, Student student) {
		validate(student);
		return studentRepository.update(id, student);
	}

	public boolean deleteStudent(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("ID must be positive.");
		return studentRepository.delete(id);

	}

	

}
