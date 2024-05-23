package com.tap.userdao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDao {
	
	public void addOrder(Order order);
	public void getOrder(int orderId);
	public List<Order> getAllOrders();
	public void updateOrders(Order order);
	public void deleteOrder(int orderId);

}
