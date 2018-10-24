package sk.tuke;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld {

  public HelloWorldImpl() {
    System.out.println("Hello World created");
  }

  @Override public void sayHello() {

    System.out.println("Hello World");

  }
}
