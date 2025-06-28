package com.example.invoice.entry.controller;

import com.example.invoice.entry.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

import static com.example.invoice.entry.utils.AuthUtils.isAnonymous;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model m, Authentication auth) {

		if (isAnonymous(auth)) {
			return "redirect:/login";
		}

		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			return "redirect:/admin/users";
		}

		CustomUserDetails cud = (CustomUserDetails) auth.getPrincipal();
		m.addAttribute("nickname", cud.getNickname());
		return "home";
	}
}

