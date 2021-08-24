package com.ganesh.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.Service.Impl.Security.UserDetailsServiceImpl;
import com.ganesh.config.JwtUtil;
import com.ganesh.model.User.User;
import com.ganesh.model.security.JwtRequest;
import com.ganesh.model.security.JwtResponse;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtutil;

	@PostMapping("/authenticate")
	public ResponseEntity authenticateUser(@RequestBody JwtRequest jwtrequest) throws Exception {
		System.out.println("from authenticateUser method"+ jwtrequest.getUsername());
		try {
			this.authenticate(jwtrequest.getUsername(), jwtrequest.getPassword());
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not Found");
		}
//		User is authenticated, so loading the user
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtrequest.getUsername());
//		Generating the token
		String token = this.jwtutil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLED "+ e.getMessage());
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID CREDENTIALS"+ e.getMessage());
		}
	}
	
	
//	get current logged in user : User or admin
//	Principal represents the abstract notion of a principal, which can be used to 
//	represent any entity, such as an individual, a corporation, and a login id.
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
		
	}

}
