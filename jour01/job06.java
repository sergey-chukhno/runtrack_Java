import java.util.Scanner;

public class job06 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int somme = 0;
    int nombre;

    for (int i = 1; i <= 5; i++) {
      System.out.print("Entrez l'entier numéro " + i + " : ");
      nombre = scanner.nextInt();
      somme += nombre;
    }

    System.out.println("La moyenne des cinq entiers est : " + ((double) somme / 5));
    scanner.close();
  }
}