package orm;

public class Skolenie {
  private String nazov ;
  private int dlzkaVhodinach ;
  private String menoSkolitela ;

  public Skolenie() {
  }

  public Skolenie(String nazov, int dlzkaVhodinach, String menoSkolitela) {
    this.nazov = nazov;
    this.dlzkaVhodinach = dlzkaVhodinach;
    this.menoSkolitela = menoSkolitela;
  }

  public String getNazov() {
    return nazov;
  }

  public void setNazov(String nazov) {
    this.nazov = nazov;
  }

  public int getDlzkaVhodinach() {
    return dlzkaVhodinach;
  }

  public void setDlzkaVhodinach(int dlzkaVhodinach) {
    this.dlzkaVhodinach = dlzkaVhodinach;
  }

  public String getMenoSkolitela() {
    return menoSkolitela;
  }

  public void setMenoSkolitela(String menoSkolitela) {
    this.menoSkolitela = menoSkolitela;
  }

  @Override public String toString() {
    return "Skolenie{" +
        "nazov='" + nazov + '\'' +
        ", dlzkaVhodinach=" + dlzkaVhodinach +
        ", menoSkolitela='" + menoSkolitela + '\'' +
        '}';
  }
}
