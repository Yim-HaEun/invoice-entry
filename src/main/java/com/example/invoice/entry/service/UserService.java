package com.example.invoice.entry.service;

import com.example.invoice.entry.dto.SignupForm;
import com.example.invoice.entry.entity.User;
import com.example.invoice.entry.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
	private final UserRepository repo;
	private final PasswordEncoder encoder;

	public UserService(UserRepository repo, PasswordEncoder encoder) {
		this.repo = repo;
		this.encoder = encoder;
	}

	@Transactional
	public User register(SignupForm form) {
		User u = new User();
		u.setUsername(form.getUsername());
		u.setEmail(form.getEmail());
		u.setNickname(form.getNickname());
		u.setPassword(encoder.encode(form.getPassword()));
		return repo.save(u);
	}

	public List<User> findByStatus(User.Status status) {
		return repo.findAllByStatus(status);
	}

	@Transactional
	public void reject(Long userId) {
		User u = repo.findById(userId).orElseThrow();
		u.setStatus(User.Status.REJECTED);
		repo.save(u);
	}

	@Transactional
	public void approve(Long userId) {
		User u = repo.findById(userId).orElseThrow();
		u.setStatus(User.Status.APPROVED);
		repo.save(u);
	}
}
