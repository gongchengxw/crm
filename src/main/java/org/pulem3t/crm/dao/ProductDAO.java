/**
 * @author pulem3t
 */
package org.pulem3t.crm.dao;

import java.util.List;

import org.pulem3t.crm.entry.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	
	public Product getProduct(Long id);
	
	public Long addProduct(Product product);
	
	public void delProduct(Long id);
	
	public void updateProduct(Product product);
	
	public List<Product> getProductsByCompanyId(Long companyId);
}
