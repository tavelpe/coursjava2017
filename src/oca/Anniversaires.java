package oca;

import java.time.*;
import java.time.format.*;
import java.util.Arrays;
import java.util.Locale;

class JourAnniversaire {
    static final JourAnniversaire[] DATES;
    private final int jour;
    private int nombre;
    private final StringBuilder annees = new StringBuilder(100);

    static void IncrementeDates(final LocalDate date) {
        int i = date.getDayOfWeek().getValue() - 1;
        DATES[i].nombre++;
        DATES[i].annees.append(date.getYear()).append(";");
    }

    public int getNombre() {
        return nombre;
    }

    public int getJour() {
        return jour;
    }

    static {
        DATES = new JourAnniversaire[7];
        for (int i = 0; i < 7; i++) {
            JourAnniversaire.DATES[i] = new JourAnniversaire(i + 1);
        }
    }

    public String[] getAnnees() {
        return annees.toString().split(";");
    }

    public JourAnniversaire(int jour) {
        this.jour = jour;
    }
}

public class Anniversaires {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String d = "25/12/0001";
        String modele = "dd/MM/yyyy";
        DateTimeFormatter formater = DateTimeFormatter.ofPattern(modele);
        LocalDate anniv = LocalDate.parse(d, formater);
        LocalDate now = LocalDate.now();
        Period period = Period.between(anniv, now);
        int annees = period.getYears();
        annees += now.compareTo(anniv.plusYears(annees)) >= 0 ? 1 : 0;

        LocalDate[] datesAnniversaire = new LocalDate[annees];
        for (int annee = 0; annee < annees; annee++) {
            datesAnniversaire[annee] = anniv.plusYears(annee);
            JourAnniversaire.IncrementeDates(datesAnniversaire[annee]);
        }
        System.out.println((System.nanoTime()-start)/1000000); 
        for (JourAnniversaire jour : JourAnniversaire.DATES) {
            DayOfWeek dow = DayOfWeek.values()[jour.getJour() - 1];
            System.out.println(dow.getDisplayName(TextStyle.FULL, Locale.FRENCH) + " - " + jour.getNombre() + " fois - " + Arrays.toString(jour.getAnnees()) + " ");
        }
        System.out.println((System.nanoTime()-start)/1000000); ;
    }

}
