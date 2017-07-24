
package oca;
import java.util.Arrays;

class Ours implements Comparable<Ours>{
    int age, poids;
    String nom;
    public Ours(int age, int poids, String nom) {
        this.age = age;
        this.poids = poids;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Ours{" + "nom=" + nom +", age=" + age + ", poids=" + poids +  '}';
    }

    @Override
    public int compareTo(Ours o) {
      // return  this.age - o.age;
      // return this.age>o.age?1: (this.age==o.age?0:-1);
       return Integer.compare(this.age, o.age);
      
    }
    
    
    
    
    
    
}


public class Tableaux {
    public static void main(String... args) {
        
        System.out.println( somme(1,2,new int[]{5,6,8,4}) );
        System.out.println( somme( 5, 6, 8, 4 ) );
        System.out.println( somme(10, 30) );
        System.out.println(String.format("%s %s %s %s", 2,5,6,10));
        
        int[] ti = new int[]{5,6,8,4};
        Arrays.sort(ti);
        System.out.println(Arrays.toString(ti));
        int[] ti2 = new int[]{4,5,6,8};
        Integer[] tto =  Arrays.stream( ti ).boxed().toArray( Integer[]::new );
        Integer[] tto2 = Arrays.stream( ti2 ).mapToObj(i -> i).toArray(Integer[]::new);

        System.out.println(Arrays.deepEquals(tto, tto2));//equals 
        System.out.println(Arrays.equals(ti, ti2));//==
        
        System.out.println(Arrays.binarySearch(ti,5)); 
        System.out.println(Arrays.binarySearch(ti,7)); //-index -1
        
        //Arrays.fill(tto, 5);
        Arrays.fill(tto, 1, 3, 10);
        System.out.println(Arrays.toString(tto));
        int[] copy = new int[10];
        copy=Arrays.copyOf(ti,2);
        System.out.println(Arrays.toString(copy));
        copy=Arrays.copyOfRange(ti, 1, 3);
        System.out.println(Arrays.toString(copy));
        copy=Arrays.copyOfRange(ti, 1, 8);
        System.out.println(Arrays.toString(copy));
        System.arraycopy(ti, 1, copy, 4, 2);
        System.out.println(Arrays.toString(copy));
        
        Ours papa = new Ours(10, 150, "papa");
        
        Ours[] caverne = {
            new Ours(10, 150, "papa"),
            new Ours(12, 120, "maman"),
            new Ours(8, 160, "fils"),
            new Ours(3, 80, "fille")
        };
        
        
        Arrays.sort(caverne);
        System.out.println(Arrays.toString(caverne)); 
        
        
        
        
        
        
        
    }

    static int somme(int h, int k, int... ti){//varargs
        int somme =h+k;
        for (int i : ti) {
            somme+=i;
        }
        return somme;
    }
     static int somme(int h, int k){
        int somme =h+k;
        return somme;
    }
//     static int somme(int h, int k, int[] ti){//illegal
//        int somme =h+k;
//        for (int i : ti) {
//            somme+=i;
//        }
//        return somme;
//    }
     
//    static int somme(int h, int... ti){//varargs ambigüe
//        int somme =h;
//        for (int i : ti) {
//            somme+=i;
//        }
//        return somme;
//    }
    
    private static void general() {
        int[] ti;
        int tj[];
        int [] tk = { 5,6,7};
        tj = new int[] {};
        ti = new int[3];
        int t=5;
        ti = new int[t];
        System.out.println(ti.length);
        tk = null;
        
        int[][] tti;
        int[] ttj [] = {null, null};
        int ttk [][] = { {1,2,3}, {4,5,6} };
        int[] tz =ttk[0];
        tz[2]=10;
        System.out.println(ttk[0][2]==10);
        // tz = null;
        System.out.println(ttk[0][2]);
        
        ttj = ttk;
        //ttj[0]=null;
        
        int[] ty = ttj[0].clone();
        ty[2]=3;
        System.out.println(ttj[0][2]);
        
        int[][] tty = ttj.clone();
        tty[1][2]=8;
        System.out.println(ttj[1][2]);//8
        
        tty= new int[3][4];
        
        for (int[] is : tty) {
            boolean tr=true;
            for (int i : is) {
                if(tr==false)
                    System.out.print(",");
                System.out.print(i);
                tr=false;
            }
            System.out.println("");
        }
        System.out.println("---------------------");
        int length = tty.length;
        for (int i = 0; i < length; i++) {
            int[] is = tty[i];
            int length1 = is.length;
            for (int j = 0; j < length1; j++) {
                int k = is[j];
                System.out.print(k + (j<length1-1?",":""));
            }
            System.out.println("");
        }
        System.out.println("*****************************");
        tty = new int[3][];
        tty[0] = new int[]{5,6};
        tty[1] = new int[4];
        tty[2] = ty;
        for (int[] is : tty) {
            boolean tr=true;
            for (int i : is) {
                if(tr==false)
                    System.out.print(",");
                System.out.print(i);
                tr=false;
            }
            System.out.println("");
        }
        int[][][] ttty = {
            {
                {1,2}, {3,4,5}
            },
            {
                {6,7,8,9,10}, null
            },
            new int[3][4]
                ,
            {
                null
            }
        };
        System.out.println(ttty.length);
        int[][][] tttz = new int[3][][];
        tttz[0]= new int[5][3];
        tttz[1]= new int[5][];
        tttz[1][0]= new int[]{5,7,3,6};
        int[][][] tttk = new int[3][4][];
        tttk[0][0]=null;
        int[] z = {(byte)10, (byte)4};
        //z = new byte[2];
        int[][] jeu1 = {{1,2,3},{1,2,3}};
        int[][] jeu2 = {null, null};
        int[][] jeu3 = null;
        //int[][] jeu4 = new byte[2][3];
        int[][] jeu4 = new int[2][3];
        int[][] jeu5 = new int[2][];
        //int[][] jeu6 = new int[][];
        int[][] jeu6 ={ { }, { } };
        int[][] jeu7 = { null , { } };
        int[][] jeu8 = {new int[3], {2,5,6,8,9}};
        int[][] jeu9 = jeu8;
        int[][] jeu10 = { jeu7[1], jeu4[0]};
        int[][] jeu11 = jeu10.clone();
        int[][] jeu12 = tttz[0];
        //int[][] jeu13 = new Integer[2][3];
        Integer integ=null;
        int[][] jeu13 = {{new Integer(2),new Integer(3)},{ new Integer(4), integ} };
        int[][] jeu14 = {   };
        int[][] jeu15 = new int[0][];
    }
}
