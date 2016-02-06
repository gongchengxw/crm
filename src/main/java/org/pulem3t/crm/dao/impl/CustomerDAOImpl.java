/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.entry.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Transaction tx = null;
	
	@Override
	public List<Customer> getCustomers() {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		List<Customer> customerList = session.createCriteria(Customer.class).list();
		tx.commit();
		session.close();
		
		return customerList;
	}

	@Override
	public Customer getCustomer(Long id) {
		
		
		session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		
		return customer;
	}

	@Override
	public Long addCustomer(Customer customer) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
		
		return customer.getId();
	}

	@Override
	public void delCustomer(Long id) {
		
		session = sessionFactory.openSession();
		Customer customer = (Customer) session.load(Customer.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		session = sessionFactory.openSession();
		
		Customer oldCustomer = (Customer) session.get(Customer.class, customer.getId());
		oldCustomer.setFirstName(customer.getFirstName());
		oldCustomer.setLastName(customer.getLastName());
		oldCustomer.setRole(customer.getRole());
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(oldCustomer);
		tx.commit();
		session.close();
	}

}
