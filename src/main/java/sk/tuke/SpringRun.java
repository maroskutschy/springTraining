package sk.tuke;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRun {

  public static void main(String[] args) {

    System.out.println("test");

    SpringApplication.run( SpringRun.class, args );

  }

//  @Bean
//  public CommandLineRunner runner(HelloWorld helloWorld) {
//    //return  new MyCommandLineRunner();
////    return  new CommandLineRunner() {
////      @Override public void run(String... args) throws Exception {
////        System.out.println("Running");
////      }
////    };
//
//
//
//
//
//    return (args) -> {
//      System.out.println("Running");
//      helloWorld.sayHello();
//    };
//  }


  @Bean
  public CommandLineRunner runner(MyApplication myApplication){
    return  args -> myApplication.execute();
  }


//    public class MyCommandLineRunner implements  CommandLineRunner{
//      @Override
//      public void  run(String...args) throws Exception {
//        //System.out.println("Running");
//      }
//    }

//  @Bean
//  public MyApplication myApplication (HelloWorld helloWorld) {
//    return new MyApplication(helloWorld);
//  }


}


