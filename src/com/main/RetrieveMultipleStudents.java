package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.Student;

public class RetrieveMultipleStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();
			// Save the student object

			// Query Employee
			List<Student> s = session.createQuery("from Student").getResultList(); // Display Employees
			displayStudents(s);
			
			//Query students with email only with @gmail.com
			s = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			System.out.println("Students with Email as GMAIL: ");
			displayStudents(s);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			factory.close();
			System.out.println("Factory Closed!!!!");
		}

	}

	private static void displayStudents(List<Student> s) {
		for (Student ss : s) {
			System.out.println(ss);
		}
	}

}
