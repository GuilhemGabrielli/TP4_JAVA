import java.util.List;

public class MethodesDeTrie {

    private static List<Joueur> echanger(List<Joueur> listeAEchanger, Integer index1, Integer index2) {
        Joueur joueur = listeAEchanger.get(index1);
        listeAEchanger.set(index1, listeAEchanger.get(index2));
        listeAEchanger.set(index2, joueur);
        return listeAEchanger;
    }

    public static List<Joueur> TriPartSelection_Nom(List<Joueur> listeAtrier) {
        Integer tailleListe = listeAtrier.size();
        for (int i = 0; i < tailleListe-2; i++) {
            String nomJoueurMin1 = listeAtrier.get(i).getNom();
            Integer min = i;
            for (int j = 0; j < tailleListe-1; j++) {
                String nomJoueurMin2 = listeAtrier.get(j).getNom();
                System.out.println(nomJoueurMin1 + ", "+nomJoueurMin2+", "+nomJoueurMin1.compareTo(nomJoueurMin2));
                if (nomJoueurMin1.compareTo(nomJoueurMin2)>0) {
                    min = j;
                }
            }
            if (min != i) {
                listeAtrier = echanger(listeAtrier, min, i);
            }
        }
        return listeAtrier;
    }

    public static void TriPartSelection_Pseudonyme(List<Joueur> listeATrier) {

    }
}
