package org.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.dto.Address;
import org.practice.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();
		
		Address homeAddress = new Address();
		homeAddress.setCity("Hyderabad");
		homeAddress.setStreet("Kothaguda");
		homeAddress.setState("Telengana");
		homeAddress.setPincode("500084");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Visakhapatnam");
		officeAddress.setStreet("NAD");
		officeAddress.setState("Andhra Pradesh");
		officeAddress.setPincode("534545");
		
 		
		user1.setUserName("First User");
		user1.setHomeAddress(homeAddress);
		user1.setOfficeAddress(officeAddress);
		
		 		
		SessionFactory sessionfactoy= new Configuration().configure().buildSessionFactory();
		Session session = sessionfactoy.openSession();
		
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.close();
		
		user1 = null ;
		
		
		// Retrieving data
		session = sessionfactoy.openSession();
		session.beginTransaction();
		user1 = session.get(UserDetails.class, 1/* primary key value*/);
		System.out.println("user1 name :"+user1.getUserName());
		
	}

}
