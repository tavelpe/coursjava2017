package oca;

public class LesExceptions {

    public static void main(String[] args) {
        System.out.println("Debut");
        int r = calcul(10, 0);
        System.out.println("Fin");
    }

    
    static int calcul(int i, int j) {   
        return i/j;
    }
    
}
