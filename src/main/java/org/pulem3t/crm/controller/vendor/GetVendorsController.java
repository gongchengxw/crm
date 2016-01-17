/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.vendor;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.VendorDAO;
import org.pulem3t.crm.entry.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vendors")
public class GetVendorsController {

	@Autowired
	private VendorDAO vendorDAO;
	
	@RequestMapping(value="/getVendors", method=RequestMethod.GET)
	public @ResponseBody String getVendors() {
		try {
			List<Vendor> vendorList = vendorDAO.getVendors();
			JSONArray o = new JSONArray();
			o.put(vendorList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
