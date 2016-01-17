/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.AdminDAO;
import org.pulem3t.crm.entry.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admins")
public class GetAdminController {
	
	protected static Logger logger = Logger.getLogger("GetAdminController");
	
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(value="/getAdmin/{id}", method=RequestMethod.GET)
	public @ResponseBody String getAdmin(@PathVariable("id") Long id) {
		
		logger.info("ADMINS: Getting admin with id=" + id);
		
		try {
			Admin admin = adminDAO.getAdmin(id);
			JSONObject o = new JSONObject();
			o.put("id", admin.getId());
			o.put("firstName", admin.getFirstName());
			o.put("lastName", admin.getLastName());
			o.put("role", admin.getRole());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
