/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
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
public class SearchAdminController {

	@Autowired
	private AdminDAO adminDAO;
	
	@RequestMapping(value="/search/{param}/{query}", method=RequestMethod.GET)
	public @ResponseBody String search(@PathVariable("param") int param, @PathVariable("query") String query) {
		try {
			List<Admin> adminList = adminDAO.getAdmins();
			List<Admin> result = new ArrayList<Admin>();
			JSONArray o = new JSONArray();
			if(query == "") {
				o.put(adminList);
				return o.toString(4);
			}else{
				switch (param) {
				
					case 1: for (Admin a: adminList) {
						if(a.getId().toString().contains(query)) {
							result.add(a);
						}
					}
					break;
					
					case 2: for (Admin a: adminList) {
						if(a.getFirstName().toString().contains(query)) {
							result.add(a);
						}
					}
					break;
					
					case 3: for (Admin a: adminList) {
						if(a.getLastName().toString().contains(query)) {
							result.add(a);
						}
					}
					break;
				}
			
				o.put(result);
				return o.toString(4);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
