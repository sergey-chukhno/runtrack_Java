package jour03;

import java.util.Vector;
import java.util.Scanner;

abstract class Personne {
  protected int identite;
  protected String nomSocial;
  protected String adresse;

  // Protected constructor
  protected Personne(int identite, String nomSocial, String adresse) {
    this.identite = identite;
    this.nomSocial = nomSocial;
    this.adresse = adresse;
  }

  // Protected getters and setters
  protected int getIdentite() {
    return identite;
  }

  protected void setIdentite(int identite) {
    this.identite = identite;
  }

  protected String getNomSocial() {
    return nomSocial;
  }

  protected void setNomSocial(String nomSocial) {
    this.nomSocial = nomSocial;
  }

  protected String getAdresse() {
    return adresse;
  }

  protected void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  // Protected affiche method
  protected void affiche() {
    System.out.println("Identité: " + identite);
    System.out.println("Nom Social: " + nomSocial);
    System.out.println("Adresse: " + adresse);
  }
}

class Client extends Personne {
  private double chiffreAffaire;

  // Public constructor
  public Client(int identite, String nomSocial, String adresse, double chiffreAffaire) {
    super(identite, nomSocial, adresse);
    this.chiffreAffaire = chiffreAffaire;
  }

  // Public getter and setter for chiffreAffaire
  public double getChiffreAffaire() {
    return chiffreAffaire;
  }

  public void setChiffreAffaire(double chiffreAffaire) {
    this.chiffreAffaire = chiffreAffaire;
  }

  // Public affiche method
  public void affiche() {
    super.affiche();
    System.out.println("Chiffre d'Affaire: " + chiffreAffaire);
  }
}

class Article {
  private String reference;
  private String designation;
  private double prixUnitaire;
  private int quantiteStock;

  // Parameterized constructor
  public Article(String reference, String designation, double prixUnitaire, int quantiteStock) {
    this.reference = reference;
    this.designation = designation;
    this.prixUnitaire = prixUnitaire;
    this.quantiteStock = quantiteStock;
  }

  // Copy constructor
  public Article(Article a) {
    this.reference = a.reference;
    this.designation = a.designation;
    this.prixUnitaire = a.prixUnitaire;
    this.quantiteStock = a.quantiteStock;
  }

  // Getters and setters
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public double getPrixUnitaire() {
    return prixUnitaire;
  }

  public void setPrixUnitaire(double prixUnitaire) {
    this.prixUnitaire = prixUnitaire;
  }

  public int getQuantiteStock() {
    return quantiteStock;
  }

  public void setQuantiteStock(int quantiteStock) {
    this.quantiteStock = quantiteStock;
  }

  // affiche method
  public void affiche() {
    System.out.println("Référence: " + reference);
    System.out.println("Désignation: " + designation);
    System.out.println("Prix Unitaire: " + prixUnitaire);
    System.out.println("Quantité en Stock: " + quantiteStock);
  }
}

class Commande {
  private int numeroCommande;
  private String dateCommande;
  private Client client;

  // Public constructor
  public Commande(int numeroCommande, String dateCommande, Client client) {
    this.numeroCommande = numeroCommande;
    this.dateCommande = dateCommande;
    this.client = client;
  }

  // Getters and setters
  public int getNumeroCommande() {
    return numeroCommande;
  }

  public void setNumeroCommande(int numeroCommande) {
    this.numeroCommande = numeroCommande;
  }

  public String getDateCommande() {
    return dateCommande;
  }

