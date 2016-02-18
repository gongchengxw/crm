/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.OrderItem;

public interface OrderItemDAO {

	public List<OrderItem> getOrderItems(Long id);
	
	public OrderItem getOrderItem(Long id);
	
	public Long addOrderItem(OrderItem orderItem);
	
	public void delOrderItem(Long id);
	
	public void updateOrderItem(OrderItem orderItem);
}
