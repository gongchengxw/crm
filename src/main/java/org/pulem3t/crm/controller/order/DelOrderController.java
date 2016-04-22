/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class DelOrderController {
	
	protected static Logger logger = Logger.getLogger("DelOrderController");
	
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value="/delOrder/{id}", method=RequestMethod.GET)
	public @ResponseBody String delOrder(@PathVariable("id") Long id) {
		
		try {
			orderDAO.delOrder(id);
			logger.info("ORDERS: Deleted order with id=" + id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
