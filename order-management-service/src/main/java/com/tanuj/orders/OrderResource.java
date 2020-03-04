package com.tanuj.orders;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tanuj.beans.Order;
@Path("/show-on-screen")
public class OrderResource
{
	
//	http://localhost:8080/order-management-service/rest/show-on-screen/HowToDoInJava_Dot_Com
	//localhost:8080/order-management-service/rest/show-on-screen/status
	String status = "Order Resource is working fine";
	
	@GET
    @Path("/{message}")
    public Response getMsg(@PathParam("message") String msg)
    {
        String output = "Message requested : " + msg;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
//	http://localhost:8080/order-management-service/rest/show-on-screen/order_status
	//localhost:8080/order-management-service/rest/orders/order_status
	@GET
    @Path("/orders_status")
	@Produces("text/html")
    public String getMsg()
    {
       return status;
    }
	@Path("/create")
	@POST
	@Produces({"application/json","application/xml"})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createOrder(Order order,@HeaderParam("clientId")String client_id)
	{
		System.out.println("Client ID :" +client_id);
	System.out.println("Order details recieved :" +order );
	return Response.status(201).entity("order created").build();
	
	}
	/**
	{
		"deliveryAddress": "punjab",
		"id": "flipkart10",
		"orderName": "laptop"
	}
	**/
	//localhost:8080/order-management-service/rest/orders/getOrder
	//localhost:8080/order-management-service/rest/orders/getOrder?flipkart10
//	http://localhost:8080/order-management-service/rest/show-on-screen/getOrder?id=flipkart10
//	@Path("/getOrder")
	@Path("{id}")
	@GET
	@Produces({"application/json","application/xml"})
	public Order getOrder(@PathParam("id")Integer orderId) 
	{
		Order order = new Order();
		if(orderId.equals("10"))
		{
			order.setId(orderId);
			order.setOrderName("Laptop");
			order.setDeliveryAddress("Punjab");
		}
		return order;
	}
	
	public static void main(String[] args)
	{
		OrderResource orderResource = new OrderResource();
		
		Order order= orderResource.getOrder(10);
		
		System.out.println("*********************Order Details : ******************* ");
		System.out.println("Order Name : "+order.getDeliveryAddress());
		System.out.println("Order Name : "+order.getOrderName());
		
	}
}