package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentdao = context.getBean("StudentDao", StudentDao.class);

//        Student student=new Student(102,"Rohan","pune");
//        
//        int result = studentdao.insert(student);
//        System.out.println("done"+result);
		Student s = new Student();
		int choice, id;
		String name, city;
		char ch;
		boolean result;
	//	boolean r;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***********CRUD OPERATION USING SPRING WITH ORM***********");
			System.out.println("=================================================");
			System.out.println(" 1. Add Student");
			System.out.println(" 2. Update Student ");
			System.out.println(" 3. Delete Student");
			System.out.println(" 4. Show Single Student ");
			System.out.println(" 5. Show All Student List");

			System.out.println("===================================================");
			System.out.println("\n Enter Your Choice");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Student Add Operation");
				System.out.println("=======================");
				System.out.println("Enter Student Id");
				s.setId(sc.nextInt());
				System.out.println("Enter Student City");
				s.setCity(sc.next());
				System.out.println("Enter Student Name");
				s.setName(sc.next());
				result = studentdao.insert(s);
				if (result) {

					System.out.println("Student Added Successfully");
				} else
					System.out.println("Not Inserted");

				break;

			case 2:
				System.out.println("Update Student");
				System.out.println("=======================");
                System.out.println("Enter  Existing Student Id Which You Want To  Update");
                s.setId(sc.nextInt());
				System.out.println("Enter Student City");
				s.setCity(sc.next());
				System.out.println("Enter Student Name");
				s.setName(sc.next());
				result=studentdao.updatestudent(s);
				if (result) {

					System.out.println("Student Added Successfully");
				} else
					System.out.println("Not Inserted");

				

				break;
			case 3:
				System.out.println("Delete Student");
				System.out.println("=======================");
				 System.out.println("Enter  Existing Student Id Which You Want To  Delete");
                result=  studentdao.deletestudent(sc.nextInt());
                if(result)
                {
					System.out.println("Student Deleted Successfully");
				} 
                
               else
					System.out.println("Not Delete");
                  
				break;
			case 4:
				System.out.println(" Show Single Student");
				System.out.println("=======================");
				
				 System.out.println("Enter  Existing Student Id Which You Want To  Get");
				 
				 s=studentdao.getstudent(sc.nextInt());
				 System.out.println(s);
				

				break;
			case 5:
				System.out.println("Show All Student List");
				System.out.println("=======================");
				List<Student> l =studentdao.getallstudent();
				if (!l.isEmpty()) {

					for (Student b : l) {

						System.out.println(b);
					}
				} else
					System.out.println(" Book List Is empty");

				break;

			default:
				System.out.println("Operations Done");
			}
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}

}
