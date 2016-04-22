/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.base;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.pulem3t.crm.dao.AdminDAO;
import org.pulem3t.crm.dao.CustomerDAO;
import org.pulem3t.crm.dao.ManagerDAO;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.dao.VendorDAO;
import org.pulem3t.crm.entry.Admin;
import org.pulem3t.crm.entry.Customer;
import org.pulem3t.crm.entry.Manager;
import org.pulem3t.crm.entry.Order;
import org.pulem3t.crm.entry.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/base")
public class ClearBaseController {
	
	protected static Logger logger = Logger.getLogger("ClearBaseController");
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private ManagerDAO managerDAO;
	@Autowired
	private VendorDAO vendorDAO;
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value="/clear", method=RequestMethod.GET)
	public @ResponseBody String clear() {
		
		Long startTime = System.currentTimeMillis();
		try {
			List<Admin> adminList = adminDAO.getAdmins();
			Iterator<Admin> itAdmin = adminList.iterator();
			while(itAdmin.hasNext()) {
				adminDAO.delAdmin(itAdmin.next().getId());
			}
			
			List<Customer> customerList = customerDAO.getCustomers();
			Iterator<Customer> itCustomer = customerList.iterator();
			while(itCustomer.hasNext()) {
				customerDAO.delCustomer(itCustomer.next().getId());
			}
			
			List<Manager> managerList = managerDAO.getManagers();
			Iterator<Manager> itManager = managerList.iterator();
			while(itManager.hasNext()) {
				managerDAO.delManager(itManager.next().getId());
			}
			
			List<Vendor> vendorList = vendorDAO.getVendors();
			Iterator<Vendor> itVendor = vendorList.iterator();
			while(itVendor.hasNext()) {
				vendorDAO.delVendor(itVendor.next().getId());
			}
			
			List<Order> orderList = orderDAO.getOrders();
			Iterator<Order> itOrder = orderList.iterator();
			while(itOrder.hasNext()) {
				orderDAO.delOrder(itOrder.next().getId());
			}
			Long clearTime = System.currentTimeMillis() - startTime;
			
			logger.info("BASE: Base cleared in " + clearTime + " ms");
			JSONObject o = new JSONObject();
			o.put("Success", "true");
			o.put("ClearTime", clearTime);
			return o.toString(4);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
