package com.techelevator.fbn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* The @Controller annotation will make the Spring container aware
 * of this controller as a managed bean. Controllers in Spring Web
 * MVC are just plain old Java objects that are annotated to indicate
 * that they are an MVC controller
 *
 * The @Controller annotation indicates to the Spring framework
 * that this class should be treated as a controller
 *
 * The <component-scan> element in springmvc-servlet.xml causes
 * Spring to look at all of the classes in the package specified
 * and look for classes with this annotation. This controller will
 * be found during the Spring component scan during application
 * startup.
 *
 * Controllers (and pretty much everything else in Spring) can also be
 * configured using XML.  However, annotations have become the
 * suggested way of wiring together a Spring application. */
@Controller
public class PaymentCalculatorController {
	
	@RequestMapping ("mortgageCalculatorInput")
	public String displayMortgageCalculator() {
		return "mortgageCalculatorInput";
	}

}
