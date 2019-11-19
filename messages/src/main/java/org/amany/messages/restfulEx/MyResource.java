package org.amany.messages.restfulEx;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.amany.application.EnterEntityIntoDataBase;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource0")
public class MyResource {
	EnterEntityIntoDataBase data;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
//	data=new EnterEntityIntoDataBase();
    	
    //	return data.HI(12).toString();
    }
    
}
