import java.util.Scanner;

class Job07 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir la taille du tableau : ");
    int size = scanner.nextInt();
    int[] numbers = new int[size];
    System.out.println("Veuillez saisir les nombres :");
    for (int i = 0; i < size; i++) {
      numbers[i] = scanner.nextInt();
    }

    int mid = size / 2;
    int start1 = 0;
    int end1 = mid - 1;
    int start2 = mid;
    int end2 = size - 1;

    class SumTask implements Runnable {
      private int[] arr;
      private int start, end;
      private int result;

      public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
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
          result += arr[i];
        }
      }
    }
    SumTask task1 = new SumTask(numbers, start1, end1);
    SumTask task2 = new SumTask(numbers, start2, end2);
    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);

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
    int totalSum = task1.getResult() + task2.getResult();
    System.out.println("Somme totale : " + totalSum);
    System.out.println("Temps d'exécution total : " + (endTime - startTime) + " ms");
    scanner.close();
  }
}