package jour04.job04;

import java.util.Scanner;

class Job04 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le nombre maximum à compter : ");
    int max = scanner.nextInt();
    scanner.nextLine();

    long startTime = System.currentTimeMillis();
    int count = 0;
    for (int i = 1; i <= max; i++) {
      count = i;
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Compte final : " + count);
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}