/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.company;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/companies")
public class DelCompanyController {
	
	protected static Logger logger = Logger.getLogger("DelCompanyController");
	
	@Autowired
	private CompanyDAO companyDAO;

	@RequestMapping(value="/delCompany/{id}", method=RequestMethod.GET)
	public @ResponseBody String delCompany(@PathVariable("id") Long id) {
		
		logger.info("COMPANIES: Deleting company with id = " + id);

		try {
			companyDAO.delCompany(id);
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
