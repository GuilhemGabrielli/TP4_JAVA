package Benchmark;

public class Joueur {

    private String a_nom;
    private String a_pseudo;

    public Joueur(String nom, String pseudo) {
        this.a_nom = nom;
        this.a_pseudo = pseudo;
    }

    public String getNom() {
        return a_nom;
    }

    public String getPseudo() {
        return a_pseudo;
    }

    public boolean comparer(Joueur other, String critere) {
        /**
         * Renvoie true si l'objet principal est
         */
        if (critere == "Nom") {
            return this.a_nom.compareTo(other.a_nom)>0;
        } else {
            return this.a_pseudo.compareTo(other.a_pseudo)>0;
        }
    }
}
