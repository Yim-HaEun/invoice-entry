package com.example.invoice.entry.repository;
import com.example.invoice.entry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	List<User> findAllByStatus(User.Status status);
}
