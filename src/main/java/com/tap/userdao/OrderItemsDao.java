package com.tap.userdao;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemsDao {
	
	public void addOrderItems(OrderItems orderitems);
	public void getOrderItems(int id);
	public List<OrderItems> getAllOrderItems();
	public void updateOrderItems(OrderItems orderitems);
	public void deleteOrderItems(int id);

}
