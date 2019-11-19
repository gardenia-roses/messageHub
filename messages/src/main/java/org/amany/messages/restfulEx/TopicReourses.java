package org.amany.messages.restfulEx;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.amany.application.EnterEntityIntoDataBase;
import org.amany.messages.entity.Message;
import org.amany.messages.entity.Topic;
import org.amany.messages.entity.User;
import org.amany.messages.service.TopicService;

@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TopicReourses {

	public TopicService topicService;
	Topic temptop;

	@GET
	
	public List<Topic>  getAllTopics() {

		topicService = new TopicService();

		return topicService.getAllTopics();
	}

	@GET
	@Path("{topicId}/users")
	public String getAllUsers(@PathParam("topicId") String topicId) {
		System.out.println("" + topicId);
		topicService = new TopicService();
		int id = Integer.parseInt(topicId);
		
		return topicService.getTopic(id).getUsers().toString();
	}

	@GET
	@Path("{topicId}")
	public String getAllTopicInfo(@PathParam("topicId") String topicId) {
		System.out.println("" + topicId);
		topicService = new TopicService();
		int id = Integer.parseInt(topicId);
		Topic top = topicService.getTopic(id);
		
		
		
		return topicService.getAllMessages(id).toString();

	}

	@GET
	@Path("{topicId}/messages")
	public List<Message> getAllMessages(@PathParam("topicId") String topicId) {
		System.out.println("" + topicId);
		topicService = new TopicService();
		int id = Integer.parseInt(topicId);
		List<Message> messageList;
		messageList = topicService.getAllMessages(id);
		return messageList;

	}

	// @POST
	/*
	 * public void addUser(@PathParam("topicId") long messageId, User user) { //
	 * topicService.addUser(user); }
	 */

	@PUT
	@Path("/{topicName}")
	public void addTopic(@PathParam("topicName") String topicName) {
		topicService = new TopicService();
		topicService.creatTopic(topicName);
	}

	/*
	 * @DELETE
	 * 
	 * @Path("/{commentId}") public void deleteComment(@PathParam("messageId")
	 * long messageId, @PathParam("commentId") long commentId) {
	 * commentService.removeComment(messageId, commentId); }
	 * 
	 * 
	 * @GET
	 * 
	 * @Path("/{commentId}") public Comment getMessage(@PathParam("messageId")
	 * long messageId, @PathParam("commentId") long commentId) { return
	 * commentService.getComment(messageId, commentId); }
	 */
	@DELETE
	@Path("/{topictId}")
	public void deleteComment(@PathParam("topictId") String topictId) {
		System.out.println("   " + topictId);
		topicService = new TopicService();
		topicService.delTopic(Integer.parseInt(topictId));

	}

}
