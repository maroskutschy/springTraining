package sk.tuke.task_register_2.authentication;

import java.util.Arrays;

public class RegisterPermissionsImpl implements RegisterPermissions {
	private UserSession session;
	
	public RegisterPermissionsImpl(UserSession session) {
		this.session = session;
	}

	@Override
	public boolean hasPermissions(Role role) {
		User user = session.getCurrentUser();
		if(user != null) {
			return Arrays.stream(user.getRole()).anyMatch(r -> role == r);
		}
		return false;
	}

}
