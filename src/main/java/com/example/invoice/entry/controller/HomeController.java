package com.example.invoice.entry.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Authentication auth) {
		// 로그인된 사용자의 권한(ROLE_USER, ROLE_ADMIN 등)을 조회
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			// 관리자는 관리자 페이지로
			return "redirect:/admin/users";
		}
		// 그 외(ROLE_USER)는 일반 홈으로
		return "home";
	}
}
