/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admins")
public class DelAdminController {
	
	protected static Logger logger = Logger.getLogger("DelAdminController");
	
	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(value="/delAdmin/{id}", method=RequestMethod.GET)
	public @ResponseBody String delAdmin(@PathVariable("id") Long id) {
		
		try {
			adminDAO.delAdmin(id);
			logger.info("ADMINS: Deleted admin with id = " + id);
			return "Deleted admin with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
