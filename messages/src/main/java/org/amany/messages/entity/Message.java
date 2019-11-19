package org.amany.messages.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int messageId;
	
	@Column(name="text")
	private String messageText;

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
public Message() {}

public Message(String messageText) {
	super();
	this.messageText = messageText;
}

@Override
public String toString() {
	return "Message [messageId=" + messageId + ", messageText=" + messageText + "]";
}

	
}
