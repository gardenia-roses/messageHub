package org.amany.application;

import org.amany.messages.entity.Message;
import org.amany.messages.entity.Topic;
import org.amany.messages.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EnterEntityIntoDataBase {
	SessionFactory factory;
	Topic u1;
	public EnterEntityIntoDataBase() {
		super();
		 factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Topic.class).addAnnotatedClass(Message.class).buildSessionFactory();

		// TODO Auto-generated constructor stub
	}

	public   Topic HI(	int d) {

		// create session factory
		
		// create session
		Session session = factory.getCurrentSession();
	

		try {
			session.beginTransaction();
String q="select * from topics where topic_id="+d;
u1=(Topic) session.get(Topic.class,d);

System.out.println(u1);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
			return u1;
		}

	}
}
