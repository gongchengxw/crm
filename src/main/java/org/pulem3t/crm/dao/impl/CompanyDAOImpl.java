/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.pulem3t.crm.dao.CompanyDAO;
import org.pulem3t.crm.entry.Company;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	private Transaction tx = null;
	
	@Override
	public List<Company> getCompanies() {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		List<Company> companyList = session.createCriteria(Company.class).list();
		tx.commit();
		session.close();
		
		return companyList;
	}

	@Override
	public Company getCompany(Long id) {
		
		
		session = sessionFactory.openSession();
		Company company = (Company) session.get(Company.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		
		return company;
	}

	@Override
	public Long addCompany(Company company) {
		
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(company);
		tx.commit();
		session.close();
		
		return company.getId();
	}

	@Override
	public void delCompany(Long id) {
		
		session = sessionFactory.openSession();
		Company company = (Company) session.load(Company.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(company);
		tx.commit();
		session.close();
	}

	@Override
	public void updateCompany(Company company) {
		
		session = sessionFactory.openSession();
		
		Company oldCompany = (Company) session.get(Company.class, company.getId());
		oldCompany.setName(company.getName());
		oldCompany.setDescription(company.getDescription());
		oldCompany.setAddress(company.getAddress());
		oldCompany.setPhone(company.getPhone());
		oldCompany.setFax(company.getFax());
		oldCompany.setCountry(company.getCountry());
		oldCompany.setCity(company.getCity());
		oldCompany.setState(company.getState());
		oldCompany.setZipPostCode(company.getZipPostCode());
		oldCompany.setCategory(company.getCategory());
		tx = session.getTransaction();
		session.beginTransaction();
		session.save(oldCompany);
		tx.commit();
		session.close();
	}

}
