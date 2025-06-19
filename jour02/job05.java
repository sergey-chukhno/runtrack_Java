package jour02;

public class job05 {

  static class A {
    public A() {
    }
  }

  static class B extends A {
    public B() {
      super();
    }
  }

  static class C extends B {
    public C() {
      super();
    }
  }

  static class D extends A {
    protected int d = 1;

    public D(int x) {
      super();
      d = x;
    }

    public D() {
    }
  }

  static class E extends D {
    public E() {
    }
  }

  static class F extends D {
    public F() {
    }
  }

  class ABDCEF {
    public static void main(String[] args) {
      A a = new A();
      B b = new B();
      C c = new C();
      D d = new D();
      E e = new E();
      F f = new F();

      a = b;
      // b = a; Incorrect. A is of type A, which is not a B. Explicit cast is needed.
      a = (A) b; // Casting is allowed but not necessary as b is a sublcass of A.
      a = null;
      // null = a; Incorrect. null is not a variable.
      a = d;
      // b = d; Incorrect. D is not a B. Explicit cast is needed.
      a = e;
      d = e;

      A[] as = new A[10];
      as[0] = new A();
      as[1] = new B();
      as[2] = new D(2);
      as[3] = new E();
      as[4] = new C();
      as[5] = new D(4);
      as[6] = new B();

      rechercher(as);
      additionner(as);
    }

    private static void rechercher(A[] as) {
      int count = 0;
      for (A obj : as) {
        if (obj instanceof B) {
          count++;
        }
      }
      System.out.println("Il y a " + count + " instances de la classe B");
    }

    private static void additionner(A[] as) {
      int somme = 0;
      for (A obj : as) {
        if (obj instanceof D) {
          somme += ((D) obj).d;
        }
      }
      System.out.println("Somme des variables d : " + somme);
    }
  }
}