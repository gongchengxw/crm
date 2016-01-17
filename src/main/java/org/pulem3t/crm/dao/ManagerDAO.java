/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Manager;

public interface ManagerDAO {

	public List<Manager> getManagers();
	
	public Manager getManager(Long id);
	
	public Long addManager(Manager manager);
	
	public void delManager(Long id);
	
	public void updateManager(Manager manager);
}
