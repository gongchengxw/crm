/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.entry.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class AddManagerController {
	
	protected static Logger logger = Logger.getLogger("AddManagerController");
	
	@Autowired
	private ManagerDAO managerDAO;

	@RequestMapping(value="/addManager", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addManager(@RequestBody Manager manager) {

		try {
			Long id = managerDAO.addManager(manager);
			logger.info("MANAGERS: Added manager with id = " + id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
