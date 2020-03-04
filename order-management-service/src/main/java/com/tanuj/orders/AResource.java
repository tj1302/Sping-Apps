package com.tanuj.orders;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/a")
public class AResource
{
	//localhost:8080/order-management-service/rest/show-on-screen/HowToDoInJava_Dot_Com
	//localhost:8080/order-management-service/rest/show-on-screen/status
	String status = "A Service is running fine";
	
	//localhost:8080/order-management-service/rest/a/a_status
	@GET
    @Path("/a_status")
	@Produces("text/html")
    public String getMsg()
    {
       return status;
    }
	
	
	
	
}