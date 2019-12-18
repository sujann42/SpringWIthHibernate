package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.Student;

public class SaveMutlipleStudents {

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
			Student s4 = new Student("Frank", "Lampard", "frank@ymail.com");
			Student s5 = new Student("Nathan", "Chalobah", "fa@boss.com");
			Student s6 = new Student("Mikel", "Obi", "bio@mills.com");
			// Start a transaction
			session.beginTransaction();
			// Save the student object
			System.out.println("Saving students.");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			session.save(s5);
			session.save(s6);
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
