/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.AdminDAO;
import org.pulem3t.crm.entry.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admins")
public class AddAdminController {
	
	protected static Logger logger = Logger.getLogger("AddAdminController");
	
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(value="/addAdmin", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addAdmin(@RequestBody Admin admin) {
		
		logger.info("ADMINS: Adding admin with id=" + admin.getId());
		
		try {
			adminDAO.addAdmin(admin);
			return "Added admin with id=" + admin.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
