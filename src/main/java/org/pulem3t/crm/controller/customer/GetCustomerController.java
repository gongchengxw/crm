/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.entry.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class GetCustomerController {
	
	protected static Logger logger = Logger.getLogger("GetCustomerController");
	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value="/getCustomer/{id}", method=RequestMethod.GET)
	public @ResponseBody String getCustomer(@PathVariable("id") Long id) {

		try {
			Customer customer = customerDAO.getCustomer(id);
			JSONObject o = new JSONObject();
			o.put("id", customer.getId());
			o.put("firstName", customer.getFirstName());
			o.put("lastName", customer.getLastName());
			o.put("role", customer.getRole());
			logger.info("CUSTOMERS: Got customer with id = " + id);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
