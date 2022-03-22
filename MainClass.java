package com.motivity2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
		StudentDao dao = (StudentDao) context.getBean("studentDao");
		System.out.println("1: Insertion\n2: Upadation\n3: Deletion\n4: Selection\n5: Exit");
		do {
			System.out.println("Enter your choice :");
			int choice1 = sc.nextInt();
			switch (choice1) {

			case 1:
				System.out.println("For Insertion");
				Student s1 = new Student();
				System.out.println("Enter Id :");
				s1.setId(sc.nextInt());
				System.out.println("Enter Name :");
				s1.setName(sc.next());
				System.out.println("Enter City :");
				s1.setCity(sc.next());
				System.out.println("Enter Phone Number :");
				s1.setPhoneNum(sc.next());
				int res = dao.insertStudent(s1);
				System.out.println(res);
				break;
			case 2:
				System.out.println("For Updation");
				do {
					System.out.println("Column to be updated : 1.Name 2.City 3.Number 4.exit");
					int choice2 = sc.nextInt();
					Student s2 = new Student();
					switch (choice2) {

					case 1:
						System.out.println("Enter student Id to update:");
						s2.setId(sc.nextInt());
						System.out.println("Updating name of student");
						s2.setName(sc.next());
						int res1 = dao.updateNameStudent(s2);
						System.out.println(res1);
						break;
					case 2:
						System.out.println("Enter student Id to update:");
						s2.setId(sc.nextInt());
						System.out.println("updating city of student");
						s2.setCity(sc.next());
						int res2 = dao.updateCityStudent(s2);
						System.out.println(res2);
						break;
					case 3:
						System.out.println("Enter student Id to update:");
						s2.setId(sc.nextInt());
						System.out.println("updating Phone Number of student");
						s2.setPhoneNum(sc.next());
						int res3 = dao.updatePhoneNumStudent(s2);
						System.out.println(res3);
						break;

					case 4:
						System.out.println("Exist from update");
						System.exit(0);
					}
				} while (true);
			case 3:
				System.out.println("For Deletion");
				Student s3 = new Student();
				System.out.println("Enter student Id to delete:");
				s3.setId(sc.nextInt());
				int res2 = dao.deleteStudent(s3);
				System.out.println(res2);
				break;

			case 4:
				System.out.println("For Selection");
				Student s4 = new Student();
				List<Student> ls = dao.selectStudent(s4);
				for (Student s : ls) {
					System.out.println(s.getId() + "         " + s.getName() + "          " + s.getCity()
							+ "            " + s.getPhoneNum());
				}
				break;

			case 5:
				System.out.println("Existing...");
				System.exit(0);
				break;
			}
		} while (true);
	}
}
