/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class GetOrdersControllerByUserId {

	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping(value="/getOrdersByUserId", method=RequestMethod.GET)
	public @ResponseBody String getOrders(@RequestParam(value = "userId", required = true) Long userId, @RequestParam(value = "manager", required = true) Boolean manager) {
		try {
			List<Order> orderList = orderDAO.getOrdersByUserId(userId, manager);
			JSONArray o = new JSONArray();
			o.put(orderList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
