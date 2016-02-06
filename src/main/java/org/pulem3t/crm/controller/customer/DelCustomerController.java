/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class DelCustomerController {
	
	protected static Logger logger = Logger.getLogger("DelCustomerController");
	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value="/delCustomer/{id}", method=RequestMethod.GET)
	public @ResponseBody String delCustomer(@PathVariable("id") Long id) {
		
		try {
			customerDAO.delCustomer(id);
			logger.info("CUSTOMERS: Deleted customer with id = " + id);
			return "Deleted customer with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
