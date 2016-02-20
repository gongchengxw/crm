/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.product;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class DelProductController {
	
	protected static Logger logger = Logger.getLogger("DelProductController");
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/delProduct/{id}", method=RequestMethod.GET)
	public @ResponseBody String delProduct(@PathVariable("id") Long id) {
		
		try {
			productDAO.delProduct(id);
			logger.info("PRODUCTS: Deleted product with id=" + id);
			return "Deleted product with id=" + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
