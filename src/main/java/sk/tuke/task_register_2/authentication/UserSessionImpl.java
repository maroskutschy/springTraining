package sk.tuke.task_register_2.authentication;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserSessionImpl implements UserSession {
	private User currentUser;
	private Map<User, String> users;
	
	public UserSessionImpl() {
		users = new HashMap<>();
		users.put(new User("admin",new Role[]{Role.ADMIN,Role.USER,Role.GUEST}), "password");
		users.put(new User("user",new Role[] {Role.USER,Role.GUEST}), "password");
		users.put(new User("guest",new Role[] {Role.GUEST}), "password");
	}

	@Override
	public User getCurrentUser() {
		if(currentUser == null) {
			login();
		}
		return currentUser;
	}

	private void login() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Login to register.");
			System.out.print("login name: ");
			String login = reader.readLine();
			System.out.print("password: ");
			String password = reader.readLine();
			currentUser = authenticateUser(login, password);
		}catch(Exception e) {
			
		}
	}

	private User authenticateUser(String login, String password) {
		User user = users.keySet().stream().filter(u -> u.getName().equals(login)).findFirst().orElse(null);
		if(user == null) {
			throw new SecurityException("Incorrect username or password.");
		}
		if(password.equals(users.get(user))) {
			return user;
		}else {
			throw new SecurityException("Incorrect username or password.");
		}
	}
}
