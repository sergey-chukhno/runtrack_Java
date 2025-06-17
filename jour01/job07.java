import java.util.Scanner;

public class job07 {
  public static void main(String[] args) {
    int num;
    int sum = 0;
    Scanner scanner = new Scanner(System.in);
    
    for (int i = 0; i <= 100; i++) {
      System.out.println("Entre le nombre : ");
      num = scanner.nextInt();
      sum += num;
    }
    System.out.println("La somme des 100 premiers entiers est : " + sum);
  }
}
