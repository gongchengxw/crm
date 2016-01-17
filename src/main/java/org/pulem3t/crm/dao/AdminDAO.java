/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Admin;

public interface AdminDAO {

	public List<Admin> getAdmins();
	
	public Admin getAdmin(Long id);
	
	public Long addAdmin(Admin admin);
	
	public void delAdmin(Long id);
	
	public void updateAdmin(Admin admin);
}
