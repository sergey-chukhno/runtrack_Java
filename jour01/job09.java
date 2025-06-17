import java.util.Scanner;

public class job09 {
  public static void main(String[] args) {
    System.out.println("Entrez votre age : ");
    Scanner scanner = new Scanner(System.in);
    int age = scanner.nextInt();

    if (age < 18) {
      System.out.println("Vous êtes mineur");
    } else {
      System.out.println("Vous êtes majeur");
    }
  }
  
}
