/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import org.apache.log4j.Logger;
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
public class AddCustomerController {
	
	protected static Logger logger = Logger.getLogger("AddCustomerController");
	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value="/addCustomer", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addCustomer(@RequestBody Customer customer) {

		try {
			Long id = customerDAO.addCustomer(customer);
			logger.info("CUSTOMERS: Added customer with id = " + id);
			return "Added customer with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
