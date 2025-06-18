package jour02;

 public class Figure {
  double x;
  double y;

  public Figure(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void afficher() {
    System.out.println("Figure de coordonnées (" + x + ", " + y + ")");
  }

  public void setCentre(double x, double y) {
    this.x = x;
    this.y = y;
  }

}

class Rectangle extends Figure {
  protected int longueur;
  protected int largeur;

  public Rectangle(int longueur, int largeur, double x, double y) {
    super(x, y);
    this.longueur = longueur;
    this.largeur = largeur;
  }

  public double surface() {
    return longueur * largeur;
  }

  public double getLongueur() {
    return longueur;
  }

  public double getLargeur() {
    return largeur;
  }

  public void setLongueur(int longueur) {
    this.longueur = longueur;
  }

  public void setLargeur(int largeur) {
    this.largeur = largeur;
  }

}

class Cercle extends Figure {
  protected int rayon;

  public Cercle(int rayon, double x, double y) {
    super(x, y);
    this.rayon = rayon;
  }

  public void afficher() {
    System.out.println("Cercle de rayon " + rayon + " et de centre (" + x + ", " + y + ")");
  }

  public double surface() {
    return Math.PI * rayon * rayon;
  }

  public double getRayon() {
    return rayon;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setRayon(int rayon) {
    this.rayon = rayon;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setCentre(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean estInterieur(int x, int y) {
    return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y) <= rayon * rayon;
  }
}

public class RectangleColore extends Rectangle {
  protected String couleur;

  public RectangleColore(int longueur, int largeur, double x, double y, String couleur) {
    super(longueur, largeur, x, y);
    this.couleur = couleur;
  }

  public String getCouleur() {
    return couleur;
  }
}

public class CercleColore extends Cercle {
  protected String couleur;

  public CercleColore(int rayon, double x, double y, String couleur) {
    super(rayon, x, y);
    this.couleur = couleur;
  }

  public String getCouleur() {
    return couleur;
  }
}
