/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.entry.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public @ResponseBody String updateCustomer(@RequestBody Customer customer) {
		
		logger.info("CUSTOMERS: Update customer with id=" + customer.getId());
		
		try {
			customerDAO.updateCustomer(customer);
			return "Updated customer with id = " + customer.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
