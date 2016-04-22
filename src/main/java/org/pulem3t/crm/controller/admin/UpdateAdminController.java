/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import org.apache.log4j.Logger;
import org.json.JSONObject;
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
public class UpdateAdminController {
	
	protected static Logger logger = Logger.getLogger("UpdateAdminController");

	@Autowired
	private AdminDAO adminDAO;
	
	@RequestMapping(value="/updateAdmin", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateAdmin(@RequestBody Admin admin) {

		try {
			adminDAO.updateAdmin(admin);
			logger.info("ADMINS: Updated admin with id = " + admin.getId());
			JSONObject o = new JSONObject();
			o.put("Updated", admin.getId());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
