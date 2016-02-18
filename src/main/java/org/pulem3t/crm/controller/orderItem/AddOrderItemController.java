/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.orderItem;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.OrderItemDAO;
import org.pulem3t.crm.entry.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderItems")
public class AddOrderItemController {
	
	protected static Logger logger = Logger.getLogger("AddOrderItemController");
	
	@Autowired
	private OrderItemDAO orderItemDAO;

	@RequestMapping(value="/addOrderItem", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addOrderItem(@RequestBody OrderItem orderItem) {

		try {
			Long id = orderItemDAO.addOrderItem(orderItem);
			logger.info("ORDER_ITEMS: Added orderItem with id = " + id);
			return "Added orderItem with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
