package orm;

public class Student {
  private String meno;
  private String priezvisko;
  private int vek;

  public Student() {
  }

  public Student(String meno, String priezvisko, int vek) {
    this.meno = meno;
    this.priezvisko = priezvisko;
    this.vek = vek;
  }

  public String getMeno() {
    return meno;
  }

  public String getPriezvisko() {
    return priezvisko;
  }

  public int getVek() {
    return vek;
  }

  public void setMeno(String meno) {
    this.meno = meno;
  }

  public void setPriezvisko(String priezvisko) {
    this.priezvisko = priezvisko;
  }

  public void setVek(int vek) {
    this.vek = vek;
  }

  @Override public String toString() {
    return "Student{" +
        "meno='" + meno + '\'' +
        ", priezvisko='" + priezvisko + '\'' +
        ", vek=" + vek +
        '}';
  }
}
