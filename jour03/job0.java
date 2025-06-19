package jour03;

public class job0 {
  class AbstractFinal {
    public static void main(String[] args) {
      A[] tab = new A[3];
      // tab[0] = new A(); Abstract class cannot be instantiated. 
      tab[1] = new B();
      tab[2] = new C();
      tab[1].b = 2;
      //((C) tab[2]).c = 3; In class C, c is final and cannot be modified. 
    }
  }

  abstract class A {
    int a;
  }

  class B extends A {
    int b;
  }
  
  class C extends A {
    final double c = 1;
  }

  abstract class D extends A {
    double d;

    int operation(int a) {
      return (a * 2);
    }
    // abstract int calcul (int b) {} Abstract method should not have a body.  
   }

}
