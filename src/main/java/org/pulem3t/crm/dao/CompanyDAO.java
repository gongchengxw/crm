/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Company;

public interface CompanyDAO {

	public List<Company> getCompanies();
	
	public Company getCompany(Long id);
	
	public Long addCompany(Company company);
	
	public void delCompany(Long id);
	
	public void updateCompany(Company company);
}
