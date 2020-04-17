package com.techelevator.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;



@Controller
public class UserController {
	// GET: /
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMainScreen() {
		return "homePage";
	}

	// Add the following Controller Actions

	// GET: /register
	// Return the empty registration view
	
	@RequestMapping (path = "/registrationPage", method = RequestMethod.GET)
	public String getRegistrationPage(ModelMap map) {
		if (!map.containsAttribute("registrationPage")) {
			map.put("registrationPage", new Registration());
		}
		return "registrationPage";
	}
	
	@RequestMapping(path = "/registrationPage", method = RequestMethod.POST)
	public String processRegistrationForm(@Valid @ModelAttribute Registration registration, BindingResult result, RedirectAttributes flash) {

		flash.addFlashAttribute("registrationPage", registration);

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registrationPage", result);
			return "redirect:/registrationPage";
		}
		if (!registration.getEmail().equals(registration.getEmailConfirm())) {
			return "redirect:/registrationPage";
		}
		if (!registration.getPassword().equals(registration.getPasswordConfirm())) {
			return "redirect:/registrationPage";
		}
			
		return "redirect:/registrationConfirmation";
	}
	
	@RequestMapping(path= "/registrationConfirmation", method = RequestMethod.GET)
	public String returnRegistrationConfirmation() {
		return "registrationConfirmation";
	}
	
	
	
	@RequestMapping (path = "/loginPage", method = RequestMethod.GET)
	public String getLoginPage(ModelMap map) {
		if (!map.containsAttribute("loginPage")) {
			map.put("loginPage", new Login());
		}
		return "loginPage";
	}
	
	@RequestMapping(path = "/loginPage", method = RequestMethod.POST)
	public String processLoginForm(@Valid @ModelAttribute Login login, BindingResult result, RedirectAttributes flash) {

		flash.addFlashAttribute("loginPage", login);

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "loginPage", result);
			return "redirect:/loginPage";
		}
		return "redirect:/loginConfirmation";
	}
	
	@RequestMapping(path= "/loginConfirmation", method = RequestMethod.GET)
	public String returnLoginConfirmation() {
		return "loginConfirmation";
	}
	
	
	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)

	// GET: /login
	// Return the empty login view

	// POST: /login
	// Validate the model and redirect to a confirmation page if validation is
	// successful. Return the login view (if validation fails).

	// GET: /confirmation
	// Return the confirmation view
}
