package bench;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new  Scanner(System.in);

    public Menu() {
        while (true) {
            System.out.print("Que voulez-faire ? \n1 - Utiliser une méthode de trie \n2 - Voir les Benchmark \n0 - Quitter \nVotre choix : ");
            String choix = sc.next();
            if (choix.equals("1")) {
                List<Joueur> listeJoueur = creerListJoueur();
                Collections.shuffle(listeJoueur);

                MethodesDeTrie methodesDeTrie = new MethodesDeTrie(listeJoueur);
                while (true) {
                    System.out.print("Quel tri voulez-vous utiliser ? \n1 - Sélection \n2 - Insertion \n3 - A bulles \n4 - Rapide \nVotre choix : ");
                    String choixTri = sc.next();
                    if (choixTri.equals("1")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriParSelection_Nom();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("2")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriParInsertion_Nom();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("3")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriABulles_Nom();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("4")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriARapide_Nom();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else {
                        System.out.println("Erreur, veuillez recommencer");
                    }
                }
            } else if (choix.equals("2")) {
                this.afficherBenchmark();
            } else if (choix.equals("0")) {
                break;
            } else {
                System.out.println("Erreur, veuillez recommencer");
            }
        }

    }


    private void afficherBenchmark() {
        System.out.println("Benchmark                       Mode  Cnt          Score           Error  Units");
        System.out.println("TriARapide_Nom                 thrpt   25  674692454,646 ± 257412701,868  ops/s");
        System.out.println("TriPartSelection_Nom           thrpt   25  969966845,270  ±  4940166,727  ops/s");
    }

    private List<Joueur> creerListJoueur() {
        List<Joueur> liste = new ArrayList<>();
        Integer numberOfJoueur = null;
        while (numberOfJoueur==null) {
            numberOfJoueur = myInputInt("Combien de joueur souhaitez-vous ?\nVotre choix : ");
        }
        for (int i = 0; i < numberOfJoueur; i++) {
            int centaine = i/100;
            int dizaine = i%100/10;
            int unite = i%10;
            Joueur joueur = new Joueur("nom"+centaine+dizaine+unite, "pseudo"+centaine+dizaine+unite);
            liste.add(joueur);
        }
        return liste;
    }

    public Integer myInputInt(String message) {
        /**
         * Retourne un entier
         */
        System.out.print(message);
        try {
            String str = sc.next();
            int result = Integer.parseInt(str);
            if (result < 0) {
                result *= -1;
            }
            return result;
        } catch (Exception e) {
            System.out.println("Erreur, veuillez rentrer un entier. ");
            return null;
        }
    }
}
