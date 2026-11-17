package com.sms.view;
import java.util.Scanner;
import com.sms.controller.StudentController;
import com.sms.model.Student;
public class StudentView {
	private final StudentController controller;
	private final Scanner sc=new Scanner(System.in);
	public StudentView(StudentController controller) {
		this.controller=controller;
	}
	private Student readStudent(int id) {
		System.out.println("Student name:");
		String name = sc.nextLine();
	
		System.out.println("Email:");
		String email = sc.nextLine();
		
		System.out.println("Department:");
		String department = sc.nextLine();
		
		System.out.println("Phone (10-15 digits):");
		String phone = sc.nextLine();
		
		return new Student(id ,name ,email ,department ,phone);
	}
	public void start() {
		while(true) {
			try {
				System.out.println("\n 1.Add 2.View All 3.Search 4.Update 5.Delete 0.Exit");
				System.out.print("Choose:");
				int choice = Integer .parseInt(sc.nextLine());
				
				switch(choice) {
				case 1:
					System.out.println("Student ID:");
					int newId=Integer .parseInt(sc.nextLine());
					
					int newID = 0;
					System.out.println(controller.add(readStudent(newID))? "Student added." : "ID/email already exists");
                    break;
				case 2:
					controller.getAll().forEach(System.out::println);
					if(controller.getAll().isEmpty()) {
						System.out.println("No students found.");
					}
					break;
				case 3:
					System.out.println("Student ID");
					Student found=controller.getById(Integer .parseInt(sc.nextLine()));
					System.out.println(found == null ? "Student not found.":found);
					break;
				case 4:
					System.out.println("ID to update:");
					int updateId=Integer .parseInt(sc.nextLine());
					
					System.out.println(controller.update(updateId, readStudent(updateId)) ? "Student updated." : "Student not found or email already used.");
	                break;			
				case 5:
					System.out.println("ID to delete:");
					System.out.println(controller.delete(Integer .parseInt(sc.nextLine())) ? "Student deleted." : "Student not found.");
                    break;
				case 0:
					System.out.println("Thank you.");
					return;
				default:
					System.out.println("Choose a valid menu option.");
				}
		}catch(NumberFormatException e) {
			System.out.println("Enter a valid number.");
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	}
}
	


