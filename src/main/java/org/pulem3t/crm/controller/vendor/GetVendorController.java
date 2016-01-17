/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.vendor;

import org.apache.log4j.Logger;
import org.json.JSONObject;
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
public class GetVendorController {
	
	protected static Logger logger = Logger.getLogger("GetVendorController");
	
	@Autowired
	private VendorDAO vendorDAO;

	@RequestMapping(value="/getVendor/{id}", method=RequestMethod.GET)
	public @ResponseBody String getVendor(@PathVariable("id") Long id) {
		
		logger.info("VENDORS: Getting vendor with id=" + id);
		
		try {
			Vendor vendor = vendorDAO.getVendor(id);
			JSONObject o = new JSONObject();
			o.put("id", vendor.getId());
			o.put("firstName", vendor.getFirstName());
			o.put("lastName", vendor.getLastName());
			o.put("role", vendor.getRole());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
