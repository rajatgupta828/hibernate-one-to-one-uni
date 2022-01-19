package com.rajat.hibernate.runners;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rajat.hibernate.entities.Instructor;
import com.rajat.hibernate.entities.InstructorDetail;

public class InstructorMainRunner {
	
	public static void main(String[]  args) {
		
		// Create session Factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		
		System.out.println("Factory Created  : " + factory);
		
		
		
		// Create the session
		
		Session currentSession = factory.getCurrentSession();
		
		
		try {
			//Create the  Objects
			Instructor pankaj = new Instructor("Pankaj", "Dabas", "pankajdabas2626@gmail.com");
			InstructorDetail pankaj_d = new InstructorDetail("pankajChannel", "Behes");
			
			// Create the relationShip
			pankaj.setInstructorDetail(pankaj_d);
			
			
			// Start the transaction
			
			currentSession.beginTransaction();
			
			// Save the current
			
			currentSession.save(pankaj);
			
			// Commit the transaction
			currentSession.getTransaction().commit();
			
			// Sysout for completion
			
			System.out.println("Saved Instructor");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Got exception while creating instructor...");
		}finally {
			currentSession.close();
		}
		
	}

}
