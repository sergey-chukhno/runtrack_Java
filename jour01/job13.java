import java.util.Scanner;

public class job13 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez un nombre entier n (<= 9) : ");
    int n = scanner.nextInt();

    if (n > 9) {
      System.out.println("Le nombre doit être inférieur ou égal à 9.");
    } else {
      System.out.println("Table de multiplication de " + n + " :");
      for (int i = 1; i <= 10; i++) {
        System.out.println(n + " x " + i + " = " + (n * i));
      }
    }
    scanner.close();
  }
}
