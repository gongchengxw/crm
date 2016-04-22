/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.pulem3t.crm.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class OrderStatusController {
	
	protected static Logger logger = Logger.getLogger("OrderStatusController");

	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping(value="/changeOrderStatus", method=RequestMethod.GET)
	public @ResponseBody String updateOrder(@RequestParam(value = "orderId", required = true) Long id,
			@RequestParam(value = "newStatus", required = true) OrderStatus status) {

		try {
			Order order = orderDAO.getOrder(id);
			order.setStatus(status);
			orderDAO.updateOrder(order);
			logger.info("ORDERS: Changed order status with id = " + id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
