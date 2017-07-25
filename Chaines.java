
package oca;


public class Chaines {
    public static void main(String[] args) {
        
        ch\u0061r c = '\u0042';
        System.out.println(c);
        c=66;
        System.out.println(c);
        \u0042oole\u0061n b = true;
        
    }

    private static void Strings() {
        String n = "titi";
        String m = new String("titi");
        System.out.println(n == m);//false
        System.out.println(n.equals(m));//true
        String p = "titi";
        System.out.println(n == p);//true
        String r = "TITI".toLowerCase();
        System.out.println(r == p);//false
        String t = "titi".toLowerCase();
        System.out.println(t == p);//true
        t.toUpperCase();
        System.out.println(t == p);//true
        t=t.toUpperCase();
        System.out.println(p);//titi
        
        t = "   t"+"i"+"t"+"i   ";
        
        System.out.println(t=t.trim());
        System.out.println(t.length());
        
        System.out.println("     ".isEmpty());//false!
        System.out.println(t.equalsIgnoreCase("TITI"));
        System.out.println(t.replace('t', 'w'));
        System.out.println(t);
        System.out.println(t.concat(t.replace('i','o')));
        System.out.println("toto".compareTo("titi"));
        System.out.println("toto".compareTo("toto"));
        System.out.println("titi".compareTo("toto"));
        System.out.println("Titi".compareTo("titi"));
        System.out.println("Titi".compareToIgnoreCase("titi"));
        System.out.println("Tîti".compareToIgnoreCase("titi"));
        System.out.println(t.startsWith("ti"));
        System.out.println(t.endsWith("ti"));
        
        String[] ts= "12 56,4;5,8,99,,10".split("[ ,;]+");//Regular Expression
        for (String t1 : ts) {
            System.out.print(t1+";");
        }
        System.out.println("");
        t=String.format("%s fr-", 12f);
        t=String.format("%.2f fr-", 412.129456d);
        t=String.format("%,.1f0 fr-", 411252.129456d);
        t=String.format("%,d fr-", 411252l);
        t=String.format("%b", 45);//true
        t=String.format("%b", null);//false
        t=String.format("%b", "false");//true
        t=String.format("%b", false);//false
        t=String.format("%tA",  new java.util.Date()  );
        t= String.format("|%20d|", 411252L);
        t= String.format("|%,20.2f|", 4112521f);
        t= String.format("|%-,20.2f|", 4112521f);
        
        t = String.format("%d est plus grand que %d et plus petit que %d",10, 5 , 18);
        t = String.format("%3$d est plus grand que %1$d et plus petit que %2$d", 5 , 18, 10);
        t = String.format("%2$d est égal à %2$d et plus petit que %1$d" , 18, 10);
        
        t = String.format("%3$d est plus grand que %1$d et plus petit que %2$d", 
                new Object[]{5, 18, 10});
        
        System.out.println( t );   
    }

    private static void StringBS() {
        StringBuilder sb = new StringBuilder(10000);
        StringBuffer sbu = new StringBuffer();
        System.out.println(sb.capacity());
        System.out.println(sbu.capacity());
        sbu.append("12345678912345678");
        System.out.println(sbu.capacity());
        
        sb.append("A");sb.append("B");sb.append("C");sb.append("D");
        System.out.println(sb.length());
        sb.append("E").append("F").append("G").append("H");
        
        System.out.println(sb.insert(sb.length()/2, " au milieu "));
        System.out.println(sb.delete(8, 12));
        
        System.out.println(sb.replace(5, 10, "INSERER"));
        sb.ensureCapacity(12008);
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());
        
        System.out.println(sb.charAt(0));
        System.out.println(sb.indexOf("IN"));
        System.out.println(sb.indexOf("Z"));//-1
        System.out.println(sb.lastIndexOf("E"));
        System.out.println(sb.indexOf("E",9));
        
        System.out.println(sb.substring(5));         
        System.out.println(sb.substring(5,13)+"'");
        
        sb.setLength(24);
        System.out.println(sb.length());
        System.out.println(sb.toString()+"'");
    }
}
