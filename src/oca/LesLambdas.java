package oca;

import java.time.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LesLambdas {

    public static void main(String[] args) {
        List<Eleve> cours = new ArrayList<>();
        cours.add(new Eleve("Albert", 12, 12, 1968, Sexe.H));
        cours.add(new Eleve("Jean", 10, 1, 1950, Sexe.H));
        cours.add(new Eleve("Albert", 12, 12, 1970, Sexe.H));
        cours.add(new Eleve("Pauline", 9, 12, 1980, Sexe.F));
        cours.add(new Eleve("Justine", 12, 9, 1975, Sexe.F));
        cours.add(new Eleve("Henriette", 8, 12, 2000, Sexe.F));
        cours.add(new Eleve("John", 12, 12, 2005, Sexe.H));

        // PrintAgeRange(cours, 40, 60);
        // PrintAgeRange(cours, new FiltreEleve());
        // PrintGenericRange(cours, new FiltreEleveG());
        PrintGenericRange(cours, new FiltreG<Eleve>() {
            @Override
            public boolean test(Eleve e) {
                return e.getGenre() == Sexe.F;
            }
        });
        PrintGenericRange(cours, e -> e.getGenre() == Sexe.F);
        PrintWithPredicate(cours, HouF(Sexe.H));
        PrintWithPredicate(cours, e -> e.getGenre() == Sexe.H);
        Predicate<Eleve> peh = e -> e.getGenre() == Sexe.H;
        PrintWithPredicate(cours, peh);

        PrintWithPredicate(cours, (Eleve e) -> e.getGenre() == Sexe.H);
        PrintWithPredicate(cours, (Eleve e) -> {
                Sexe homme =  Sexe.H;
                return e.getGenre() == homme;
            }
        );
        
        Predicate<String> estVide = String::isEmpty; //method reference
        estVide = (String s)->s.isEmpty();//idem 
        
        System.out.println(estVide.test(""));
        
        Predicate<Eleve> estMajeur = Eleve::isAdult;
        System.out.println(estMajeur.test(cours.get(0))); 
        Consumer<Eleve> imprime = System.out::println; 
        imprime.accept(cours.get(0));
        
        cours.forEach(imprime);
        cours.stream().forEach(imprime);
        cours.stream().filter(peh).forEachOrdered(imprime);
        
        cours.stream().map(e-> e.getName()).forEach(System.out::println);
        System.out.println( cours.stream().mapToInt(Eleve::getAge).average().getAsDouble());
        OptionalDouble od= cours.stream().filter(e->e.getAge()>150).mapToInt(Eleve::getAge).average();
        if(od.isPresent())
            System.out.println(od.getAsDouble());
        cours.stream().filter(e->e.getAge()>150).mapToInt(Eleve::getAge).average()
                .ifPresent(System.out::println);
        Eleve FA =cours.stream()
                .filter(e->e.getGenre()==Sexe.F )
                .max( (e1,e2)-> Integer.compare(e1.getAge(),e2.getAge())).get();
        System.out.println(FA);
        
        Eleve Albert =cours.stream()
                .filter(e->e.getName().equals("Albert"))
                .findFirst()
                .orElse(null);

        System.out.println(Albert);
        Arrays.stream(new int[]{5,8,9,4,7,5,4}).distinct().forEach(System.out::println);
        
        
        
        
    }

    static Predicate<Eleve> HouF(Sexe s) {
        return e -> e.getGenre() == s;
    }

    static void PrintAgeRange(List<Eleve> le, int bas, int haut) {
        for (Eleve eleve : le) {
            if (eleve.getAge() >= bas && eleve.getAge() <= haut) {
                System.out.println(eleve);
            }
        }
    }

    static void PrintAgeRange(List<Eleve> cours, FiltreEleve filtreEleve) {
        for (Eleve eleve : cours) {
            if (filtreEleve.test(eleve)) {
                System.out.println(eleve);
            }
        }
    }

    static <E> void PrintGenericRange(List<E> liste, FiltreG<E> filtre) {
        for (E e : liste) {
            if (filtre.test(e)) {
                System.out.println(e);
            }
        }
    }

    static <E> void PrintWithPredicate(List<E> liste, Predicate<E> filtre) {
        for (E e : liste) {
            if (filtre.test(e)) {
                System.out.println(e);
            }
        }
    }

}

interface Filtre {

    boolean test(Eleve eleve);
}

@FunctionalInterface
interface FiltreG<E> {

    boolean test(E e);

    default void test2(E e) {
    }
}

class FiltreEleve implements Filtre {

    public boolean test(Eleve eleve) {
        return eleve.getAge() >= 20 && eleve.getAge() <= 40;
    }
}

class FiltreEleveG implements FiltreG<Eleve> {

    public boolean test(Eleve eleve) {
        return eleve.getAge() >= 20 && eleve.getAge() <= 40;
    }
}

class Eleve {

    private String name;
    private LocalDate anniversaire;
    private Sexe genre;

    public Eleve(String name, LocalDate anniversaire, Sexe genre) {
        this.name = name;
        this.anniversaire = anniversaire;
        this.genre = genre;
    }

    public Eleve(String name, int jour, int mois, int annee, Sexe genre) {
        this(name, LocalDate.of(annee, mois, jour), genre);
    }

    public int getAge() {
        return anniversaire.until(LocalDate.now()).getYears();
    }
    public boolean isAdult(){
        return getAge()>=18;
    }

    @Override
    public String toString() {
        return "Eleve{" + name + ", né le " + anniversaire + ", genre=" + genre + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAnniversaire() {
        return anniversaire;
    }

    public void setAnniversaire(LocalDate anniversaire) {
        this.anniversaire = anniversaire;
    }

    public Sexe getGenre() {
        return genre;
    }

    public void setGenre(Sexe genre) {
        this.genre = genre;
    }
}

enum Sexe {
    H, F
}
