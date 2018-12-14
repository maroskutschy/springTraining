package task_register3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);

  }

  @Bean
  public CommandLineRunner runner(ContactService contactService) {
    return args -> {
      contactService().addContact( new Contact( "Janko", "123" ) );

      List<Contact> contacts =contactService.getContact();
      System.out.println(contacts);

    };
  }

  @Bean
  public ContactService contactService() {
    return  new ContactService();
  }

}
