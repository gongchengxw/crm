/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.product;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.ProductDAO;
import org.pulem3t.crm.entry.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class GetProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/getProducts", method=RequestMethod.GET)
	public @ResponseBody String getProducts() {
		try {
			List<Product> productList = productDAO.getProducts();
			JSONArray o = new JSONArray();
			o.put(productList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
