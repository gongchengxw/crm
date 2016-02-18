/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.orderItem;

import java.util.List;

import org.json.JSONArray;
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
public class GetOrderItemsController {

	@Autowired
	private OrderItemDAO orderItemDAO;
	
	@RequestMapping(value="/getOrderItems/{id}", method=RequestMethod.GET)
	public @ResponseBody String getOrderItems(@PathVariable("id") Long id) {
		try {
			List<OrderItem> orderItemList = orderItemDAO.getOrderItems(id);
			JSONArray o = new JSONArray();
			o.put(orderItemList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
