package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.Student;

public class SpringHibAppMain {

	public static void main(String[] args) {
		/*
		 * //THis is just for the test purpose. String myUrl =
		 * "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false"; String user =
		 * "hbstudent"; String password = "hbstudent"; try {
		 * System.out.println("Connecting to the database!!!: "+myUrl); Connection
		 * myConn = DriverManager.getConnection(myUrl, user, password);
		 * System.out.println("Connection Established!!!"); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		/*
		 * By default hibernate will look for "hibernate.cfg.xml" by default. if the
		 * file has the name as specified, you do not have to mention the file name.
		 * SessionFactory f = new
		 * Configuration().configure().addAnnotatedClass(Student.class)
		 * .buildSessionFactory();
		 */

		// Create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Create a student object
			Student s1 = new Student("Sam", "Walker", "Samwalker@sam.com");
			// Start a transaction
			session.beginTransaction();
			// Save the student object
			System.out.println("Saving the student.");
			session.save(s1);
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