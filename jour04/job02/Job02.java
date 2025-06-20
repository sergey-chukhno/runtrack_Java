import java.util.Scanner;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;

class Job02 {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir la longueur de la chaîne à générer : ");
    int longueur = scanner.nextInt();
    scanner.nextLine(); 

    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder(longueur);
    Random random = new Random();

    for (int i = 0; i < longueur; i++) {
      int idx = random.nextInt(chars.length());
      sb.append(chars.charAt(idx));
    }
    String randomString = sb.toString();

    try (FileOutputStream fos = new FileOutputStream("jour04/job02/output.txt")) {
      fos.write(randomString.getBytes());
      System.out.println("La chaîne aléatoire a été écrite dans jour04/job02/output.txt");
    } catch (IOException e) {
      System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}