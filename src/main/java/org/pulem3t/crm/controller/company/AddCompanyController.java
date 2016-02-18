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
public class AddCompanyController {
	
	protected static Logger logger = Logger.getLogger("AddCompanyController");
	
	@Autowired
	private CompanyDAO companyDAO;

	@RequestMapping(value="/addCompany", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addCompany(@RequestBody Company company) {

		try {
			Long id = companyDAO.addCompany(company);
			logger.info("COMPANIES: Added company with id = " + id);
			return "Added company with id = " + id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
