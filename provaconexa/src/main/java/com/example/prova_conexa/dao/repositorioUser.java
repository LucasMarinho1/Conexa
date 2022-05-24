package com.example.prova_conexa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.prova_conexa.modal.user;

public interface repositorioUser extends CrudRepository<user, Integer>{
	
	@Query("SELECT u FROM TB_USER u WHERE u.email = :email")
	user findUsuario(@Param("email") String email);
	
}
