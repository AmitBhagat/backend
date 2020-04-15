package com.dalrada.gateway.service;

import java.util.Optional;

import com.dalrada.gateway.util.User;


public interface UserAuthenticationService {
	 /**
	   * Logs in with the given {@code username} and {@code password}.
	   *
	   * @param username
	   * @param password
	   * @return an {@link Optional} of a user when login succeeds
	   */
	  Optional<String> login(String username, String password);

	  /**
	   * Finds a user by its dao-key.
	   *
	   * @param token user dao key
	   * @return
	   */
	  Optional<User> findByToken(String token);

	  /**
	   * Logs out the given input {@code user}.
	   *
	   * @param user the user to logout
	   */
	  void logout(String id);
	}