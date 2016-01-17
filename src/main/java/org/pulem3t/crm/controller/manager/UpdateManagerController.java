/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.entry.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class UpdateManagerController {
	
	protected static Logger logger = Logger.getLogger("GetManagerController");

	@Autowired
	private ManagerDAO managerDAO;
	
	@RequestMapping(value="/updateManager", method=RequestMethod.POST)
	public @ResponseBody String updateManager(@RequestBody Manager manager) {
		
		logger.info("MANAGERS: Update manager with id=" + manager.getId());
		
		try {
			managerDAO.updateManager(manager);
			return "Updated manager with id = " + manager.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
