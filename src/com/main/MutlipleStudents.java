package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.Student;

public class MutlipleStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Create 3 more students object
			Student s1 = new Student("John", "Terry", "terry@gmail.com");
			Student s2 = new Student("Eden", "Hazard", "eden@gmail.com");
			Student s3 = new Student("Didier", "Drogba", "didier@gmail.com");
			// Start a transaction
			session.beginTransaction();
			// Save the student object
			System.out.println("Saving students.");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			// Commit Transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			factory.close();
			System.out.println("Factory Closed!!!!");
		}

	}

}
