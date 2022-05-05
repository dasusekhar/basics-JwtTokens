package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class WelcomeController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
	public  String welcome()
	{
		return "welcome to spring security";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception
	{
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(),authrequest.getPassword()));
		}catch(Exception ex)
		{
			throw new Exception("invalid username/password ");
		}
		return jwtUtil.generateToken(authrequest.getUserName());
		
	}

}
