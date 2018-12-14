package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Test {
  public static void main(String[] args) throws Exception {
    Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost/spring", "postgres", "postgres" );
    SORM sorm = new SORM(connection);
//    System.out.println(sorm.getCreateString(Student.class  ));
//    System.out.println(sorm.getInsertString(Student.class  ));
//    System.out.println(sorm.getSelectString(Student.class  ));
//    Student student = new Student( "Ferko", "Uhorka", 28 );
//    sorm.insert(student);
//
//     List<Student> list = sorm.select( Student.class );


        System.out.println(sorm.getCreateString(Skolenie.class  ));
        System.out.println(sorm.getInsertString(Skolenie.class  ));
        System.out.println(sorm.getSelectString(Skolenie.class  ));
        Skolenie skolenie = new Skolenie( "Spring", 16, "Jaro" );
        sorm.insert(skolenie);

         List<Skolenie> list = sorm.select( Skolenie.class );
         System.out.println(list);

  }
  }


