/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.entry.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class UpdateCustomerController {
	
	protected static Logger logger = Logger.getLogger("GetCustomerController");

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateCustomer(@RequestBody Customer customer) {

		try {
			customerDAO.updateCustomer(customer);
			logger.info("CUSTOMERS: Updated customer with id = " + customer.getId());
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
