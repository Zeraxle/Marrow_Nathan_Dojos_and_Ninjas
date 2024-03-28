package com.nathanm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nathanm.models.Dojo;
import com.nathanm.models.Ninja;
import com.nathanm.services.DojoService;
import com.nathanm.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService service;
	
	@Autowired DojoService dService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Dojo> dojos = dService.getAll();
		viewModel.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dService.getAll();
			viewModel.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		}
		else {
			service.create(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
