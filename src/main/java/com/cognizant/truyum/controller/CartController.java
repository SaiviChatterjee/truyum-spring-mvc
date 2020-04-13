package com.cognizant.truyum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.service.CartService;

@Controller
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	private CartService cartService;
	
	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam long menuItemId, RedirectAttributes redirectAttribute) {
		LOGGER.info("Start ");
		redirectAttribute.addAttribute("addCartStatus", cartService.addCartItem(Long.parseLong("1"), menuItemId));
		LOGGER.info("End ");
		return "redirect:show-menu-list-customer";
	}
	
	@GetMapping("/show-cart")
	public String showCart(@RequestParam(value="removeCartItemStatus",required = false) boolean removeCartItemStatus, @RequestParam(value = "userId") long userId,
			ModelMap model) {
		LOGGER.info("Start ");
		Cart cart = cartService.getAllCartItems(userId);
		System.out.println(cart);
		if (cart == null)
			return "cart-empty";
		model.put("userId", userId);
		model.put("removeCartItemStatus", removeCartItemStatus);
		model.put("cart", cart);
		LOGGER.info("End ");
		return "cart";
	}
	
	@GetMapping("remove-cart-item")
	public String removeCart(@RequestParam(value="userId") long userId, @RequestParam(value="menuItemId") long menuItemId, RedirectAttributes ra) {
		LOGGER.info("Start ");
		ra.addAttribute("userId", userId);
		ra.addAttribute("removeCartItemStatus", cartService.removeCart(1, menuItemId));
		LOGGER.info("End ");
		return "redirect:show-cart";
	}
}