  public void setDateCommande(String dateCommande) {
    this.dateCommande = dateCommande;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

class Ligne {
  private Commande commande;
  private Article article;
  private int quantiteCommande;

  // Public constructor
  public Ligne(Commande commande, Article article, int quantiteCommande) {
    this.commande = commande;
    this.article = article;
    this.quantiteCommande = quantiteCommande;
  }

  // Getters and setters
  public Commande getCommande() {
    return commande;
  }

  public void setCommande(Commande commande) {
    this.commande = commande;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public int getQuantiteCommande() {
    return quantiteCommande;
  }

  public void setQuantiteCommande(int quantiteCommande) {
    this.quantiteCommande = quantiteCommande;
  }
}

class Commerciale {
  private Vector<Article> articles;
  private Vector<Client> clients;
  private Vector<Commande> commandes;
  private Vector<Ligne> lignes;

  public Commerciale() {
    articles = new Vector<>();
    clients = new Vector<>();
    commandes = new Vector<>();
    lignes = new Vector<>();
  }

  // Methods to add/remove articles
  public void ajouterArticle(Article a) {
    articles.add(a);
  }

  public void supprimerArticle(Article a) {
    articles.remove(a);
  }

  // Methods to add/remove clients
  public void ajouterClient(Client c) {
    clients.add(c);
  }

  public void supprimerClient(Client c) {
    clients.remove(c);
  }

  // Methods to add/remove commandes
  public void passerCommande(Commande c) {
    commandes.add(c);
  }

  public void annulerCommande(Commande c) {
    commandes.remove(c);
  }

  // Methods to add/remove lignes
  public void ajouterLigne(Ligne l) {
    lignes.add(l);
  }

  public void supprimerLigne(Ligne l) {
    lignes.remove(l);
  }

  public static void main(String[] args) {
    Commerciale commerciale = new Commerciale();
    Scanner scanner = new Scanner(System.in);
    int choix = 0;
    do {
      System.out.println("--- Menu de Gestion Commerciale ---");
      System.out.println("1) Ajouter un article");
      System.out.println("2) Supprimer un article");
      System.out.println("3) Ajouter un client");
      System.out.println("4) Supprimer un client");
      System.out.println("5) Passer une commande");
      System.out.println("6) Annuler une commande");
      System.out.println("7) Quitter");
      System.out.print("\nEntrer un choix: ");
      while (true) {
        String input = scanner.nextLine();
        try {
          choix = Integer.parseInt(input);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Entrée invalide. Veuillez entrer un nombre.");
          System.out.print("Entrer un choix: ");
        }
      }
      switch (choix) {
        case 1:
          // Ajouter un article
          System.out.print("Référence: ");
          String reference = scanner.nextLine();
          System.out.print("Désignation: ");
          String designation = scanner.nextLine();
          double prixUnitaire;
          while (true) {
            System.out.print("Prix unitaire: ");
            String input = scanner.nextLine();
            try {
              prixUnitaire = Double.parseDouble(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre décimal.");
            }
          }
          int quantiteStock;
          while (true) {
            System.out.print("Quantité en stock: ");
            String input = scanner.nextLine();
            try {
              quantiteStock = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          Article nouvelArticle = new Article(reference, designation, prixUnitaire, quantiteStock);
          commerciale.ajouterArticle(nouvelArticle);
          System.out.println("Article ajouté avec succès !\n");
          break;
        case 2:
          // Supprimer un article
          if (commerciale.articles.isEmpty()) {
            System.out.println("Aucun article à supprimer.\n");
            break;
          }
          System.out.println("Liste des articles :");
          for (int i = 0; i < commerciale.articles.size(); i++) {
            Article a = commerciale.articles.get(i);
            System.out.println(i + ": " + a.getReference() + " - " + a.getDesignation());
          }
          int idxToRemove;
          while (true) {
            System.out.print("Entrez l'index de l'article à supprimer : ");
            String input = scanner.nextLine();
            try {
              idxToRemove = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          if (idxToRemove >= 0 && idxToRemove < commerciale.articles.size()) {
            Article removed = commerciale.articles.get(idxToRemove);
            commerciale.supprimerArticle(removed);
            System.out.println("Article supprimé avec succès !\n");
          } else {
            System.out.println("Index invalide.\n");
          }
          break;
        case 3:
          // Ajouter un client
          int identite;
          while (true) {
            System.out.print("Identité: ");
            String input = scanner.nextLine();
            try {
              identite = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          System.out.print("Nom Social: ");
          String nomSocial = scanner.nextLine();
          System.out.print("Adresse: ");
          String adresse = scanner.nextLine();
          double chiffreAffaire;
          while (true) {
            System.out.print("Chiffre d'Affaire: ");
            String input = scanner.nextLine();
            try {
              chiffreAffaire = Double.parseDouble(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre décimal.");
            }
          }
          Client nouveauClient = new Client(identite, nomSocial, adresse, chiffreAffaire);
          commerciale.ajouterClient(nouveauClient);
          System.out.println("Client ajouté avec succès !\n");
          break;
        case 4:
          // Supprimer un client
          if (commerciale.clients.isEmpty()) {
            System.out.println("Aucun client à supprimer.\n");
            break;
          }
          System.out.println("Liste des clients :");
          for (int i = 0; i < commerciale.clients.size(); i++) {
            Client c = commerciale.clients.get(i);
            System.out.println(i + ": " + c.getIdentite() + " - " + c.getNomSocial());
          }
          int idxToRemoveClient;
          while (true) {
            System.out.print("Entrez l'index du client à supprimer : ");
            String input = scanner.nextLine();
            try {
              idxToRemoveClient = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          if (idxToRemoveClient >= 0 && idxToRemoveClient < commerciale.clients.size()) {
            Client removedClient = commerciale.clients.get(idxToRemoveClient);
            commerciale.supprimerClient(removedClient);
            System.out.println("Client supprimé avec succès !\n");
          } else {
            System.out.println("Index invalide.\n");
          }
          break;
        case 5:
          // Passer une commande
          int numeroCommande;
          while (true) {
            System.out.print("Numéro de commande: ");
            String input = scanner.nextLine();
            try {
              numeroCommande = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          System.out.print("Date de commande: ");
          String dateCommande = scanner.nextLine();
          int clientIdentite;
          while (true) {
            System.out.print("Identité du client: ");
            String input = scanner.nextLine();
            try {
              clientIdentite = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          Client client = null;
          for (Client c : commerciale.clients) {
            if (c.getIdentite() == clientIdentite) {
              client = c;
              break;
            }
          }
          if (client == null) {
            System.out.println("Client non trouvé.\n");
            break;
          }
          Commande nouvelleCommande = new Commande(numeroCommande, dateCommande, client);
          commerciale.passerCommande(nouvelleCommande);
          System.out.println("Commande créée. Ajoutez des articles à la commande :");
          while (true) {
            if (commerciale.articles.isEmpty()) {
              System.out.println("Aucun article disponible pour ajouter à la commande.\n");
              break;
            }
            System.out.println("Liste des articles :");
            for (int i = 0; i < commerciale.articles.size(); i++) {
              Article a = commerciale.articles.get(i);
              System.out.println(i + ": " + a.getReference() + " - " + a.getDesignation());
            }
            int idxArticle;
            while (true) {
              System.out.print("Entrez l'index de l'article à ajouter (ou -1 pour terminer) : ");
              String input = scanner.nextLine();
              try {
                idxArticle = Integer.parseInt(input);
                break;
              } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
              }
            }
            if (idxArticle == -1) {
              break;
            }
            if (idxArticle < 0 || idxArticle >= commerciale.articles.size()) {
              System.out.println("Index invalide.\n");
              continue;
            }
            Article articleCommande = commerciale.articles.get(idxArticle);
            int quantiteCommande;
            while (true) {
              System.out.print("Quantité à commander : ");
              String input = scanner.nextLine();
              try {
                quantiteCommande = Integer.parseInt(input);
                break;
              } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
              }
            }
            if (quantiteCommande <= 0) {
              System.out.println("Quantité invalide.\n");
              continue;
            }
            Ligne nouvelleLigne = new Ligne(nouvelleCommande, articleCommande, quantiteCommande);
            commerciale.ajouterLigne(nouvelleLigne);
            System.out.println("Ligne ajoutée à la commande.\n");
          }
          System.out.println("Commande passée avec succès !\n");
          break;
        case 6:
          // Annuler une commande
          int commandeNumero;
          while (true) {
            System.out.print("Numéro de commande à annuler: ");
            String input = scanner.nextLine();
            try {
              commandeNumero = Integer.parseInt(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
          }
          Commande commandeToCancel = null;
          for (Commande c : commerciale.commandes) {
            if (c.getNumeroCommande() == commandeNumero) {
              commandeToCancel = c;
              break;
            }
          }
          if (commandeToCancel == null) {
            System.out.println("Commande non trouvée.\n");
            break;
          }
          commerciale.annulerCommande(commandeToCancel);
          System.out.println("Commande annulée avec succès !\n");
          break;
        case 7:
          System.out.println("Au revoir!");
          break;
        default:
          System.out.println("(Option non implémentée pour l'instant.)\n");
      }
    } while (choix != 7);
    scanner.close();
  }
}