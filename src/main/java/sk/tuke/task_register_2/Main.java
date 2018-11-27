package sk.tuke.task_register_2;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sk.tuke.task_register_2.authentication.RegisterPermissions;
import sk.tuke.task_register_2.authentication.RegisterPermissionsImpl;
import sk.tuke.task_register_2.authentication.UserSession;
import sk.tuke.task_register_2.authentication.UserSessionImpl;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {      
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(ConsoleUI console) {
		return args-> console.run();
	}
	
	@Bean
	public ConsoleUI console(Register register) {
		return new ConsoleUIImpl(register);
	}
	
	@Bean
	public Register register(List<Person> persons) {
		return new RegisterImpl(persons);
	}
	
	@Bean
	public UserSession userSession() {
		return new UserSessionImpl();
	}
	
	@Bean
	public RegisterPermissions registerPermissions(UserSession userSession) {
		return new RegisterPermissionsImpl(userSession);
	}
	
	@Bean
	public Person jankoHrasko() {
		return new Person("Janko Hrasko", "0907214578");
	}
	
	@Bean
	public Person ferkoHrasko() {
		return new Person("Ferko Hrasko", "0907214558");
	}
	
	@Bean
	public Person zuzaHrasko() {
		return new Person("Zuza Hrasko", "0907564548");
	}
	
	@Bean
	public Person ancaHrasko() {
		return new Person("Anca Hrasko", "0908574558");
	}
	
	
}
