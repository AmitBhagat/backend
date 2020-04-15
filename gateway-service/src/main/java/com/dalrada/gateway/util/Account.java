package com.dalrada.gateway.util;

public class Account {
	private String username;
    private String password;
    private Long id ;
    private boolean active;
	public Account(Long id ,String username, String password, boolean active) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		
	}
	
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isActive() {
		return active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [username=").append(username).append(", password=").append(password).append(", id=")
				.append(id).append(", active=").append(active).append("]");
		return builder.toString();
	}

}
