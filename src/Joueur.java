
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
}
