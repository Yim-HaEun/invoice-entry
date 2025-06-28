package com.example.invoice.entry.utils;

import org.springframework.security.core.Authentication;

public class AuthUtils {
	public static boolean isAnonymous(Authentication auth) {
		return auth == null
				|| !auth.isAuthenticated()
				|| "anonymousUser".equals(auth.getPrincipal());
	}
}