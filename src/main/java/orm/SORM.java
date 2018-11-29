package orm;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SORM {

 public String getCreateString (Class<?> clazz) {
//   StringBuilder sb = new StringBuilder(  );
//   sb.append( "CREATE TABLE " + clazz.getSimpleName() + "(\n");
//   for( Field field : clazz.getDeclaredFields(  )) {
//     sb.append(field.getName() + " " + getSQLType(field) + "\n");
//   }
//   sb.append( ")" ) ;
//   return  sb.toString();
   return  String.format( "CREATE TABLE %s (%s)",
                          clazz.getSimpleName(),
                          Arrays.stream( clazz.getDeclaredFields()).map(f -> f.getName() + " " + getSQLType( f )).collect( Collectors.joining(", ") )
                          );

 }

  public String getInsertString (Class<?> clazz) {
    return String.format( "CREATE INTO %s (%s) VALUES (%s);",
                          clazz.getSimpleName(),
                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> f.getName() ).collect( Collectors.joining( ", " ) ),
                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> "?" ).collect( Collectors.joining( ", " ) )
    );
  }

  public String getSelectedString (Class<?> clazz) {
    return  String.format( "SELECT %s FROM %s;",

                           Arrays.stream( clazz.getDeclaredFields()).map(f -> f.getName()).collect( Collectors.joining(", ") ),
                           clazz.getSimpleName()

    );

  }



  private String getSQLType(Field field) {
   field.getType();
   String javaType = field.getType().getName();
   //return "VARCHAR(64)";
    switch( javaType ) {
      case "java.lang.String" :
        return "VARCHAR(64)";
      case "int" :
        return  "INTEGER";
    }
    throw new IllegalArgumentException( "Not supported  " + javaType);




  }
}
