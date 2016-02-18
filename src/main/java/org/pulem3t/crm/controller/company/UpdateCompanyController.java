/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.company;

import org.apache.log4j.Logger;
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
		
		logger.info("COMPANIES: Update company with id = " + company.getId());
		
		try {
			companyDAO.updateCompany(company);
			return "Updated company with id = " + company.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
