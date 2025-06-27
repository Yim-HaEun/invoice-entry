package com.example.invoice.entry.controller;

import com.example.invoice.entry.dto.SignupForm;
import com.example.invoice.entry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class AuthController {
	private final UserService userService;
	public AuthController(UserService userService) { this.userService = userService; }

	@GetMapping("/signup")
	public String signupForm(Model m) {
		m.addAttribute("userDto", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSubmit(@ModelAttribute SignupForm form) {
		userService.register(form);
		return "redirect:/login?registered";
	}

	@GetMapping("/login")
	public String login() { return "login"; }
}