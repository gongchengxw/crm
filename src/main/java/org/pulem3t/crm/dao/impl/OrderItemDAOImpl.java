/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.pulem3t.crm.dao.OrderItemDAO;
import org.pulem3t.crm.entry.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemDAOImpl implements OrderItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Transaction tx = null;
	
	@Override
	public List<OrderItem> getOrderItems(Long id) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		List<OrderItem> orderItemList = session.createCriteria(OrderItem.class).add(Restrictions.eq("orderId", new Long(id))).list();
		tx.commit();
		session.close();
		
		return orderItemList;
	}

	@Override
	public OrderItem getOrderItem(Long id) {
		
		
		session = sessionFactory.openSession();
		OrderItem orderItem = (OrderItem) session.get(OrderItem.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		
		return orderItem;
	}

	@Override
	public Long addOrderItem(OrderItem orderItem) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(orderItem);
		tx.commit();
		session.close();
		
		return orderItem.getId();
	}

	@Override
	public void delOrderItem(Long id) {
		
		session = sessionFactory.openSession();
		OrderItem orderItem = (OrderItem) session.load(OrderItem.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(orderItem);
		tx.commit();
		session.close();
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		
		session = sessionFactory.openSession();
		
		OrderItem oldOrderItem = (OrderItem) session.get(OrderItem.class, orderItem.getId());
		oldOrderItem.setName(orderItem.getName());
		oldOrderItem.setOrderId(orderItem.getOrderId());
		oldOrderItem.setCompanyId(orderItem.getCompanyId());
		oldOrderItem.setProductId(orderItem.getProductId());
		oldOrderItem.setQuantity(orderItem.getQuantity());
		oldOrderItem.setPrice(orderItem.getPrice());
		oldOrderItem.setAmount(orderItem.getAmount());
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(oldOrderItem);
		tx.commit();
		session.close();
	}

}
