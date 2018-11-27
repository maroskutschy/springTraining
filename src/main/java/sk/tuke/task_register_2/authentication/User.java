package sk.tuke.task_register_2.authentication;

public class User {
	String name;
	Role[] role;
	
	
	public User(String name, Role[] role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role[] getRole() {
		return role;
	}
	public void setRole(Role[] role) {
		this.role = role;
	}
	
}
