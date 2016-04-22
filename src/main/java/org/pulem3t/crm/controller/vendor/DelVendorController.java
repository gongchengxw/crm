/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.vendor;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.VendorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/vendors")
public class DelVendorController {
	
	protected static Logger logger = Logger.getLogger("DelVendorController");
	
	@Autowired
	private VendorDAO vendorDAO;

	@RequestMapping(value="/delVendor/{id}", method=RequestMethod.GET)
	public @ResponseBody String delVendor(@PathVariable("id") Long id) {
		
		logger.info("VENDORS: Deleting vendor with id = " + id);

		try {
			vendorDAO.delVendor(id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
