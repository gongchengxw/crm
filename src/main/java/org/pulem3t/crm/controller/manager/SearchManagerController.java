/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
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
public class SearchManagerController {

	@Autowired
	private ManagerDAO managerDAO;
	
	@RequestMapping(value="/search/{param}/{query}", method=RequestMethod.GET)
	public @ResponseBody String search(@PathVariable("param") int param, @PathVariable("query") String query) {
		try {
			List<Manager> managerList = managerDAO.getManagers();
			List<Manager> result = new ArrayList<Manager>();
			JSONArray o = new JSONArray();
			if(query == "") {
				o.put(managerList);
				return o.toString(4);
			}else{
				switch (param) {
				
					case 1: for (Manager m: managerList) {
						if(m.getId().toString().contains(query)) {
							result.add(m);
						}
					}
					break;
					
					case 2: for (Manager m: managerList) {
						if(m.getFirstName().toString().contains(query)) {
							result.add(m);
						}
					}
					break;
					
					case 3: for (Manager m: managerList) {
						if(m.getLastName().toString().contains(query)) {
							result.add(m);
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
