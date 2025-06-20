package jour03;

// Base class for all cards
abstract class Carte {
  protected int cout;

  public Carte(int cout) {
    this.cout = cout;
  }

  // Method to display card info
  public abstract void afficher();
}

// Terrain card class
class Terrain extends Carte {
  private char couleur; // 'B', 'b', 'n', 'r', 'v'

  public Terrain(char couleur) {
    super(0); // Cost is always 0 for Terrain
    this.couleur = couleur;
    System.out.println("Type de carte : Terrain");
  }

  @Override
  public void afficher() {
    System.out.println("Coût : " + cout + ", Couleur : " + couleur);
  }
}

// Creature card class
class Creature extends Carte {
  private String nom;
  private int degats;
  private int vie;

  public Creature(String nom, int degats, int vie, int cout) {
    super(cout);
    this.nom = nom;
    this.degats = degats;
    this.vie = vie;
    System.out.println("Type de carte : Creature");
  }

  @Override
  public void afficher() {
    System.out.println("Coût : " + cout + ", Nom : " + nom + ", Dégâts : " + degats + ", Vie : " + vie);
  }
}

// Sortilege (Spell) card class
class Sortilege extends Carte {
  private String nom;
  private String explication;

  public Sortilege(String nom, String explication, int cout) {
    super(cout);
    this.nom = nom;
    this.explication = explication;
    System.out.println("Type de carte : Sortilege");
  }

  @Override
  public void afficher() {
    System.out.println("Coût : " + cout + ", Nom : " + nom + ", Explication : " + explication);
  }
}

// Game class to manage a collection of cards
class Jeu {
  private Carte[] cartes;
  private int nbCartes;

  public Jeu() {
    cartes = new Carte[10];
    nbCartes = 0;
  }

  // Add a card to the game (if space available)
  public void piocher(Carte carte) {
    if (nbCartes < 10) {
      cartes[nbCartes] = carte;
      nbCartes++;
      System.out.println("Carte ajoutée au jeu.");
    } else {
      System.out.println("Le jeu est plein.");
    }
  }

  // Play the next card in order
  public void jouer() {
    for (int i = 0; i < cartes.length; i++) {
      if (cartes[i] != null) {
        System.out.print("Joue la carte : ");
        cartes[i].afficher();
        cartes[i] = null;
        return;
      }
    }
    System.out.println("Aucune carte à jouer.");
  }
}

public class job02 {
  public static void main(String[] args) {
    // 1. Create a new game
    Jeu jeu = new Jeu();

    // 2. Create various cards
    Terrain terrain = new Terrain('B'); // White terrain
    Creature creature = new Creature("Dragon", 5, 8, 4);
    Sortilege sortilege = new Sortilege("Boule de feu", "Inflige 3 dégâts à une cible.", 2);

    // 3. Add cards to the game
    jeu.piocher(terrain);
    jeu.piocher(creature);
    jeu.piocher(sortilege);

    // 4. Play cards in order
    jeu.jouer(); // Should play Terrain
    jeu.jouer(); // Should play Creature
    jeu.jouer(); // Should play Sortilege
    jeu.jouer(); // No more cards to play
  }
}
