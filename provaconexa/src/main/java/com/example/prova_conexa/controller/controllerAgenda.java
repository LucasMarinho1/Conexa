package com.example.prova_conexa.controller;

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
import com.example.prova_conexa.dao.repositorioAgenta;
import com.example.prova_conexa.dao.repositorioUser;
import com.example.prova_conexa.modal.agenda;
import com.example.prova_conexa.modal.jwtresponse;
import com.example.prova_conexa.modal.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;


/**
 * Controller Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@Api(value = "Agendamento Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Agendamento-controller"}, description = "agendamento")
public class controllerAgenda {

	@Autowired
	private repositorioAgenta Repositorio;
	

	
	@ApiOperation(value = "Attendance")
    @RequestMapping(method=RequestMethod.POST, value="/attendance", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAgenda(@RequestBody agenda Agenda) {

        Repositorio.save(Agenda);

        return ResponseEntity.ok("Atendimento cadastrado!");
    }
	


}
