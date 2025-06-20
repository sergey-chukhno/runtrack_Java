package jour04.job03;

import java.util.Scanner;
import java.util.Random;
import java.io.RandomAccessFile;
import java.io.IOException;

class Job03 {
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

    int mid = randomString.length() / 2;
    String firstHalf = randomString.substring(0, mid);
    String secondHalf = randomString.substring(mid);

    class WriteHalfTask implements Runnable {
      private String data;
      private int offset;
      private String filePath;

      public WriteHalfTask(String data, int offset, String filePath) {
        this.data = data;
        this.offset = offset;
        this.filePath = filePath;
      }

      @Override
      public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
          raf.seek(offset);
          raf.write(data.getBytes());
        } catch (IOException e) {
          System.out.println("Erreur lors de l'écriture par un thread : " + e.getMessage());
        }
      }
    }

    String filePath = "jour04/job03/output.txt";
    Runnable firstTask = new WriteHalfTask(firstHalf, 0, filePath);
    Runnable secondTask = new WriteHalfTask(secondHalf, mid, filePath);
    Thread thread1 = new Thread(firstTask);
    Thread thread2 = new Thread(secondTask);

    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      System.out.println("Erreur lors de l'attente des threads : " + e.getMessage());
    }
    System.out.println("Les deux threads ont terminé l'écriture.");
    long endTime = System.currentTimeMillis();
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}