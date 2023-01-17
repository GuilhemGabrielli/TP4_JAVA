import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("anom1", "pseudo1");
        Joueur joueur2 = new Joueur("bnom2", "pseudo2");
        Joueur joueur3 = new Joueur("cnom3", "pseudo3");
        Joueur joueur4 = new Joueur("dnom4", "pseudo4");
        Joueur joueur5 = new Joueur("enom5", "pseudo5");
        Joueur joueur6 = new Joueur("fnom6", "pseudo6");
        Joueur joueur7 = new Joueur("gnom7", "pseudo7");
        Joueur joueur8 = new Joueur("hnom8", "pseudo8");

        List<Joueur> listeJoueur = new ArrayList<>();

        //listeJoueur.add(joueur3);
        //listeJoueur.add(joueur6);
        //listeJoueur.add(joueur1);
        //listeJoueur.add(joueur4);
        //listeJoueur.add(joueur5);
        //listeJoueur.add(joueur2);
        //listeJoueur.add(joueur8);
        //listeJoueur.add(joueur7);

        listeJoueur.add(joueur1);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur3);
        listeJoueur.add(joueur4);
        listeJoueur.add(joueur5);
        listeJoueur.add(joueur6);
        listeJoueur.add(joueur7);
        listeJoueur.add(joueur8);
        Collections.shuffle(listeJoueur);

        MethodesDeTrie methodesDeTrie = new MethodesDeTrie(listeJoueur);

        methodesDeTrie.afficherList();
        methodesDeTrie.TriARapide_Nom();
        methodesDeTrie.afficherList();
    }
}