/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.AdminDAO;
import org.pulem3t.crm.entry.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admins")
public class UpdateAdminController {
	
	protected static Logger logger = Logger.getLogger("UpdateAdminController");

	@Autowired
	private AdminDAO adminDAO;
	
	@RequestMapping(value="/updateAdmin", method=RequestMethod.POST)
	public @ResponseBody String updateAdmin(@RequestBody Admin admin) {
		
		logger.info("ADMINS: Update admin with id=" + admin.getId());
		
		try {
			adminDAO.updateAdmin(admin);
			return "Updated admin with id = " + admin.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
