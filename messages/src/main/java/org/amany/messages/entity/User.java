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
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column (name="user_name")
	private String userName;
	@Column (name="user_email")

	private String userEmail;
	@Column (name="password")

	private String userPassword;
	
	
	
	
	@ManyToMany(mappedBy = "users")
	private List<Topic> topics;




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	public User(String userName, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getUserEmail() {
		return userEmail;
	}




	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}




	public String getUserPassword() {
		return userPassword;
	}




	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}




	public List<Topic> getTopics() {
		return topics;
	}




	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

public void addTopic(Topic t) {

	if (topics == null) {
		topics = new ArrayList<>();
	}
	
	topics.add(t);
}
	



	public int getUserId() {
		return userId;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + "]";
	}
	
	

}
