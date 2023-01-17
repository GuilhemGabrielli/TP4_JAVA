import java.util.List;

public class MethodesDeTrie {
    static List<Joueur> listJoueur;

    MethodesDeTrie(List<Joueur> joueurs) {
        this.listJoueur = joueurs;
    }

    public void afficherList() {
        for (int i = 0; i < listJoueur.size()-1; i++) {
            System.out.print(listJoueur.get(i).getPseudo()+" -> ");
        }
        System.out.print(listJoueur.get(listJoueur.size()-1).getPseudo()+"\n");
    }

    private static void echanger(Integer index1, Integer index2) {
        Joueur joueur = listJoueur.get(index1);
        listJoueur.set(index1, listJoueur.get(index2));
        listJoueur.set(index2, joueur);
    }

    public static void TriPartSelection_Nom() {
        Integer tailleListe = listJoueur.size();
        for (int i = 0; i < tailleListe-1; i++) {
            Integer min = i;
            for (int j = i+1; j < tailleListe; j++) {
                if (listJoueur.get(min).getNom().compareTo(listJoueur.get(j).getNom())>0) {
                    min = j;
                }
            }
            if (min != i) {
                echanger(min, i);
            }
        }
    }

    public static void TriPartSelection_Pseudo() {
        Integer tailleListe = listJoueur.size();
        for (int i = 0; i < tailleListe - 1; i++) {
            Integer min = i;
            for (int j = i + 1; j < tailleListe; j++) {
                if (listJoueur.get(min).getPseudo().compareTo(listJoueur.get(j).getPseudo()) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                echanger(min, i);
            }
        }
    }

    public static void TriPartInsertion_Nom() {
        for (int i = 1; i < listJoueur.size(); i++) {
            Joueur joueurADecaler = listJoueur.get(i);
            Integer j = i;
            while (j>0 && listJoueur.get(j-1).getNom().compareTo(joueurADecaler.getNom())>0) {
                listJoueur.set(j, listJoueur.get(j-1));
                j = j-1;
            }
            listJoueur.set(j, joueurADecaler);
        }
    }

    public static void TriABulles_Nom() {
        boolean tableauTrie;
        for (int i = listJoueur.size(); i > 0 ; i--) {
            tableauTrie = true;
            for (int j = 0; j < i-1; j++) {
                if (listJoueur.get(j+1).getNom().compareTo(listJoueur.get(j).getNom())<0) {
                    echanger(j+1, j);
                    tableauTrie = false;
                }
            }
            if (tableauTrie) {
                break;
            }
        }
    }

    public void TriARapide_Nom() {
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
            if (listJoueur.get(i).getNom().compareTo(pivot.getNom())<0) {
                compteur += 1;
                echanger(compteur, i);
            }
        }
        echanger(first, compteur);
        return compteur;
    }


    private void fusion(Integer first, Integer middle, Integer last) {

    }
}
