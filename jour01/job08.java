import java.util.Scanner;

public class job08 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Entrez un nombre entier n : ");
    int n = scanner.nextInt();
    int sum = 0;

    for (int i = 0; i <= n; i++) {
      sum += i * i * i;
    }
    System.out.println("La somme des " + n + " premiers cubes est : " + sum);
    scanner.close();
  }
}
