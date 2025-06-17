import java.util.Scanner;

public class job12 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez un nombre entier n : ");
    int n = scanner.nextInt();

    System.out.println("Nombres pairs inférieurs ou égaux à " + n + " :");
    for (int i = 0; i <= n; i++) {
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
    scanner.close();
  }
}
