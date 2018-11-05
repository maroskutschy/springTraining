package sk.tuke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

  @Autowired
  private  HelloWorld helloWorld;

//  public MyApplication (HelloWorld helloWorld) { this.helloWorld = helloWorld;}

  public void execute() {
    helloWorld.sayHello();
  }

}
