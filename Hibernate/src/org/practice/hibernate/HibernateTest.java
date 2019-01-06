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
		
		Address addr1 = new Address();
		addr1.setCity("Hyderabad");
		addr1.setStreet("Kothaguda");
		addr1.setState("Telengana");
		addr1.setPincode("500084");
		
		Address addr2 = new Address();
		addr2.setCity("Visakhapatnam");
		addr2.setStreet("NAD");
		addr2.setState("Andhra Pradesh");
		addr2.setPincode("534545");
		
 		
		user1.setUserName("First User");
		user1.setAddress(addr1);
		
		
		user2.setUserName("second user");
		user2.setAddress(addr2);
		 		
		SessionFactory sessionfactoy= new Configuration().configure().buildSessionFactory();
		Session session = sessionfactoy.openSession();
		
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user1 = null ;
		
		
		// Retrieving data
		session = sessionfactoy.openSession();
		session.beginTransaction();
		user1 = session.get(UserDetails.class, 1/* primary key value*/);
		System.out.println("user1 name :"+user1.getUserName());
		user1 = session.get(UserDetails.class, 2/* primary key value*/);
		System.out.println("user2 name :"+user1.getUserName());
	}

}
