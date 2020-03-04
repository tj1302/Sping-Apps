package com.tanuj.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order 
{
   int id;
String orderName;
   String deliveryAddress;
  
   
public int getId() 
{
	return id;
}
public void setId(int id)
{
	this.id = id;
}
public String getOrderName() 
{
	return orderName;
}
public void setOrderName(String orderName) 
{
	this.orderName = orderName;
}
public String getDeliveryAddress() 
{
	return deliveryAddress;
}
public void setDeliveryAddress(String deliveryAddress) 
{
	this.deliveryAddress = deliveryAddress;
}
@Override
public String toString() {
	return "Order [orderId=" + id + ", orderName=" + orderName + ", deliveryAddress=" + deliveryAddress + "]";
}
}
