package com.techelevator.fbn.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.fbn.model.CheckingAccountApplication;

@Controller
@RequestMapping("/checkingApplication")
public class CheckingApplicationController {

	@RequestMapping(path = { "/", "/personalInformationInput" }, method = RequestMethod.GET)
	public String displayPersonalInformationInput() {
		return "checkingApplication/personalInformationInput";
	}

	@RequestMapping(path = "/thankYou", method = RequestMethod.GET)
	public String displayThankYou() {
		return "checkingApplication/thankYou";
	}
	
	@RequestMapping("/test")
	public String test(HttpSession session) {
		session.invalidate();
		return "checkingApplication/test";
	}
	
	@RequestMapping (path = "/personalInformationInput", method = RequestMethod.POST)
	public String openCheckingAccount (@RequestParam String firstName, @RequestParam String lastName, @DateTimeFormat(pattern = "MM/dd/yyyy") @RequestParam LocalDate dateOfBirth, @RequestParam String stateOfBirth, @RequestParam String emailAddress, @RequestParam String phoneNumber, HttpSession session) {
		
		CheckingAccountApplication account = new CheckingAccountApplication();
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setDateOfBirth(dateOfBirth);
		account.setStateOfBirth(stateOfBirth);
		account.setEmailAddress(emailAddress);
		account.setPhoneNumber(phoneNumber);
		
		session.setAttribute("Application", account);
		
		return "redirect:/checkingApplication/addressInput";
	}
	
	@RequestMapping (path= "/addressInput", method = RequestMethod.GET)
	public String accountNextStep() {
		return "checkingApplication/addressInput";
	}
	
	@RequestMapping (path = "/addressInputUrl", method = RequestMethod.POST)
	public String processAddressInput(@RequestParam String streetAddress, @RequestParam String apartmentNumber, @RequestParam String city, @RequestParam String state, @RequestParam String zipCode, HttpSession session) {
		
		CheckingAccountApplication account = (CheckingAccountApplication) session.getAttribute("Application");
		account.setAddressStreet(streetAddress);
		account.setAddressApartment(apartmentNumber);
		account.setAddressCity(city);
		account.setAddressState(state);
		account.setAddressZip(zipCode);
		
		return "redirect:/checkingApplication/summary";
	}
	
	@RequestMapping (path = "/summary")
	public String displaySummary() {
		return "checkingApplication/summary";
	}
	
}
