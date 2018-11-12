package sk.tuke.task_register;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMain {

  public static void main(String[] args) {

    System.out.println( "test" );

    SpringApplication.run( SpringMain.class, args );

  }

  @Bean
  public CommandLineRunner runner (ConsoleUI ui) {
    return  args -> ui.run();
  }

  @Bean
  public ConsoleUI consoleUI(Register register) {
    return  new ConsoleUI( register );
  }

  @Bean
  public Register register(List<Person> people) {
    RegisterImpl register = new RegisterImpl();
    people.forEach( (register::addPerson) );
    return  register;
  }

  @Bean
  public Register register() {
    return  new RegisterImpl();
  }

  @Bean
  public  Person person1() {
    return  new Person ("N1", "014454545") ;
  }

  @Bean
  public  Person person2() {
    return  new Person ("N2", "014454546") ;
  }

  @Bean
  public  Person person3() {
    return  new Person ("N3", "014454547") ;
  }

  @Bean
  public  Person person4() {
    return  new Person ("N4", "014454548") ;
  }

}