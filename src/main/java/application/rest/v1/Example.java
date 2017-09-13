package application.rest.v1;

import java.util.List;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;


@Path("hello")
public class Example {
	
	//Note: Disable Browser cache history, otherwise the messages sent to browser may be incoreect
   
 private final static Logger LOGGER = Logger.getLogger(Example.class.getName());
 
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public Response hello() throws Exception  {
	
   LOGGER.info("Logging Entering Example.hello() method");
		  
  //generate random number
  Random rand = new Random();

//50 is the maximum and the 1 is our minimum 
  int  x = rand.nextInt(50) + 1;
  System.out.println("Randon mumber generated: " + x);
  
  //check if number is even or odd, and return a response code
  if((x%2)==0)  {
   // even
	LOGGER.info("Logging INFO for 200 error code");
    System.out.println("--> response 200 sent!!!!");
   return Response.ok("Hello World").build();     //200 code
  }
  else  {
   // odd

    if (x <= 10)  {    	
    	LOGGER.severe("Logging SEVERE for 500 error code");
    	System.out.println("--> response 500 sent!!!!");
        return Response.status(500).entity("ERROR CODE 500 RETURNED!!!").build();  
         	
    }
    else if (x <= 20)  {
    	LOGGER.warning("Logging WARNING for 501 error code");
    	System.out.println("--> response 501 sent!!!!");
    	return Response.status(501).entity("ERROR CODE 501 RETURNED!!!").build();  
    }	 
    
    else if (x <= 30) {
    	System.out.println("--> response 503 sent!!!!");
    	//sleep 5 seconds
    	LOGGER.severe("Logging SEVERE for 503 error code");
		Thread.sleep(5000);
		return Response.status(503).entity("ERROR CODE 503 RETURNED!!!").build();  
    }	 
    
    else if (x <= 40) {
    	LOGGER.warning("Logging WARNING for 400 error code");
    	System.out.println("--> response 400 sent!!!!");
    	return Response.status(400).entity("ERROR CODE 400 RETURNED!!!").build();  
    }	
    else if (x <= 50) {
    	LOGGER.warning("Logging WARNING for 204 error code");
    	System.out.println("--> response 204 sent!!!!");
    	 return Response.status(204).entity("ERROR CODE 204 RETURNED!!!").build();  
    }
    else {
    	LOGGER.warning("Logging WARNING for 200 code, fall through");
    	System.out.println("--> response 200 sent!!!!");
    	return Response.ok("Hello World").build();     //200 code
    }	
  }
  
 }
}
