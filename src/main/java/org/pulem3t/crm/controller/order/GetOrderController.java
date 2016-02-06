/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class GetOrderController {
	
	protected static Logger logger = Logger.getLogger("GetOrderController");
	
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value="/getOrder/{id}", method=RequestMethod.GET)
	public @ResponseBody String getOrder(@PathVariable("id") Long id) {
		
		logger.info("ORDERS: Getting order with id=" + id);
		
		try {
			Order order = orderDAO.getOrder(id);
			JSONObject o = new JSONObject();
			o.put("id", order.getId());
			o.put("customerId", order.getCustomerId());
			o.put("managerId", order.getManagerId());
			o.put("deliveryAddress", order.getDeliveryAddress());
			o.put("amount", order.getAmount());
			o.put("status", order.getStatus());
			o.put("creationDate", order.getCreationDate());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
