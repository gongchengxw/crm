/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.company;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.CompanyDAO;
import org.pulem3t.crm.entry.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/companies")
public class GetCompanyController {
	
	protected static Logger logger = Logger.getLogger("GetCompanyController");
	
	@Autowired
	private CompanyDAO companyDAO;

	@RequestMapping(value="/getCompany/{id}", method=RequestMethod.GET)
	public @ResponseBody String getCompany(@PathVariable("id") Long id) {
		
		logger.info("COMPANIES: Getting company with id = " + id);
		
		try {
			Company company = companyDAO.getCompany(id);
			JSONObject o = new JSONObject();
			o.put("id", company.getId());
			o.put("name", company.getName());
			o.put("description", company.getDescription());
			o.put("vendorId", company.getVendorId());
			o.put("address", company.getAddress());
			o.put("phone", company.getPhone());
			o.put("fax", company.getFax());
			o.put("country", company.getCountry());
			o.put("city", company.getCity());
			o.put("state", company.getState());
			o.put("zipPostCode", company.getZipPostCode());
			o.put("category", company.getCategory());
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
