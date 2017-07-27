package oca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LesExceptions {

    public static void main(String[] args) {
        try {
            division(null);
            division(12, 0);
            division();
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("la liste ne peut être vide");
        } catch (ArithmeticException ae) {
            System.out.println("div par 0 impossible");
        } catch (Exception ex) {
            System.out.println("Bizarre...");
        }

        try {
            division(null);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException ae) {
            //ae= new Exception();
            System.out.println("probleme dans la liste");
        } catch (Exception ex) {
            System.out.println("Bizarre...");
        }
        try {
            division(15, 0);
        } catch (Throwable ex) {
            System.out.println("Tutti frutti...");
            //System.exit(0);//pas de finally dans ce cas
        } finally {
            System.out.println("fin");
        }
        int r = 0;
        boolean b = false;
        try {
            r = division(15, 3);
            b = true;
        } finally {
            if (b) {
                System.out.println("r=" + r);
            } else {
                System.out.println("probleme");
            }
        }

        try {
            CreerFichierUnsafe();
        } catch (IOException ex) {
        }

        try {
            DoIt2();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        try {
            DoIt2();
        } catch (SQLException | IOException ex) {
        }
        try {
            DoIt2();
        } catch (Exception ex) {
        }

        DoIt3();

        try {
            DoIt4();
        } catch (MonDangereuseException ex) {
            System.out.println(ex.getMessage());
            if (ex.getCause() != null) {
                System.out.println(ex.getCause().getMessage());
                ex.printStackTrace();
                System.out.println(ex.getStackTrace()[0].getLineNumber()); 
            }
        }

//         try {
//             System.out.println("");//n'est pas dangereux!!
//        } catch (MonDangereuseException ex) {
//        }

//        try { 
//            try {
//                throw new MonDangereuseException();
//            } catch (MonDangereuseException ex) {            
//            }
//        } 
//        catch (MonDangereuseException ex) {//n'est pas dangereux car déjà géré           
//        }
        try {
            System.out.println("");
        } catch (Throwable ex) {

        }

        System.out.println("......END........");

    }

    private static void SimpleException() {
        System.out.println("Debut");
        Integer r = calcul(10, 0);
        System.out.println(r == null ? "calcul pas possible" : r);
        Long l = Parser("kjj");
        System.out.println(l == null ? "Parser pas possible" : l);
        try {
            l = ParserBeurk("kjj");
            System.out.println(l);
        } catch (NumberFormatException nfe) {
            System.err.println("ParserBeurk pas possible");
        }
        try {
            l = ParserCool("kjj");
            System.out.println(l);
        } catch (RuntimeException nfe) {
            System.err.println(nfe.getMessage());
        }
        try {
            calcul(10, 0F);
        } catch (ArithmeticException ae) {
            System.err.println(ae.getMessage());
        }

        System.out.println("Fin");
    }

    static int division(int... ti) {
        int res = ti[0];
        for (int i = 1; i < ti.length; i++) {
            res /= ti[i];
        }
        return res;

    }

    static Integer calcul(int i, int j) {
        if (j != 0) {
            return i / j;
        }
        return null;
    }

    static float calcul(float i, float j) {
        if (j != 0) {
            return i / j;
        }
        throw new ArithmeticException("Division par zero");
    }

    static Long Parser(String texte) {
        try {
            Long id = Long.parseLong(texte);//"-1_0L"
            return id;
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    static Long ParserBeurk(String texte) {
        Long id = Long.parseLong(texte);//"-1_0L"
        return id;
    }

    static long ParserCool(String texte) {
        try {
            Long id = Long.parseLong(texte);//"-1_0L"
            return id;
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("saisie '" + texte + "' non correcte.");
        }
    }

    static void CreerFichierSafe() {
        try {
            File.createTempFile("tempo", "titi");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void CreerFichierUnsafe() throws IOException {
        File.createTempFile("tempo", "titi");
    }

    static void DoIt() throws IOException {
        if (false) {
            throw new IOException();
        }
    }

    static void DoIt2() throws SQLException, IOException {

    }

    static void DoIt3() throws RuntimeException {

    }

    static void DoIt4() throws MonDangereuseException {

        try {
            File.createTempFile("z:\\", "z:\\");
        } catch (IOException ex) {
            throw new MonDangereuseException("Ouh lala", ex);
        }

    }

}

class MonDangereuseException extends Exception {

    public MonDangereuseException() {
    }

    public MonDangereuseException(String message) {
        super(message);
    }

    public MonDangereuseException(String message, Throwable cause) {
        super(message, cause);
    }

}

class G {
    void Doit() throws IOException
    {    }
    void Doit2() throws IOException
    {    }
    void Doit3() {
        
    }
}

class H extends G{
    void Doit()
    {    }
//    void Doit2() throws Exception //illégal car super classe de IOException

     void Doit2() throws FileNotFoundException//légal car sous classe de IOException
    {    }
    
//     void Doit3() throws Exception{//illégal car plus dangereux
    void Doit3() throws RuntimeException{
        
    }    
    
}
