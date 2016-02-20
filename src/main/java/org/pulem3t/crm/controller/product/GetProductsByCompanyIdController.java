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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class GetProductsByCompanyIdController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/getProductsByCompanyId", method=RequestMethod.GET)
	public @ResponseBody String getProducts(@RequestParam(value = "companyId", required = true) Long companyId) {
		try {
			List<Product> productList = productDAO.getProductsByCompanyId(companyId);
			JSONArray o = new JSONArray();
			o.put(productList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
