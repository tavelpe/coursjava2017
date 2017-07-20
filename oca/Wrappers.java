package oca;

public class Wrappers {

    public static void main(String[] args) {

        Short s;
        Integer i;
        Character c;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Long.BYTES);
        System.out.println(-1 / 0F == Float.NEGATIVE_INFINITY);
        System.out.println(-1 / 0F + 1 / 0F == Float.NaN);//false
        System.out.println(Float.isNaN(-1 / 0F + 1 / 0F));//true
        System.out.println(Character.isDigit('0'));

        int t = Integer.parseInt("12");
        double dd = Double.parseDouble("453.65");

        t = Integer.parseInt("1010111", 2);
        t = Integer.max(12, 10);

        t = Integer.valueOf("12");

        Double d2 = Double.valueOf(12.2);

        System.out.println(Boolean.parseBoolean("True"));
        System.out.println(Boolean.parseBoolean("123"));
        System.out.println(Boolean.parseBoolean("0"));

        Double ss = new Double(12.3);
        ss = new Double("12.3");
        dd = ss.doubleValue();

        Double td = 12.5;
        double d1 = ss;

        td = null;
        //d1 = td;

        float f1 = 2;

        Float ff = Float.valueOf(t);
        for (int j = 0; j < 10; j++) {
            ff = ff + 1;
            ff = Float.valueOf(ff.floatValue() + Float.valueOf(1));
        }

        double d4 = Float.parseFloat("12.0");

        Integer in0 = 1200;
        Integer in1 = 1200;
        System.out.println(in0 == in1);
        System.out.println(in0 >= in1);

        int in2 = 1200;
        System.out.println(in0 == in2);
        Byte b =(byte)10;
        Float f = 10f;
        AfficheP( 'z' );
        
        
        
        
    }
    static void AfficheN(int i) {//byte, short, int, char, Byte, Short, Integer, Character

    }
    static void AfficheW(Integer i) {//Integer, null, int

    }
    static void AfficheP(Integer i) {

    }
    static void AfficheP(float i) {

    }
     static void AfficheP(long i) {

    }
}
