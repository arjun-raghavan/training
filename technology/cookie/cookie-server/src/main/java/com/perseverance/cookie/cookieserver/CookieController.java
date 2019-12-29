package com.perseverance.cookie.cookieserver;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

	@GetMapping("/set-cookie")
	public String setCookie(HttpServletResponse response) {
		// create a cookie
		Cookie cookie = new Cookie("username", "arjun");
		// add cookie to response
		response.addCookie(cookie);
		return "Cookie is set";
	}

	@GetMapping("/all-cookies")
	public String readAllCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			return Arrays.stream(cookies).map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
		}
		return "No cookies";
	}
}
