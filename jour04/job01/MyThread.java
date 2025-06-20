package jour04.job01;

public class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("Mon thread est en cours");
  }
}