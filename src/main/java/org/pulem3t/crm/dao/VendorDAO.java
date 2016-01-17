/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Vendor;

public interface VendorDAO {

	public List<Vendor> getVendors();
	
	public Vendor getVendor(Long id);
	
	public Long addVendor(Vendor vendor);
	
	public void delVendor(Long id);
	
	public void updateVendor(Vendor vendor);
}
