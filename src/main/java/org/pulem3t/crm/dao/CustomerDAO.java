/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(Long id);
	
	public Long addCustomer(Customer customer);
	
	public void delCustomer(Long id);
	
	public void updateCustomer(Customer customer);
}
