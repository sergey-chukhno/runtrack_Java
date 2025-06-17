public class job10 {
  public static void main(String[] args) {
    int n = 8;
    int fact = 1;
    for (int i = 1; i <= n; i++) {
      fact *= i;
    }
    System.out.println("La factorielle de 8 est : " + fact);
  }
}
