import java.util.Scanner;
public class job11 {
  public static void main(String[] args) {
    System.out.println("Entrez un nombre : ");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    int fact = 1;
    for (int i = 1; i <= num; i++) {
      fact *= i;
    }
    System.out.println("La factorielle de " + num + " est : " + fact);
    scanner.close();
  }
}
