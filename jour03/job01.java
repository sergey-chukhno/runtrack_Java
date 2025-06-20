package jour03;

public class job01 {
  static public class Rectangle {
    double largeur;
    double hauteur;

    Rectangle(double largeur, double hauteur) {
      this.largeur = largeur;
      this.hauteur = hauteur;
    };

    @Override
    public String toString() {
      return "Rectangle de largeur " + largeur + " et de hauteur " + hauteur;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null || getClass() != obj.getClass())
        return false;
      Rectangle other = (Rectangle) obj;
      return Double.compare(largeur, other.largeur) == 0 &&
          Double.compare(hauteur, other.hauteur) == 0;
    }
  }

  static class RectangleColore extends Rectangle {
    String couleur;

    RectangleColore(double largeur, double hauteur, String couleur) {
      super(largeur, hauteur);
      this.couleur = couleur;
    }

    @Override
    public String toString() {
      return super.toString() + " et de couleur " + couleur;
    }

    @Override
    public boolean equals(Object obj) {
      if (!super.equals(obj))
        return false;
      RectangleColore other = (RectangleColore) obj;
      return couleur.equals(other.couleur);
    }
  }

  static class ToStringEq {
    public static void main(String[] args) {
      System.out.println("Test 1: ");
      Rectangle rect = new Rectangle(12.5, 4.0);
      System.out.println(rect);
      System.out.println();

      System.out.println("Test 2: ");

      RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
      System.out.println(rect1);
      System.out.println();

      System.out.println("Test 3: ");
      RectangleColore rect2 = new RectangleColore(25.0 / 2, 8.0 / 2, new String("rouge"));
      System.out.println(rect2);
      System.out.println();

      System.out.println(rect1.equals(rect2));
      System.out.println(rect2.equals(rect1));
      System.out.println(rect1.equals(null));
      System.out.println(rect.equals(rect1));
      System.out.println(rect1.equals(rect));

    }

  }
}
