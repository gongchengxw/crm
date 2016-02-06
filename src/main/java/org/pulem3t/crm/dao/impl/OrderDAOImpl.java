package org.pulem3t.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.pulem3t.crm.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Transaction tx = null;
	
	@Override
	public List<Order> getOrders() {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		List<Order> orderList = session.createCriteria(Order.class).list();
		tx.commit();
		session.close();
		
		return orderList;
	}

	@Override
	public List<Order> getOrdersByUserId(Long userId, Boolean manager) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		String idSelector;
		if(manager){
			idSelector = "managerId";
		}else{
			idSelector = "customerId";
		}
		List<Order> orderList = session.createCriteria(Order.class).add(Restrictions.eq(idSelector, new Long(userId))).list();
		tx.commit();
		session.close();
		
		return orderList;
	}

	@Override
	public void changeStatus(Long id, OrderStatus status) {
		
		session = sessionFactory.openSession();
		
		Order order = (Order) session.get(Order.class, new Long(id));
		order.setStatus(status);
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
	}

	@Override
	public Order getOrder(Long id) {
		
		session = sessionFactory.openSession();
		Order order = (Order) session.get(Order.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		
		return order;
	}

	@Override
	public Long addOrder(Order order) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		
		return order.getId();
	}

	@Override
	public void delOrder(Long id) {
		
		session = sessionFactory.openSession();
		Order order = (Order) session.load(Order.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(order);
		tx.commit();
		session.close();
	}

	@Override
	public void updateOrder(Order order) {
		
		session = sessionFactory.openSession();
		
		Order oldOrder = (Order) session.get(Order.class, order.getId());
		oldOrder.setCustomerId(order.getCustomerId());
		oldOrder.setManagerId(order.getManagerId());
		oldOrder.setAmount(order.getAmount());
		oldOrder.setDeliveryAddress(order.getDeliveryAddress());
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(oldOrder);
		tx.commit();
		session.close();

	}

}
