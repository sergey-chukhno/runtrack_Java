public class job03 {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("Entrez votre nombre : ");
    int num = scanner.nextInt();
    System.out.println("Le carré de " + num + " est " + num * num);
    scanner.close();
  }
}

