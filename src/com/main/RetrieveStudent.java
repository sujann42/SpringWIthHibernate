package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.Student;

public class RetrieveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Create 3 more students object
			Student s1 = new Student("Hernan", "Crespo", "hernancrespo@chelseafc.com");

			// Start a transaction
			session.beginTransaction();
			// Save the student object
			System.out.println("Saving students.");
			session.save(s1);
			// Commit Transaction
			session.getTransaction().commit();

			// Find out the student's id which is a primary key
			System.out.println("Saved student. Generated id: " + s1.getId());

			// Getting a new session & start the transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based in the id: primary key
			Student myStudent = session.get(Student.class, s1.getId());
			System.out.println("Get Complete: " + myStudent);

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

}
