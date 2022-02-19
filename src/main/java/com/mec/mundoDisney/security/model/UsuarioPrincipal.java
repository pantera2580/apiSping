package com.mec.mundoDisney.security.model;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author pantera2580
 * Clase que retorna por cada Entidad las authorithies respectivas
 */

public class UsuarioPrincipal implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String userName;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrincipal(String name, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name()))
				.collect(Collectors.toList()); 
		return new UsuarioPrincipal(usuario.getName(), usuario.getUserName(), usuario.getEmail(), usuario.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return userName;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
}
