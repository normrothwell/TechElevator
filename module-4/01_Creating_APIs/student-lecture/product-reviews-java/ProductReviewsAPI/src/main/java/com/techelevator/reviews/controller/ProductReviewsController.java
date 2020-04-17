package com.techelevator.reviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.reviews.dao.ProductReviewDao;
import com.techelevator.reviews.exception.ProductReviewNotFoundException;
import com.techelevator.reviews.model.ProductReview;

@RestController
@CrossOrigin
@RequestMapping("/api/reviews")
public class ProductReviewsController {
	
	private ProductReviewDao productReviewDAO;
	
	public ProductReviewsController(ProductReviewDao productReviewDAO) {
		
		this.productReviewDAO = productReviewDAO;
	}
	
	@GetMapping
	public List<ProductReview> list() {
		return productReviewDAO.list();
	}
	
	@GetMapping("/{id}")
	public ProductReview read(@PathVariable int id) {
		
		ProductReview productReview = productReviewDAO.read(id);
		return productReview;
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductReview create(@RequestBody ProductReview productReview) {
		return productReviewDAO.create(productReview);
	}
	
	@PutMapping("/{id}")
	public ProductReview update (@RequestBody ProductReview productReview, @PathVariable int id) {
		ProductReview requestedReview = productReviewDAO.read(id);
		if (requestedReview != null) {
			return productReviewDAO.update(productReview);
		} else {
			throw new ProductReviewNotFoundException(id, "id not found");
		}
		
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable int id){
		ProductReview request = productReviewDAO.read(id);
		if(request != null) {
			productReviewDAO.delete(id);
		}else {
			throw new ProductReviewNotFoundException(id, "id not found");
		}
	}
	
}
