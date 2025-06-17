public class job05 {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Entre le premier nombre : ");
    int num1 = scanner.nextInt();
    System.out.println("Entre le deuxième nombre : ");
    int num2 = scanner.nextInt();
    System.out.println("Entre le troisième nombre : ");
    int num3 = scanner.nextInt();

    System.out.println("Le maximum de " + num1 + " et " + num2 + " est : " + Math.max(num1, num2));
    System.out.println("Le maximum de " + num1 + " et " + num3 + " est : " + Math.max(num1, num3));
    System.out.println("Le maximum de " + num2 + " et " + num3 + " est : " + Math.max(num2, num3));

    scanner.close();
  }
}