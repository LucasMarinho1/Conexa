package com.example.prova_conexa.modal;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_AGENDA")
public class agenda {

	@Id
	@GeneratedValue
	private int id;
	private Date dataHora;
	@ManyToOne
    @JoinColumn(name = "id_paciente")
	private paciente idpacientes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	

	public paciente getIdpacientes() {
		return idpacientes;
	}
	public void setIdpacientes(paciente idpacientes) {
		this.idpacientes = idpacientes;
	}
	
}
