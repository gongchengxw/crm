/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.entry.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/managers")
public class GetManagersController {

	@Autowired
	private ManagerDAO managerDAO;
	
	@RequestMapping(value="/getManagers", method=RequestMethod.GET)
	public @ResponseBody String getManagers() {
		try {
			List<Manager> managerList = managerDAO.getManagers();
			JSONArray o = new JSONArray();
			o.put(managerList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
