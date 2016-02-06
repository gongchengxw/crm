package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Order;
import org.pulem3t.crm.enums.OrderStatus;

public interface OrderDAO {

	public List<Order> getOrders();
	
	public List<Order> getOrdersByUserId(Long userId, Boolean manager);
	
	public void changeStatus(Long id, OrderStatus status);
	
	public Order getOrder(Long id);
	
	public Long addOrder(Order order);
	
	public void delOrder(Long id);
	
	public void updateOrder(Order order);
}
