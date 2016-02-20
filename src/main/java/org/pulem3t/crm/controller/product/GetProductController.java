/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.product;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.ProductDAO;
import org.pulem3t.crm.entry.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class GetProductController {
	
	protected static Logger logger = Logger.getLogger("GetProductController");
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/getProduct/{id}", method=RequestMethod.GET)
	public @ResponseBody String getProduct(@PathVariable("id") Long id) {
		
		try {
			Product product = productDAO.getProduct(id);
			JSONObject o = new JSONObject();
			o.put("id", product.getId());
			o.put("name", product.getName());
			o.put("category", product.getCategory());
			o.put("price", product.getPrice());
			o.put("companyId", product.getCompanyId());
			o.put("quantity", product.getQuantity());
			o.put("weight", product.getWeight());
			o.put("description", product.getDescription());
			o.put("tags", product.getTags());
			logger.info("ORDERS: Got product with id = " + id);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
