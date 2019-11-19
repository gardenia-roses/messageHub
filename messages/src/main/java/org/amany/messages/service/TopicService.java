package org.amany.messages.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.amany.messages.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class TopicService {
	private Topic temptop;
	private Session session;
	public SessionFactory factory;

	public TopicService() {

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Topic.class).addAnnotatedClass(Message.class).buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();

	}

	public Topic getTopic(int id) {
		temptop = (Topic) session.get(Topic.class, id);
		printALl(temptop);
		return temptop;
	}
	public List<User> getAllUsers(int id) {

		temptop = (Topic) session.get(Topic.class, id);
		return temptop.getUsers();

	}

	public void DelUsers(int id) {

		Topic temp = session.get(Topic.class, id);
		System.out.println("we will del this topic from Database " + temp.toString());
		temp.getUsers().clear();
		
		session.update(temp);
		session.getTransaction().commit();
	}
	

	public List<Message> getAllMessages(int id) {
		temptop = (Topic) session.get(Topic.class, id);
		System.out.println("you asked me to send you all the Messages of Topic " + temptop.toString());

		for (Message u : temptop.getMessages())
			System.out.println(u.toString());
		return temptop.getMessages();
	}


	private void updatTopic(Topic temp) {
		session.save(temp);
		session.getTransaction().commit();
		// TODO Auto-generated method stub

	}

	public void printALl(Topic t) {
		System.out.println("your Topic is " + t.toString());
		System.out.println("you asked me to send you all the users of Topic " + t.toString());

		for (User u : t.getUsers())
			System.out.println(u.toString());

		System.out.println("you asked me to send you all the Messages of Topic " + t.toString());

		for (Message u : t.getMessages())
			System.out.println(u.toString());

	}

	public List<Topic> getAllTopics() {

		Query query = session.createQuery("from Topic t");
		List<Topic> topics = query.list();
		for (Topic u : topics)
			System.out.println("I am the  " + u.toString());
return topics;
	}

	// TODO Auto-generated method stub
	public void delTopic(int id) {
		Topic temp = (Topic) session.get(Topic.class, id);
		session.delete(temp);
		session.getTransaction().commit();

	}

	public void creatTopic(String topicName) {
		Topic temp= new Topic();
		temp.setTopicName(topicName);
		session.save(temp);
		session.getTransaction().commit();
		
	}

}
