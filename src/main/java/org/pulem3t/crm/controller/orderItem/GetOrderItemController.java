/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.orderItem;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.OrderItemDAO;
import org.pulem3t.crm.entry.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderItems")
public class GetOrderItemController {
	
	protected static Logger logger = Logger.getLogger("GetOrderItemController");
	
	@Autowired
	private OrderItemDAO orderItemDAO;

	@RequestMapping(value="/getOrderItem/{id}", method=RequestMethod.GET)
	public @ResponseBody String getOrderItem(@PathVariable("id") Long id) {
		
		logger.info("ORDER_ITEMS: Getting orderItem with id = " + id);
		
		try {
			OrderItem orderItem = orderItemDAO.getOrderItem(id);
			JSONObject o = new JSONObject();
			o.put("id", orderItem.getId());
			o.put("name", orderItem.getName());
			o.put("orderId", orderItem.getOrderId());
			o.put("companyId", orderItem.getCompanyId());
			o.put("productId", orderItem.getProductId());
			o.put("quantity", orderItem.getQuantity());
			o.put("price", orderItem.getPrice());
			o.put("amount", orderItem.getAmount());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
