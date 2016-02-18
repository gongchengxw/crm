/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.orderItem;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.OrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderItems")
public class DelOrderItemController {
	
	protected static Logger logger = Logger.getLogger("DelOrderItemController");
	
	@Autowired
	private OrderItemDAO orderItemDAO;

	@RequestMapping(value="/delOrderItem/{id}", method=RequestMethod.GET)
	public @ResponseBody String delOrderItem(@PathVariable("id") Long id) {
		
		logger.info("ORDER_ITEM: Deleting orderItem with id = " + id);

		try {
			orderItemDAO.delOrderItem(id);
			return "Deleted orderItem with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
