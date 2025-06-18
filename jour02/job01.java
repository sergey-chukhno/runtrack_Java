package jour02;

public class Toto {
  int toto = 0;

  Toto() {
    toto = toto + 1;
  }

  public static void main(String[] toto) {
    Toto t1 = new Toto();
    Toto t2 = new Toto();
    System.out.println("Toto: " + toto);
  }
}
