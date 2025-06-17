import java.util.Scanner;

public class job14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez un nombre : ");
    int n = scanner.nextInt();
    int reversed = 0;

    while (n != 0) {
      int digit = n % 10;
      reversed = reversed * 10 + digit;
      n /= 10;
    }

    System.out.println("Le nombre inversé est : " + reversed);
    scanner.close();
  }
}
