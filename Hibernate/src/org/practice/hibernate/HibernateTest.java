package org.practice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User's address");
		user.setJoinedDate(new Date());
		user.setDescription("user description is here");
		
		
		SessionFactory sessionfactoy= new Configuration().configure().buildSessionFactory();
		Session session = sessionfactoy.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

}
