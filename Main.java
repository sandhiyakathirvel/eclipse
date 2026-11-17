package com.sms;

import com.sms.controller.StudentController;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import com.sms.service.StudentServiceImpl;
import com.sms.view.StudentView;

public class Main {
	public static void main(String[] args) {
		StudentRepository repository=new StudentRepository();
		StudentService service =new StudentServiceImpl(repository);
		StudentController controller= new StudentController(service);
		StudentView view= new StudentView(controller);
		view.start();
	}
}
