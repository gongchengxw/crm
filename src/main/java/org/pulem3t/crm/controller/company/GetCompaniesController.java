/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.company;

import java.util.List;

import org.json.JSONArray;
import org.pulem3t.crm.dao.CompanyDAO;
import org.pulem3t.crm.entry.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/companies")
public class GetCompaniesController {

	@Autowired
	private CompanyDAO companyDAO;
	
	@RequestMapping(value="/getCompanies", method=RequestMethod.GET)
	public @ResponseBody String getCompanys() {
		try {
			List<Company> companyList = companyDAO.getCompanies();
			JSONArray o = new JSONArray();
			o.put(companyList);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
