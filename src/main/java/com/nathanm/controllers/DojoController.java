package com.nathanm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nathanm.models.Dojo;
import com.nathanm.models.Ninja;
import com.nathanm.services.DojoService;
import com.nathanm.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService service;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new";
		}
		else {
			service.create(dojo);
			return "redirect:/dojo/new";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String dojoWithStudents(@PathVariable Long id, Model viewModel) { 
		Dojo dojo = service.getOne(id);
		List<Ninja> ninjas = dojo.getNinjas();
		viewModel.addAttribute("dojo", dojo);
		viewModel.addAttribute("ninjas", ninjas);
		return "dojoAndNinjas.jsp";
	}
}
