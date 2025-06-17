public class java04 {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Entre le premier nombre : ");
    int num1 = scanner.nextInt();
    System.out.println("Entre le deuxième nombre : ");
    int num2 = scanner.nextInt();
    System.out.println("Entre le troisième nombre : ");
    int num3 = scanner.nextInt();
    int max = 0;
    if (num1 > num2 && num1 > num3) {
      max = num1;
    } else if (num2 > num1 && num2 > num3) {
      max = num2;
    } else {
      max = num3;
    }
    System.out.println("Le plus grand nombre est : " + max);
    scanner.close();
  }
}