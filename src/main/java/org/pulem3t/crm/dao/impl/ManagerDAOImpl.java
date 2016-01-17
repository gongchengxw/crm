/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.entry.Manager;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerDAOImpl implements ManagerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Transaction tx = null;
	
	
	public List<Manager> getManagers() {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		List<Manager> managerList = session.createCriteria(Manager.class).list();
		tx.commit();
		session.close();
		
		return managerList;
	}

	public Manager getManager(Long id) {
		
		
		session = sessionFactory.openSession();
		Manager manager = (Manager) session.get(Manager.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		
		return manager;
	}

	public Long addManager(Manager manager) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(manager);
		tx.commit();
		session.close();
		
		return manager.getId();
	}

	public void delManager(Long id) {
		
		session = sessionFactory.openSession();
		Manager manager = (Manager) session.load(Manager.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(manager);
		tx.commit();
		session.close();
	}

	public void updateManager(Manager manager) {
		
		session = sessionFactory.openSession();
		
		Manager oldManager = (Manager) session.get(Manager.class, manager.getId());
		oldManager.setFirstName(manager.getFirstName());
		oldManager.setLastName(manager.getLastName());
		oldManager.setRole(manager.getRole());
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(oldManager);
		tx.commit();
		session.close();
	}

}
