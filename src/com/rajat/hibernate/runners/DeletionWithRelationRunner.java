package com.rajat.hibernate.runners;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rajat.hibernate.entities.Instructor;
import com.rajat.hibernate.entities.InstructorDetail;

public class DeletionWithRelationRunner {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

		System.out.println("Factory Created  : " + factory);

		// Create the session
		Session currentSession = factory.getCurrentSession();
		// Create session Factory
		try {
			
			// Start the session
			currentSession.beginTransaction();
			
			// Get the instructor with id
			
			int theId = 2;
			
			Instructor insToBeDeleted = currentSession.get(Instructor.class, 1);
			
			// delete the Instructor
			// Will delete instructor_details as well because of cascade functionality
			if(insToBeDeleted != null) {
				currentSession.delete(insToBeDeleted);
			}
			
			currentSession.getTransaction().commit();
		}catch (Exception e) {
			System.out.println("Caught exception while deleting" + e);
		}finally {
			currentSession.close();
		}
		

	}

}
