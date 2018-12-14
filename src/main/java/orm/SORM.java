package orm;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SORM {

  private Connection connection;

  public SORM(Connection connection) {
    this.connection = connection;
  }

  public String getCreateString(Class<?> clazz) {
    //   StringBuilder sb = new StringBuilder(  );
    //   sb.append( "CREATE TABLE " + clazz.getSimpleName() + "(\n");
    //   for( Field field : clazz.getDeclaredFields(  )) {
    //     sb.append(field.getName() + " " + getSQLType(field) + "\n");
    //   }
    //   sb.append( ")" ) ;
    //   return  sb.toString();
    return String.format( "CREATE TABLE %s (%s)",
                          clazz.getSimpleName(),
                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> f.getName() + " " + getSQLType( f ) ).collect( Collectors.joining( ", " ) )
    );

  }

  public String getInsertString(Class<?> clazz) {
    return String.format( "INSERT INTO %s (%s) VALUES (%s);",
                          clazz.getSimpleName(),
                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> f.getName() ).collect( Collectors.joining( ", " ) ),
                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> "?" ).collect( Collectors.joining( ", " ) )
    );
  }

  public String getSelectString(Class<?> clazz) {
    return String.format( "SELECT %s FROM %s;",

                          Arrays.stream( clazz.getDeclaredFields() ).map( f -> f.getName() ).collect( Collectors.joining( ", " ) ),
                          clazz.getSimpleName()

    );

  }

  private String getSQLType(Field field) {
    field.getType();
    String javaType = field.getType().getName();
    //return "VARCHAR(64)";
    switch( javaType ) {
      case "java.lang.String":
        return "VARCHAR(64)";
      case "int":
        return "INTEGER";
    }
    throw new IllegalArgumentException( "Not supported  " + javaType );

  }

  public void insert(Object object) throws SQLException, IllegalAccessException {
    Class<?> clazz = object.getClass();
    String command = getInsertString( clazz );

    try( PreparedStatement ps = connection.prepareStatement( command ) ) {
      int index = 1;
      for( Field field : clazz.getDeclaredFields() ) {
        field.setAccessible( true );
        ps.setObject( index, field.get( object ) );
        index++;
      }
      ps.executeUpdate();
    }

  }

  public <T> List<T> select(Class<T> clazz) throws SQLException, IllegalAccessException, InstantiationException {
    String command = getSelectString( clazz );

    try( Statement s = connection.createStatement();
         ResultSet rs = s.executeQuery( command ); ) {
      List<T> list = new ArrayList<>();
      while( rs.next() ) {
        T object = clazz.newInstance();
        int index = 1;
        for( Field field : clazz.getDeclaredFields() ) {
          field.setAccessible( true );
          field.set( object, rs.getObject( index ) );
          index++;
        }
        list.add(object);

      }
      return  list;
    }


  }

}
