/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.product;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.ProductDAO;
import org.pulem3t.crm.entry.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class AddProductController {
	
	protected static Logger logger = Logger.getLogger("AddProductController");
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/addProduct", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addProduct(@RequestBody Product product) {
		
		try {
			Long id = productDAO.addProduct(product);
			logger.info("PRODUCTS: Added product with id = " + id);
			return "Added product with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
