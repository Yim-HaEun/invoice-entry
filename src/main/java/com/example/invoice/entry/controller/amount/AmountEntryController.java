package com.example.invoice.entry.controller.amount;

import com.example.invoice.entry.repository.InvoiceRepository;
import com.example.invoice.entry.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/amount")
public class AmountEntryController {  // 이름 수정
	private final InvoiceRepository repo;

	public AmountEntryController(InvoiceRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/invoice-entry")
	public String invoiceEntry(Model model, Authentication auth) {
		model.addAttribute("submitDisabled", false);
		CustomUserDetails cud = (CustomUserDetails) auth.getPrincipal();
		model.addAttribute("nickname", cud.getNickname());
		return "invoice-entry"; // templates/invoice-entry.html
	}
}
