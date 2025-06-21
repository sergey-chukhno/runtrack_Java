import java.util.Scanner;

class Job05 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le nombre maximum à compter : ");
    int max = scanner.nextInt();
    scanner.nextLine();

    int mid = max / 2;
    int start1 = 1;
    int end1 = mid;
    int start2 = mid + 1;
    int end2 = max;

    class RangeCounter implements Runnable {
      private int start, end;
      private int result;

      public RangeCounter(int start, int end) {
        this.start = start;
        this.end = end;
        this.result = 0;
      }

      public int getResult() {
        return result;
      }

      @Override
      public void run() {
        for (int i = start; i <= end; i++) {
          result = i;
        }
      }
    }
    RangeCounter counter1 = new RangeCounter(start1, end1);
    RangeCounter counter2 = new RangeCounter(start2, end2);
    Thread thread1 = new Thread(counter1);
    Thread thread2 = new Thread(counter2);

    long startTime = System.currentTimeMillis();
    thread1.start();
    thread2.start();
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      System.out.println("Erreur lors de l'attente des threads : " + e.getMessage());
    }
    long endTime = System.currentTimeMillis();
    int total = Math.max(counter1.getResult(), counter2.getResult());
    System.out.println("Compte final : " + total);
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}