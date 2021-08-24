package com.ganesh.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

//Class to take the token from request authorization and authenticate the token
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = null, jwtToken = null;

//		Get authorization header
		String requestTokenHeader = request.getHeader("Authorization");

//		 Checking whether the token starts with Bearer
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			yes
			jwtToken = requestTokenHeader.substring(7);

			try {
				username = this.jwtUtil.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("Jwt token has expired");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}

		} 
//		else if (!(requestTokenHeader.startsWith("Bearer "))) {
//			System.out.println("Token does not start with bearer string");
//
//		} 
		else {
			System.out.println("Invalid token");
		}
//		Validation
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

//			Checking whether the token is valid or not
//			If the token is valid setting the validated token to the context of securityContextHolder
			if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
//				token is valid, so setting the validated token to the context of securityContextHolder
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		} else {
			System.out.println("Token is not valid");
		}

//		Forwarding the request
		filterChain.doFilter(request, response);

	}

}
