/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.entry.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class GetCustomersController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/getCustomers", method=RequestMethod.GET)
	public @ResponseBody String getCustomers() {
		try {
			List<Customer> customerList = customerDAO.getCustomers();
			JSONArray o = new JSONArray();
			o.put(customerList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
