package com.example.invoice.entry.controller.common;

import com.example.invoice.entry.entity.User;
import com.example.invoice.entry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminController {
	private final UserService userService;

	public AdminController(UserService userService) {
		this.userService = userService;
	}

	// 대기 중인 사용자 목록
	@GetMapping
	public String listPending(Model m) {
		List<User> pending = userService.findByStatus(User.Status.PENDING);
		m.addAttribute("users", pending);
		return "admin-users";
	}

	// 승인
	@PostMapping("/{id}/approve")
	public String approve(@PathVariable Long id) {
		userService.approve(id);
		return "redirect:/admin/users?tab=pending&result=approved";
	}

	// 거절
	@PostMapping("/{id}/reject")
	public String reject(@PathVariable Long id) {
		userService.reject(id);
		return "redirect:/admin/users?tab=pending&result=rejected";
	}
}
