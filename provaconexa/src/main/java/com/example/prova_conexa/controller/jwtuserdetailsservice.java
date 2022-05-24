package com.example.prova_conexa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.prova_conexa.dao.repositorioUser;
import com.example.prova_conexa.modal.user;

@Service
public class jwtuserdetailsservice implements UserDetailsService {
	@Autowired
	private repositorioUser repositorio;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		user usuario = repositorio.findUsuario(nome);

		if (usuario != null) {
			return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + nome);
		}
	}
}
