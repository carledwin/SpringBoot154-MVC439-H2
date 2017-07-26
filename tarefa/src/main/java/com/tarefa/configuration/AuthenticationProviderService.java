package com.tarefa.configuration;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tarefa.model.Usuario;

@Component
public class AuthenticationProviderService implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		//FIXME Somente para test
		String[] roles = {"ROLE_USUARIO"};
		Usuario usuario = new Usuario(auth.getName(), auth.getCredentials().toString(), Arrays.asList(roles), true);
		
		if(usuario != null){
			if(usuario.isEnabled()){
				Object principal = usuario.getUsername();
				Object credentials = usuario.getPassword();
				return  new UsernamePasswordAuthenticationToken(principal, credentials, usuario.getAuthorities());
			}else{
				throw new BadCredentialsException("Usuario desativado");
			}
		}
		
		throw new UsernameNotFoundException("Usuario ou Senha invalido.");
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
