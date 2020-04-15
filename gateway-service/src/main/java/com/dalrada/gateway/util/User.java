package com.dalrada.gateway.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private static final long serialVersionUID = -1807557595485493099L;
	private Account account;
	    Collection<GrantedAuthority> authorities;
	    
	public void setAccount(Account account) {
		this.account = account;
	}


	public void setAuthorities(String[] roles) {
		this.authorities = Arrays.asList(roles)
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return account.getPassword();
	}

	
public Long getId() {
		
		return account.getId();
	}	

	@Override
	public String getUsername() {
		
		return account.getUsername();
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExampleUser [account=").append(account).append(", authorities=").append(authorities)
				.append("]");
		return builder.toString();
	}
	
	
	
}
