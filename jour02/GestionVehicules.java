package jour02;

public class GestionVehicules {

  class Vehicule {
    protected String marque;
    protected String dateAchat;
    protected String prixAchat;
    protected String prixCourant;

    Vehicule(String marque, String dateAchat, String prixAchat) {
      this.marque = marque;
      this.dateAchat = dateAchat;
      this.prixAchat = prixAchat;
    }

    public void afficher() {
      System.out.println("Marque: " + marque);
      System.out.println("Date d'achat: " + dateAchat);
      System.out.println("Prix d'achat: " + prixAchat);
    }

    public void calculePrix(int anneeActuelle) {
      int anneeAchat = Integer.parseInt(dateAchat);
      double prixAchatDouble = Double.parseDouble(prixAchat);
      int annees = anneeActuelle - anneeAchat;
      double prixCourantDouble = prixAchatDouble * Math.pow(0.99, annees);
      if (prixCourantDouble < 0)
        prixCourantDouble = 0;
      prixCourant = String.valueOf(prixCourantDouble);
    }

    class Voiture extends Vehicule {
      protected int cylindre;
      protected int nombreDePortes;
      protected int puissance;
      protected int kilometrage;

      Voiture(String marque, String dateAchat, String prixAchat, int cylindre, int nombreDePortes, int puissance,
          int kilometrage) {
        super(marque, dateAchat, prixAchat);
        this.cylindre = cylindre;
        this.nombreDePortes = nombreDePortes;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
      }

      public void afficher() {
        super.afficher();
        System.out.println("Cylindre: " + cylindre);
        System.out.println("Nombre de portes: " + nombreDePortes);
        System.out.println("Puissance: " + puissance);
        System.out.println("Kilometrage: " + kilometrage);
      }

      @Override
      public void calculePrix(int anneeActuelle) {
        int anneeAchat = Integer.parseInt(dateAchat);
        double prixAchatDouble = Double.parseDouble(prixAchat);
        int annees = anneeActuelle - anneeAchat;
        double prixCourantDouble = prixAchatDouble;
        // 2% per year
        prixCourantDouble *= Math.pow(0.98, annees);
        // 5% per 10,000 km (rounded to nearest)
        int tranchesKm = (int) Math.round(kilometrage / 10000.0);
        prixCourantDouble *= Math.pow(0.95, tranchesKm);
        // -10% for Renault or Fiat (or others)
        if (marque.equalsIgnoreCase("Renault") || marque.equalsIgnoreCase("Fiat") || marque.equalsIgnoreCase("Peugeot")
            || marque.equalsIgnoreCase("Citroen")) {
          prixCourantDouble *= 0.9;
        }
        // +20% for Ferrari or Porsche (or others)
        if (marque.equalsIgnoreCase("Ferrari") || marque.equalsIgnoreCase("Porsche")
            || marque.equalsIgnoreCase("Lamborghini") || marque.equalsIgnoreCase("Bugatti")) {
          prixCourantDouble *= 1.2;
        }
        if (prixCourantDouble < 0)
          prixCourantDouble = 0;
        prixCourant = String.valueOf(prixCourantDouble);
      }
    }

    class Avion extends Vehicule {
      protected String typeMoteur;
      protected int nombreDheuresDeVol;

      Avion(String marque, String dateAchat, String prixAchat, String typeMoteur, int nombreDheuresDeVol) {
        super(marque, dateAchat, prixAchat);
        this.typeMoteur = typeMoteur;
        this.nombreDheuresDeVol = nombreDheuresDeVol;
      }

      public void afficher() {
        super.afficher();
        System.out.println("Type de moteur: " + typeMoteur);
        System.out.println("Nombre d'heures de vol: " + nombreDheuresDeVol);
      }

      @Override
      public void calculePrix(int anneeActuelle) {
        double prixAchatDouble = Double.parseDouble(prixAchat);
        double prixCourantDouble = prixAchatDouble;
        if (typeMoteur.equalsIgnoreCase("hélices") || typeMoteur.equalsIgnoreCase("helices")) {
          int tranches = (int) Math.round(nombreDheuresDeVol / 100.0);
          prixCourantDouble *= Math.pow(0.9, tranches);
        } else {
          int tranches = (int) Math.round(nombreDheuresDeVol / 1000.0);
          prixCourantDouble *= Math.pow(0.9, tranches);
        }
        if (prixCourantDouble < 0)
          prixCourantDouble = 0;
        prixCourant = String.valueOf(prixCourantDouble);
      }
    }
  }
}
