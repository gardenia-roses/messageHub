package org.amany.messages.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table (name="topics")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topic_id")
	private int topicId;

	@Column(name="topic_name")
	private String topicName;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="topic_id")
	private List<Message> messages;
		
	@ManyToMany (fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})

	@JoinTable(
			name="users_topics",
			joinColumns= {@JoinColumn(name="topic_key")},
			inverseJoinColumns= {@JoinColumn(name="user_key")}
			)
	private List<User> users=new ArrayList<User>();

	public String getTopicName() {
		return topicName;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + "]";
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	public void addMessage(Message m) {
		if (messages == null) {
			messages = new ArrayList<>();
			
		}
		
		messages.add(m);
		
	}
	public Topic() {
		super();
		if (users == null) {
			users = new ArrayList<>();
		}
		
		// TODO Auto-generated constructor stub
	}

	public void addUser(User user) {
	
	users.add(user);
}

	public Topic(String topicName) {
		super();
		this.topicName = topicName;
		if (users == null) {
			users = new ArrayList<>();
		}
		
	}
	public void DelUsers() {
		
users.clear();			
	}
	}
