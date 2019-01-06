package org.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();
 		
		user1.setUserName("First User");
		user2.setUserName("second user");
		
		 		
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
