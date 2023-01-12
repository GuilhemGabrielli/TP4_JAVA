import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("nom1", "pseudo1");
        Joueur joueur2 = new Joueur("nom2", "pseudo2");
        Joueur joueur3 = new Joueur("nom3", "pseudo3");
        Joueur joueur4 = new Joueur("nom4", "pseudo4");
        Joueur joueur5 = new Joueur("nom5", "pseudo5");
        Joueur joueur6 = new Joueur("nom6", "pseudo6");
        Joueur joueur7 = new Joueur("nom7", "pseudo7");
        Joueur joueur8 = new Joueur("nom8", "pseudo8");

        List<Joueur> listeJoueur = new ArrayList<>();

        listeJoueur.add(joueur3);
        listeJoueur.add(joueur6);
        listeJoueur.add(joueur1);
        listeJoueur.add(joueur4);
        listeJoueur.add(joueur5);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur8);
        listeJoueur.add(joueur7);

        MethodesDeTrie methodesDeTrie = new MethodesDeTrie();

        listeJoueur = methodesDeTrie.TriPartSelection_Nom(listeJoueur);
        System.out.println(listeJoueur);
    }
}