/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.vendor;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.VendorDAO;
import org.pulem3t.crm.entry.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vendors")
public class AddVendorController {
	
	protected static Logger logger = Logger.getLogger("AddVendorController");
	
	@Autowired
	private VendorDAO vendorDAO;

	@RequestMapping(value="/addVendor", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addVendor(@RequestBody Vendor vendor) {
		
		logger.info("USERS: Adding vendor with id=" + vendor.getId());
		
		try {
			vendorDAO.addVendor(vendor);
			return "Added vendor with id=" + vendor.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
