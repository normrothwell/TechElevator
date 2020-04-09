package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Employee;
import com.techelevator.model.employeeDAO;

@Controller
public class HomeController {
	
	@Autowired
	employeeDAO employeeDao;

	@RequestMapping(value = {"/", "/home"})
	public String displayHomePage() {
		
		return "home";
	}
	
	@RequestMapping("/employee")
	public String displayEmployees(ModelMap map) {
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		map.addAttribute("allEmployees", allEmployees);
	return "employee";
	}
	
	@RequestMapping(path = "/addEmployee", method = RequestMethod.GET)
	public String displayAddEmployee(ModelMap map) {
		if (!map.containsAttribute("employee")) {
			map.put("employee", new Employee());
		}
		return "addEmployee";
	}
	
	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public String submitAddEmployee(@ModelAttribute Employee employee, BindingResult result, RedirectAttributes flash) {
		
		flash.addFlashAttribute("employee", employee);
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "employee", result);
			return "redirect:/addEmployee";
		}
		employeeDao.addNewEmployee(employee);
		return "redirect:/addEmployeeConfirmation";
	}
	
	@RequestMapping(path = "/addEmployeeConfirmation")
	public String employeeAddConfirmation() {
		return "addEmployeeConfirmation";
	}
		
}
