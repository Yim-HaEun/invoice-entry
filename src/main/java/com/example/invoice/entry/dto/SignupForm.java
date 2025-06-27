package com.example.invoice.entry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupForm {
	private String username;
	private String email;
	private String password;
	private String nickname;
}
