import java.util.Scanner;

class Job06 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir la taille du tableau : ");
    int size = scanner.nextInt();
    int[] numbers = new int[size];
    System.out.println("Veuillez saisir les nombres :");
    for (int i = 0; i < size; i++) {
      numbers[i] = scanner.nextInt();
    }

    long startTime = System.currentTimeMillis();
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += numbers[i];
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Somme totale : " + sum);
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}