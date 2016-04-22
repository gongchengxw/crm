package org.pulem3t.crm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
	
	protected static Logger logger = Logger.getLogger("StaticController");
	
	@RequestMapping(value="/crm")
	public String redirect() {
		return "redirect:crm/static/final.htm";
	}

}
