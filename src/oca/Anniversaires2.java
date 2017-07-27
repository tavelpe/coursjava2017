package oca;

import java.time.*;
import java.time.format.*;
import java.util.Arrays;
import java.util.Locale;

//class JourAnniversaire2 {
//    static final JourAnniversaire[] DATES;
//    private final int jour;
//    private int nombre;
//    private final StringBuilder annees = new StringBuilder(100);
//
//    static void IncrementeDates(final LocalDate date) {
//        int i = date.getDayOfWeek().getValue() - 1;
//        DATES[i].nombre++;
//        DATES[i].annees.append(date.getYear()).append(";");
//    }
//
//    public int getNombre() {
//        return nombre;
//    }
//
//    public int getJour() {
//        return jour;
//    }
//
//    static {
//        DATES = new JourAnniversaire[7];
//        for (int i = 0; i < 7; i++) {
//            JourAnniversaire.DATES[i] = new JourAnniversaire(i + 1);
//        }
//    }
//
//    public String[] getAnnees() {
//        return annees.toString().split(";");
//    }
//
//    public JourAnniversaire(int jour) {
//        this.jour = jour;
//    }
//}
public class Anniversaires2 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String d = "25/12/0001";
        String modele = "dd/MM/yyyy";
        LocalDate anniv = LocalDate.parse(d, DateTimeFormatter.ofPattern(modele));
        LocalDate now = LocalDate.now();
        int annees = now.getYear()-anniv.getYear()- now.compareTo(anniv.withYear(now.getYear())) ;

        int[] jours = new int[annees];
        int[][] AnneesJours = new int[7][1];

        for (int annee = 0; annee < annees; annee++) {
            int dow = anniv.withYear(annee).getDayOfWeek().getValue();
            jours[annee] = dow;
            AnneesJours[dow - 1][0]++;
        }
        for (int numjour = 0; numjour < 7; numjour++) {
            int num = AnneesJours[numjour][0];
            AnneesJours[numjour] = Arrays.copyOf(AnneesJours[numjour], num+1);
        }
        int[] compteurs = new int[7];
        for (int compteur = 0, annee = anniv.getYear(); compteur < annees; compteur++, annee++) {
            int numjour = jours[compteur] - 1;
            int c = ++compteurs[numjour];
            AnneesJours[numjour][c] = annee;
        }

        System.out.println((System.nanoTime() - start) / 1000000);
        for (int i = 0; i < 7; i++) {
            DayOfWeek dow = DayOfWeek.values()[i];
            final int n = AnneesJours[i][0];
            System.out.print(dow.getDisplayName(TextStyle.FULL, Locale.FRENCH) + " - " + n + " fois - ");
            System.out.println(Arrays.toString(Arrays.copyOfRange(AnneesJours[i], 1, n+1)));
        }

        System.out.println((System.nanoTime() - start) / 1000000);
    }

}
