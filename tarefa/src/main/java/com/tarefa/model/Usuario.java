package com.tarefa.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	public Usuario() {
	}
	
	public Usuario(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public Usuario(String name, String username, String password, List<Role> roles) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public Usuario(Integer id, String name, String username, String password, String confirmPassword, String email,
			boolean enabled, Calendar cadastro, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.enabled = enabled;
		this.cadastro = cadastro;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@NotEmpty
	private String email;
	
	@NotNull
	private boolean enabled;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar cadastro;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getCadastro() {
		return cadastro;
	}

	public void setCadastro(Calendar cadastro) {
		this.cadastro = cadastro;
	}

	@SuppressWarnings("rawtypes")
	public List getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
