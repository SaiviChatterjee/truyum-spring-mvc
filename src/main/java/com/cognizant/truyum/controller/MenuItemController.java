package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	@Autowired
	MenuItemService menuItemService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false));
	}

	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("Start ");
		List<MenuItem> menuItemList = menuItemService.getMenuListAdmin();
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-admin";
	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) {
		LOGGER.info("Start ");
		List<MenuItem> menuItemList = menuItemService.getMenuListCustomer();
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("menuItemId") Long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.addAttribute("menuItem", menuItem);
		LOGGER.info("End");
		return "edit-menu-item";
	}

	@PostMapping("/show-edit-menu-item")
	public String editMenuItem(@ModelAttribute("menuItem") MenuItem menuItem, BindingResult bindingResult,ModelMap model) {
		LOGGER.info("Start");
		if(bindingResult.hasErrors()) {
			return "edit-menu-item";
		}
		if(menuItemService.modifyMenuItem(menuItem))
			model.put("success", "Menu Items details saved  successfully");
		else
			model.put("error", "Menu Items details update failed");
		LOGGER.info("End");
		return "edit-menu-item-status";
	}
	@ModelAttribute("categoryList")
		public List<String> getNumbersList() {
			List<String> numbersList = new ArrayList<String>();
			numbersList.add("Starters");
			numbersList.add("Main Course");
			numbersList.add("Dessert");
			numbersList.add("Drinks");
			return numbersList;
	   	}	
	}
