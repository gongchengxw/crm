/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.entry.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class GetManagerController {
	
	protected static Logger logger = Logger.getLogger("GetManagerController");
	
	@Autowired
	private ManagerDAO managerDAO;

	@RequestMapping(value="/getManager/{id}", method=RequestMethod.GET)
	public @ResponseBody String getManager(@PathVariable("id") Long id) {
		
		logger.info("MANAGERS: Getting manager with id=" + id);
		
		try {
			Manager manager = managerDAO.getManager(id);
			JSONObject o = new JSONObject();
			o.put("id", manager.getId());
			o.put("firstName", manager.getFirstName());
			o.put("lastName", manager.getLastName());
			o.put("role", manager.getRole());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
