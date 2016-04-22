/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.company;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.CompanyDAO;
import org.pulem3t.crm.entry.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/companies")
public class UpdateCompanyController {
	
	protected static Logger logger = Logger.getLogger("UpdateCompanyController");

	@Autowired
	private CompanyDAO companyDAO;
	
	@RequestMapping(value="/updateCompany", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateCompany(@RequestBody Company company) {

		try {
			companyDAO.updateCompany(company);
			logger.info("COMPANIES: Updated company with id = " + company.getId());
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
