/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.vendor;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.VendorDAO;
import org.pulem3t.crm.entry.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vendors")
public class SearchVendorController {

	@Autowired
	private VendorDAO vendorDAO;
	
	@RequestMapping(value="/search/{param}/{query}", method=RequestMethod.GET)
	public @ResponseBody String search(@PathVariable("param") int param, @PathVariable("query") String query) {
		try {
			List<Vendor> vendorList = vendorDAO.getVendors();
			List<Vendor> result = new ArrayList<Vendor>();
			JSONArray o = new JSONArray();
			if(query == "") {
				o.put(vendorList);
				return o.toString(4);
			}else{
				switch (param) {
				
					case 1: for (Vendor v: vendorList) {
						if(v.getId().toString().contains(query)) {
							result.add(v);
						}
					}
					break;
					
					case 2: for (Vendor v: vendorList) {
						if(v.getFirstName().toString().contains(query)) {
							result.add(v);
						}
					}
					break;
					
					case 3: for (Vendor v: vendorList) {
						if(v.getLastName().toString().contains(query)) {
							result.add(v);
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
