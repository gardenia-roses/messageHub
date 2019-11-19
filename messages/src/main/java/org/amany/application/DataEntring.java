package org.amany.application;


import org.amany.messages.entity.Message;
import org.amany.messages.entity.Topic;
import org.amany.messages.entity.User;
import org.amany.messages.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class DataEntring {
		public static void main( String []args) {
ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
SessionFactory factory = new Configuration()
.configure("hibernate.cfg.xml")
.addAnnotatedClass(User.class)
.addAnnotatedClass(Topic.class)
.addAnnotatedClass(Message.class)
.buildSessionFactory();

Topic topic1=(Topic) context.getBean(""
		+ "Topic1");
Topic topic2=(Topic) context.getBean("Topic2");
Session session= factory.getCurrentSession(); 
Users u= (Users) context.getBean("users");


try 
{
	session.beginTransaction();
			
			  User user1= session.get(User.class,5);
			  Topic  top1=session.get(Topic.class,13); 
//top1.DelUsers();
			//  session.delete(user1); 
			  session.delete(top1);
				session.getTransaction().commit();

			/*
			 * for (User temp : u.getUsers()) { session.save(temp); } session.save(topic1);
			 * session.save(topic2);
			 */
	

	

}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		session.close();
		factory.close();
	}
	

		
		}

	}


