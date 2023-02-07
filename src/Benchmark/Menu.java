package Benchmark;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.io.FileWriter;

public class Menu {

    private Scanner sc = new  Scanner(System.in);

    public Menu() {
        CSV();
        while (true) {
            System.out.print("Que voulez-faire ? \n1 - Utiliser une méthode de trie \n2 - Voir les Benchmark \n0 - Quitter \nVotre choix : ");
            String choix = sc.next();
            if (choix.equals("1")) {
                Integer numberOfJoueur = 0;
                while (numberOfJoueur==0) {
                    numberOfJoueur = myInputInt("\nCombien de joueur souhaitez-vous ?\nVotre choix : ");
                }
                List<Joueur> listeJoueur = creerListJoueur(numberOfJoueur);
                Collections.shuffle(listeJoueur);
                String critere = choisirCritere();
                MethodesDeTrie methodesDeTrie = new MethodesDeTrie(listeJoueur, critere);
                while (true) {
                    System.out.print("\nQuel tri voulez-vous utiliser ? \n1 - Sélection \n2 - Insertion \n3 - A bulles \n4 - Rapide \nVotre choix : ");
                    String choixTri = sc.next();
                    if (choixTri.equals("1")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriParSelection();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("2")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriParInsertion();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("3")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriABulles();
                        System.out.println("Après : "+methodesDeTrie.getAffichage());
                        break;
                    } else if (choixTri.equals("4")) {
                        System.out.print("Avant : "+methodesDeTrie.getAffichage());
                        methodesDeTrie.TriARapide();
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
                System.out.println("Erreur, veuillez recommencer\n");
            }
        }

    }


    private void afficherBenchmark() {
        System.out.println("\nBenchmark         Mode  Cnt           Score         Error  Units");
        System.out.println("TriParSelection  thrpt   25   974615727,439 ± 4709868,220  ops/s");
        System.out.println("TriParInsertion  thrpt   25  1137367285,441 ± 6403160,929  ops/s");
        System.out.println("TriABulles       thrpt   25  1137780447,055 ± 6426613,012  ops/s");
        System.out.println("TriARapide       thrpt   25   972254852,870 ± 7138395,390  ops/s\n");
    }

    private List<Joueur> creerListJoueur(Integer numberOfJoueur) {
        List<Joueur> liste = new ArrayList<>();
        for (int i = 0; i < numberOfJoueur; i++) {
            int centaine = i/100;
            int dizaine = i%100/10;
            int unite = i%10;
            Joueur joueur = new Joueur("nom"+centaine+dizaine+unite, "pseudo"+centaine+dizaine+unite);
            liste.add(joueur);
        }
        return liste;
    }

    private String choisirCritere() {
        String result = null;
        while (true) {
            System.out.print("\nQuel sera le critère de tri ? \n1 - Par le nom \n2 - Par le pseudo \nVotre choix : ");
            String idCritere = sc.next();
            if (idCritere.equals("1")) {
                result = "Nom";
                break;
            } else if (idCritere.equals("2")) {
                result = "Pseudo";
                break;
            } else {
                System.out.println("Erreur, veuillez recommencer");
            }
        }
        return result;
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

    public void CSV() {
        try {
            FileWriter csvWriter = new FileWriter("Benchmark.csv");
            csvWriter.append("n");
            csvWriter.append(",");
            csvWriter.append("Time");
            csvWriter.append(",");
            csvWriter.append("Algo");
            csvWriter.append("\n");

            String[] algo = new String[4];
            algo[0] = "Sélection";
            algo[1] = "Insertion";
            algo[2] = "Bulles";
            algo[3] = "Rapide";

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    long timeCumul = 0;
                    for (int k = 0; k < 4; k++) {
                        Integer numberOfPlayer = (int) Math.pow(10, 2*k);
                        List<Joueur> listeJoueur = creerListJoueur(numberOfPlayer);
                        Collections.shuffle(listeJoueur);

                        MethodesDeTrie methodesDeTrie = new MethodesDeTrie(listeJoueur, "Nom");
                        if (i==0) {
                            Long start = System.nanoTime();
                            methodesDeTrie.TriParSelection();
                            Long stop = System.nanoTime();
                            timeCumul += stop-start;
                        } else if (i==1) {
                            Long start = System.nanoTime();
                            methodesDeTrie.TriParInsertion();
                            Long stop = System.nanoTime();
                            timeCumul += stop-start;
                        }  else if (i==2) {
                            Long start = System.nanoTime();
                            methodesDeTrie.TriABulles();
                            Long stop = System.nanoTime();
                            timeCumul += stop-start;
                        } else {
                            Long start = System.nanoTime();
                            methodesDeTrie.TriARapide();
                            Long stop = System.nanoTime();
                            timeCumul += stop-start;
                        }
                    }
                    csvWriter.append(numberOfPlayer+","+timeCumul/4+","+algo[i]+"\n");
                    }



            }
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException err) {

        }
    }
}
