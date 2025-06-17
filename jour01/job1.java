public class job1 {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("Entrez votre prénom : ");
    String prenom = scanner.nextLine();
    System.out.println("bonjour " + prenom);
    scanner.close();
  }
}
