package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller
public class HelloController {
	
	@Autowired
	private ReviewDao reviewDao;

	@RequestMapping(path = {"/", "/greeting"})
	public String displayHomePage(ModelMap map) {
		List <Review> reviews = reviewDao.getAllReviews();
		map.addAttribute("reviews", reviews);
		return "greeting";
	}
	
	@RequestMapping(path = "/postSubmission")
	public String displayPostSubmission() {
		return "postSubmission";
	}
	

	@RequestMapping(path="/postSubmission", method=RequestMethod.POST)
	public String submitPost(@RequestParam String userName, @RequestParam int rating, @RequestParam String title, @RequestParam String postText) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		Review theReview = new Review();
		theReview.setUsername(userName);
		theReview.setRating(rating);
		theReview.setTitle(title);
		theReview.setText(postText);
		theReview.setDateSubmitted(currentTime);
		reviewDao.save(theReview);
		
		return "redirect:/submissionConfirmation";
	}
	
	@RequestMapping (path = "/submissionConfirmation")
	public String submissionConfirmation() {
		return "submissionConfirmation";
	}

}
