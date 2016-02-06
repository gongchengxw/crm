/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class AddOrderController {
	
	protected static Logger logger = Logger.getLogger("AddOrderController");
	
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value="/addOrder", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addOrder(@RequestBody Order order) {
		
		try {
			Long id = orderDAO.addOrder(order);
			logger.info("ORDERS: Added order with id = " + id);
			return "Added order with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
