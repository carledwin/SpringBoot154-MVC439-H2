package com.tarefa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Module name;

	@ManyToOne
	@JsonIgnore
	private Usuario usuario;

	@Override
	public String getAuthority() {
		return name.toString();
	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Module getName() {
		return name;
	}



	public void setName(Module name) {
		this.name = name;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public enum Module {
		DASHBOARD("ROLE_DASHBOARD"), USUARIO("ROLE_USUARIO");

		private String module;

		private Module(String module) {
			this.module = module;
		}

		public String getModule() {
			return module;
		}
	}

}