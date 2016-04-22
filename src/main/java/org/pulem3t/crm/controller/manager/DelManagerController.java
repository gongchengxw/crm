/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.ManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class DelManagerController {
	
	protected static Logger logger = Logger.getLogger("DelManagerController");
	
	@Autowired
	private ManagerDAO managerDAO;

	@RequestMapping(value="/delManager/{id}", method=RequestMethod.GET)
	public @ResponseBody String delManager(@PathVariable("id") Long id) {
		
		try {
			managerDAO.delManager(id);
			logger.info("MANAGERS: Deleted manager with id = " + id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
