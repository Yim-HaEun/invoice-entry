package com.example.invoice.entry.controller.common;

import com.example.invoice.entry.dto.SignupForm;
import com.example.invoice.entry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.invoice.entry.utils.AuthUtils.isAnonymous;

@Controller
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

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
	public String login(Authentication auth) {
		if (!isAnonymous(auth)) {
			return "redirect:/";
		}
		return "login";
	}
}