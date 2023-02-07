package Benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class MethodesDeTrie {

    static List<Joueur> listJoueur;
    static String critere;

    MethodesDeTrie(List<Joueur> joueurs, String critere) {
        this.listJoueur = joueurs;
        this.critere = critere;
    }

    public MethodesDeTrie() {
        this.listJoueur = new ArrayList<>();
    }


    public String getAffichage() {
        /**
         * Fonction renvoyant l'affichage de la liste selon le critère de recherche
         */
        String result = "";
        for (int i = 0; i < listJoueur.size()-1; i++) {
            if (critere=="Nom") {
                result += listJoueur.get(i).getNom()+" -> ";
            } else {
                result += listJoueur.get(i).getPseudo()+" -> ";
            }
        }
        if (critere=="Nom") {
            result += listJoueur.get(listJoueur.size()-1).getNom()+"\n";
        } else {
            result += listJoueur.get(listJoueur.size()-1).getPseudo()+"\n";
        }
        return result;
    }


    private static void echanger(Integer index1, Integer index2) {
        /**
         * Fonction echangeant 2 cartes selon leurs index
         */
        Joueur joueur = listJoueur.get(index1);
        listJoueur.set(index1, listJoueur.get(index2));
        listJoueur.set(index2, joueur);
    }


    @Benchmark
    public static void TriParSelection() {
        /**
         * Fonction triant la liste selon la méthode de sélection
         */
        Integer tailleListe = listJoueur.size();
        for (int i = 0; i < tailleListe-1; i++) {
            Integer min = i;
            for (int j = i+1; j < tailleListe; j++) {
                if (listJoueur.get(min).comparer(listJoueur.get(j), critere)) {
                    min = j;
                }
            }
            if (min != i) {
                echanger(min, i);
            }
        }
    }


    @Benchmark
    public static void TriParInsertion() {
        /**
         * Fonction triant la liste selon la méthode d'insertion
         */
        for (int i = 1; i < listJoueur.size(); i++) {
            Joueur joueurADecaler = listJoueur.get(i);
            Integer j = i;
            while (j>0 && listJoueur.get(j-1).comparer(joueurADecaler, critere)) {
                listJoueur.set(j, listJoueur.get(j-1));
                j = j-1;
            }
            listJoueur.set(j, joueurADecaler);
        }
    }


    @Benchmark
    public static void TriABulles() {
        /**
         * Fonction triant la liste selon la méthode a bulles
         */
        boolean tableauTrie;
        for (int i = listJoueur.size(); i > 0 ; i--) {
            tableauTrie = true;
            for (int j = 0; j < i-1; j++) {
                if (!listJoueur.get(j+1).comparer(listJoueur.get(j), critere)) {
                    echanger(j+1, j);
                    tableauTrie = false;
                }
            }
            if (tableauTrie) {
                break;
            }
        }
    }


    @Benchmark
    public void TriARapide() {
        /**
         * Fonction triant la liste selon la méthode rapide
         */
        this.TriRapideBis(0, listJoueur.size());
    }

    private void TriRapideBis(Integer first, Integer last) {
        if (first<last) {
            Integer pivot = Partition(first, last);
            TriRapideBis(first, pivot);
            TriRapideBis(pivot+1, last);
        }
    }

    private Integer Partition(Integer first, Integer last) {
        Integer compteur = first;
        Joueur pivot = listJoueur.get(first);
        for (int i = first+1; i < last; i++) {
            if (!listJoueur.get(i).comparer(pivot, critere)) {
                compteur += 1;
                echanger(compteur, i);
            }
        }
        echanger(first, compteur);
        return compteur;
    }
}
