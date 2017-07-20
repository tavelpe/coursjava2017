package oca;

public class Premiere {

    public static void main(String[] args) {
        
        
        
    }

    private static void switchcase() {
        byte z =4;
        switch(z){
            default:{
                System.out.println("autre...");
                z=1;
                break;
            }
            case 1:
                System.out.println("un");
                break;
            case 2:
                System.out.println("deux");
                break;
            case 3:
                System.out.println("trois");
                break;
            
        }
//        
//       if(z==1){
//           System.out.println("un");
//       } 
//       else
//           if(z==2){
//                System.out.println("deux");
//           }
//        
    }

    private static void elvis() {
        float f =20.01f;
        System.out.println( (f>20?"sup":"inf")   );
        if(f>20){
            System.out.println("sup");
        }
        else{
            System.out.println("inf");
        }
        
        System.out.println( (f>20?"sup": (f<20?"inf":20) )   );
        if(f>20){
            System.out.println("sup");
        }
        else{
            if(f<20)
                System.out.println("inf");
            else
                System.out.println("egal");
        }
        int r = f>20 ? 21 : (f<20 ? 19 : 20);
    }

    private static void Boucles() {
        int[] ti = {5, 10, 3, 2};
        
        if (ti[0] < 3) {//3
            System.out.println("<3");
        } else//>=3
            if (ti[0] == 3) {
                System.out.println("==3");
            } else {
                System.out.println(">3");
            }
        
        if (ti[0] > 3 && ti[0] < 10) {
            System.out.println(" 4 5 6 7 8 9");
        }
        if (ti[0] <= 3 || ti[0] >= 10) {
            System.out.println("...1 2 3 10 11 12 13...");
        }
        if (ti[0] <= 3 && ti[0] >= 10) {//false
            System.out.println("..............");
        }
        if (ti[0] > 3 || ti[0] < 10) {
            System.out.println("...0 1 2 3 4 5 6 7 8 9 10 11 12 .... ");
        }

        int z = 10;
        if (z > 10 ^ z + 1 > 10) {
            System.out.println(z);
        } else {
            System.out.println("hohoho" + z);
        }
        int olives = 1;
        int oignons = 2;
        int champs = 4;
        int anchois = 8;
        int creme = 16;

        int garniture = oignons | anchois;
        System.out.println((garniture & oignons) == oignons);
        System.out.println((garniture & creme) == creme);
        
//         for (  System.out.println(), z=10   ; ; ) {        
//        }
//        for ( int u=12, t=5   ; ; ) {          
//        }
//         for (;   z<10 && z>5     ;) {      
//        }
//        for (;;   System.out.println(), z++) {
//        }
for (int i = 0; i < 10; i++) {
    System.out.println("i=" + i);
}

int i = 0;
for (;;) {
    if (i >= 10) {
        break;
    }
    System.out.println("i=" + i);
    i++;
}

externe:
for (int grille = 0; grille < 4; grille++) {
    for (int numero = 0; numero < 7; numero++) {
        
        System.out.println(numero);
        if (numero % 2 == 0) {
            break externe;
        }
    }
}
System.out.println("suite");

extern:
for (int j = 0; j < 5; j++) {
    for (int k = 0; k < 3; ++k) {
        System.out.println("k=" + k);
        if (k % 2 == 0) {
            continue extern;
        }
        System.out.println("\tj=" + j);
    }
}

for (int j = 10, h = 0; j > 0 && h < 10; j -= 2, h += 2) {
    System.out.print("j=" + j);
    System.out.println(" h=" + h);
}

int[] tj = {1, 3, 5, 7, 9, 11};
for (int v : tj) {
    v++;
    System.out.println(v);
    if (v == 6) {
        tj[3] = 15;
        break;
    }
}

for (int v : tj) {
    System.out.println(v);
}
System.out.println("----------------------------");
int ind = 0;
while (ind < tj.length) {
    System.out.println(tj[ind]);
    ind++;
    if (ind > 3) {
        break;
    }
}
ind = 0;
do {
    System.out.println(tj[ind]);
    ind++;
    if (ind > 3) {
        break;
    }
} while (ind < tj.length);

ind = 0;
while(ind<5){
    System.out.println(ind);
    if(true)
        continue;
    
    System.out.println(ind+1);
}
    }

    private static void CallMethods() {
        int[] ti = {5, 10, 3, 2};
        System.out.println(ti[0]);
        ti[0] = 9;

        int[] tj = ti;
        tj[1] = 12;
        ti = null;

        int t = 10;
        affiche(t);
        t *= 2;
        affiche(20);
        t = 50;
        changeInt(t);
        System.out.println(t);
        t = Incremente(t);
        System.out.println(t);
        Incremente(tj);
        System.out.println(tj[0]);
    }

    static void affiche(int u) {
        System.out.println(u * 5);
    }

    static void changeInt(int t) {
        t++;
    }

    static int Incremente(int t) {
        return t + 1;
    }

    static void Incremente(int[] t) {
        t[0]++;
        //t=null;
    }

    private static void operateurs() {
        byte a = 10;
        byte b = 2;
        // byte r = a + b; illegal car 
        int r = a + b;
        byte rb = (byte) (a + b);

        double rd = 15 / 2;
        System.out.println(rd); //7!!
        rd = 15 / 2.999999999f;
        System.out.println(rd);
        System.out.println(rd == 5);
        System.out.println(15 / 3 == 5D);

        System.out.println(5 * 3 - 6 * 2);
        System.out.println(5 * (3 - 6) * 2);
        System.out.println(10 % 3);
        System.out.println(11 % 2 + 3);

        System.out.println(5 | 2);
        System.out.println(5 & 2);
        System.out.println(5 ^ 2);
        System.out.println(-5 >> 2);
        System.out.println(5 << 2);
        System.out.println(-5 >>> 2);

        r = 10;
        r++;
        r = r + 1;
        r--;
        r = r - 1;
        r += 2;
        r = r + 2;
        r /= 2;
        r %= 2;

        double g = 25.6;
        System.out.println(-g % -3.5);
    }

    private static void declarations() {
        int i = 2_000_000_000;
        i = 600;

        byte b = (byte) i;
        System.out.println(b == i);
        short s = 32000;
        long l = 3_000_000_000L;
        i = b;

        System.out.println(b == i);

        System.out.println(b);

        int zi = 01234;
        System.out.println(zi);

        zi = 0xCafe_Babe;
        System.out.println(zi);
        zi = 0b111_1111_111;
        System.out.println(zi);

        double d = 12456.6;
        float f = 3_000_000_000F;
        System.out.println(f);
        f = 3_000_000_123F;
        System.out.println(f);
        d = 3_000_000_000_000_123D;
        System.out.println(d);

        System.out.println(10.0 / 0);
        //System.out.println(10 / 0);
        System.out.println(10.0 / 0 - 10.0 / 0);
        zi = 10;
        //char ci = zi;
        char c = '2' - 10;
        System.out.println(c);
        c = 68;
        System.out.println(c);
        c = '0';
        System.out.println((int) c);

        boolean bo;
        bo = true;
        bo = false;
        if(bo=true){//!!!
            System.out.println("bo="+bo);
        }
        else{
           System.out.println("!bo="+bo);
        }
    }

}
