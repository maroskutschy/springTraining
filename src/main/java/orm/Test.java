package orm;

public class Test {
  public static void main(String[] args) throws Exception {
    SORM sorm = new SORM();
    System.out.println(sorm.getCreateString(Student.class  ));
    System.out.println(sorm.getInsertString(Student.class  ));
    System.out.println(sorm.getSelectedString(Student.class  ));
  }
}
