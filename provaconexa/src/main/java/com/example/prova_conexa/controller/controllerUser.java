package com.example.prova_conexa.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_conexa.config.security.JwtTokenUtil;
import com.example.prova_conexa.dao.repositorioUser;
import com.example.prova_conexa.modal.jwtresponse;
import com.example.prova_conexa.modal.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * Controller Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@Api(value = "Autentication Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Autenticação-controller"}, description = "autenticação")
public class controllerUser {

	@Autowired
	private repositorioUser Repositorio;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private jwtuserdetailsservice userDetailsService;
	
	@ApiOperation(value = "SingUp")
    @RequestMapping(method=RequestMethod.POST, value="/singup", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody user user) {

        Repositorio.save(user);

        return ResponseEntity.ok("Médico cadastrado!");
    }
	
	
	@ApiOperation(value = "Login")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody user authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getSenha());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new jwtresponse(token));
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			throw new Exception("USUARIO_DESATIVADO", e);
		} catch (BadCredentialsException e) {
			throw new Exception("CREDENCIAIS_INVALIDAS", e);
		}
	}
   
}
