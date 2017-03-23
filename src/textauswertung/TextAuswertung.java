package textauswertung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextAuswertung {

    public static void main(String[] args) throws Exception {
        String[] textarray = dateiauswerten("H:\\tst.txt");
//      String[] textarray = dateiauswerten("H:\\gesetztesentwurf.txt");
        wörterzählen(textarray);

    }

    static String[] dateiauswerten(String pfad) {
        String text = "";
        String zeile = "";
        int anzahlzeile = 0;
        int zeichen = 0;

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(pfad);
            isr = new InputStreamReader(fis, "ISO-8859-1");
//            isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);

            while ((zeile = br.readLine()) != null) {
                if (zeile.isEmpty()) {

                } else {
                    text += zeile.trim() + " ";
                }
                anzahlzeile++;

            }

            String textarray[] = text.split(" ");//Einzelne Wörter werden in dem Array gespeichert

            for (int i = 0; i < textarray.length; i++) {
                zeichen += textarray[i].length();
            }

            System.out.println("Wörter: " + (textarray.length));
            System.out.println("Zeichen: " + zeichen);
            System.out.println("Zeilen: " + anzahlzeile);
            return textarray;

        } catch (IOException ioe) {//Ausnahmebehandlung
            ioe.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }

        return null;
    }

    static void wörterzählen(String[] textarray) {
           
    }

}
