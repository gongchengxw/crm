/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.customer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
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
public class SearchCustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/search/{param}/{query}", method=RequestMethod.GET)
	public @ResponseBody String search(@PathVariable("param") int param, @PathVariable("query") String query) {
		try {
			List<Customer> customerList = customerDAO.getCustomers();
			List<Customer> result = new ArrayList<Customer>();
			JSONArray o = new JSONArray();
			if(query == "") {
				o.put(customerList);
				return o.toString(4);
			}else{
				switch (param) {
				
					case 1: for (Customer c: customerList) {
						if(c.getId().toString().contains(query)) {
							result.add(c);
						}
					}
					break;
					
					case 2: for (Customer c: customerList) {
						if(c.getFirstName().toString().contains(query)) {
							result.add(c);
						}
					}
					break;
					
					case 3: for (Customer c: customerList) {
						if(c.getLastName().toString().contains(query)) {
							result.add(c);
						}
					}
					break;
				}
			
				o.put(result);
				return o.toString(4);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
