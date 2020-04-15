package com.dalrada.gateway.util;

public class MailRequest {

	private String username ;
	private String emailId ;
	private String password ;
	private String ipAddress ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MailRequest [username=").append(username).append(", emailId=").append(emailId)
				.append(", password=").append(password).append(", ipAddress=").append(ipAddress).append("]");
		return builder.toString();
	}
	
}
