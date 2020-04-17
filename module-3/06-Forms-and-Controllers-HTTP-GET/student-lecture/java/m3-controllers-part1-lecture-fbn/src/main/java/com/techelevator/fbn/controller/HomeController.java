package com.techelevator.fbn.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.fbn.model.MortgageLoanEstimate;

@Controller
public class HomeController {
	
	@RequestMapping({"/home", "/"})
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String mortgageCalculatorResults(@RequestParam BigDecimal loanAmount, @RequestParam int loanTerm, @RequestParam BigDecimal rate, ModelMap map) {
		
		MortgageLoanEstimate estimate = new MortgageLoanEstimate(loanAmount, loanTerm, rate);
		map.put("estimate", estimate);
		
		return "mortgageCalculatorResult";
	}
	
	
	
}
