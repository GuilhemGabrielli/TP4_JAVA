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
            Joueur joueurMin1 = listeAtrier.get(i);
            Integer min = i;
            for (int j = i; i+1 < tailleListe-1; j++) {
                Joueur joueurMin2 = listeAtrier.get(j);
                if (joueurMin2.getNom().compareTo(joueurMin1.getNom())<0) {
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
