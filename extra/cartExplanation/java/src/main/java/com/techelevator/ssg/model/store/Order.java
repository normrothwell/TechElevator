package com.techelevator.ssg.model.store;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
}
