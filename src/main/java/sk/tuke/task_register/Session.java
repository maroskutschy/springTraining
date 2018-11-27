package sk.tuke.task_register;

import java.util.Scanner;

public class Session {

  boolean isLogged = false;




  public void login() {
    if( !isLogged ) {
      System.out.println( "Please log in" );
      Scanner sc = new Scanner( System.in );
      String selection = sc.nextLine();
      System.out.println( "Logged in as: " + selection );
      isLogged = true;
    }

  }

}
