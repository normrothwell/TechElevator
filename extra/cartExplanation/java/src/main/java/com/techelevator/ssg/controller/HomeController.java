package com.techelevator.ssg.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.techelevator.ssg.model.store.Order;
import com.techelevator.ssg.model.store.OrderItem;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller
public class HomeController {

	@Autowired
	ProductDao dao;

	// >Sends you to the main store front.
	@RequestMapping("/")
	public String displayHomePage(ModelMap map) {

		List<Product> storeItems = dao.getAllProducts();
		map.put("itemsForSale", storeItems);
		return "store";
	}

	// >Sends you to the detail page, from where you can click buy.
	@RequestMapping("/detail")
	public String showDetailPage(@RequestParam long id, ModelMap map) {

		Product product = dao.getProductById(id);
		map.put("product", product);

		return "detail";
	}

	// >Sends you to the shopping cart summary.
	@RequestMapping("/shoppingCart")
	public String showCart(@RequestParam long productId, @RequestParam int quantity, HttpSession session) {

		OrderItem orderItem = new OrderItem();
		Product product = dao.getProductById(productId);

		orderItem.setProductId(product.getId());
		orderItem.setProductName(product.getName());
		orderItem.setQuantity(quantity);
		
		//***************************
		// Scenario 1: No cart, just started shopping.
		// Outcome:
		// - Create an order session.
		// - put the item in the cart.
		//***************************
		
		if (session.getAttribute("cart") == null) {

			Order order = new Order();
			List<OrderItem> orderItemList = order.getOrderItems();
			orderItemList.add(orderItem);
			session.setAttribute("cart", order);
		}
		
		//***************************
		// Scenario 2: Has a cart.
		// Outcome:
		// - The item will be added to the existing cart.
		//***************************
		
		else {

			Order order = (Order) session.getAttribute("cart");
			List<OrderItem> orderItemList = order.getOrderItems();

			// Call a method to find out if the product was previously added.
			int indexOfItemFound = itemFound(orderItemList, productId);
			
			//***************************
			// Scenario 2a: The item has been added before
			// Outcome:
			// - Grab the existing quantity bought.
			// - increment that quantity by 1.
			// - Update the Order with the new updated list of Order Items.
			//***************************
			
			if (indexOfItemFound != -1) {

				orderItem = orderItemList.get(indexOfItemFound);
				int newQuantity = orderItem.getQuantity() + quantity;
				orderItem.setQuantity(newQuantity);
			}
			
			//***************************
			// Scenario 2b: The item has not been added before
			// Outcome:
			// - Update the Order with the new updated list of Order Items.
			//***************************
			
			else {
				orderItemList.add(orderItem);
				order.setOrderItems(orderItemList);
			}

			// Update the cart.
			session.setAttribute("cart", order);
		}

		return "cart";
	}
	
	// >Send data to JDBC, destroy session, display thank you page.
	@RequestMapping("/finish")
	public String pay(HttpSession session) {
		
		// insert data into db.
		
		session.invalidate();
		return "thanks";
	}
	
	
	// >Destroys all session data, cart is emptied.
	@RequestMapping("/clear")
	public String clearCart(HttpSession session) {
		
		
		session.invalidate();
		return "redirect:/";
	}

	// Helper method to check if there is the product has been placed
	// in the cart before.
	public int itemFound(List<OrderItem> orderItemList, long itemId) {
		for (int i = 0; i < orderItemList.size(); i++) {
			if (orderItemList.get(i).getProductId() == itemId) {
				return i;
			}
		}

		return -1;
	}
}
