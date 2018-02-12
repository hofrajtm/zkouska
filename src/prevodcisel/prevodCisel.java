/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prevodcisel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Martin
 */
public class prevodCisel {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        // Vypsaní funkce programu.
        System.out.println("Program pro převod čísel z arabských číslic na římská a naopak.");
        System.out.println();

        // Vypsaní funkce první části programu.
        System.out.println("Převod čísla z arabských číslic na římské.");

        /* Určení parametru 'zadaneACislo' (číslo v arabských číslicích). Uznání
        pouze toho čísla, které odpovídá arabským číslicím v intervalu 1-3999,
        tedy v rozsahu římských čísel. Číslo 0 ukončí tuto část programu.*/
        int zadaneACislo = 0;
        do {
            boolean nacteno = false;
            do {
                System.out.print("Zadejte číslo:");
                try {
                    zadaneACislo = readInt();
                    if (zadaneACislo > -1 && zadaneACislo < 3999) {
                        nacteno = true;
                    } else {
                        System.out.println("Číslo v arabských číslicích je možné zadat pouze v kladných celých hodnotách v intervalu 1-3999, tedy v rozsahu čísel v římských číslicích.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Musíte zadat číslo.");
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("Chybně načtené číslo.");
                    System.exit(1);
                }
            } while (nacteno != true);

            // Převedení zadaného čísla z datového typu 'integer' na 'string'.
            String pretypovaneACislo = String.valueOf(zadaneACislo);

            // Převrácení pořadí jednotlivých cifer v čísle.
            String prevraceneACislo = new StringBuffer(pretypovaneACislo).reverse().toString();

            // Převedení řetězce na pole. 
            char[] cisliceArabske = prevraceneACislo.toCharArray();

            /* Větvení programu podle počtu cifer zadaného čísla a následné
            zjišťování dle jedné z metod, které ze symbolů I, V, X, L, C, D, M
            (římské číslice) odpovídá arabskému číslu. Zadáním vstupu '0' se
            program posune dál.*/
            switch (cisliceArabske.length) {
                case 1:
                    if (cisliceArabske[0] == '0') {
                        System.out.println("Ukončili jste první část programu.");
                    } else {
                        System.out.println("Výsledek je: " + radJednotek(cisliceArabske));
                    }
                    break;
                case 2:
                    System.out.println("Výsledek je: " + radDesitek(cisliceArabske) + radJednotek(cisliceArabske));
                    break;
                case 3:
                    System.out.println("Výsledek je: " + radStovek(cisliceArabske) + radDesitek(cisliceArabske) + radJednotek(cisliceArabske));
                    break;
                case 4:
                    System.out.println("Výsledek je: " + radTisicu(cisliceArabske) + radStovek(cisliceArabske) + radDesitek(cisliceArabske) + radJednotek(cisliceArabske));
                    break;
            }
        } while (zadaneACislo != 0);

        System.out.println();

        // Vypsání funkce druhé části programu.
        System.out.println("Převod čísla z římských číslic na arabské.");

        String zadaneRCislo;
        do {
            // Určení parametru 'zadaneRCislo' (číslo v římských číslicích).
            System.out.print("Zadejte číslo:");
            zadaneRCislo = readString();

            // Převedení řetězce na pole.
            char[] cisliceRimske = zadaneRCislo.toCharArray();

            /* Uznání pouze toho zadaného čísla, které obsahuje znaky odpovídající
            římským číslicím, tj. I, V, X, L, C, D, M, v jiném případě je program
            ukončen. Číslo 0 je zahrnuto pro možnost ukončení programu.*/
            for (int i = 0; i < cisliceRimske.length; i++) {
                if (cisliceRimske[i] == 'I' || cisliceRimske[i] == 'V' || cisliceRimske[i] == 'X' || cisliceRimske[i] == 'L' || cisliceRimske[i] == 'C' || cisliceRimske[i] == 'D' || cisliceRimske[i] == 'M' || cisliceRimske[i] == '0') {
                } else if (cisliceRimske[i] == '0') {
                    System.out.println("Ukončili jste program.");
                    System.exit(0);
                } else {
                    System.err.println("Zadané číslo je možné zapsat pouze znaky I, V, X, L, C, D a M odpovídajícími římským číslicím.");
                    System.exit(1);
                }
            }

            /* Větvení programu podle počtu znaků v zadaném čísle a následně podle
            příslušnosti jednotlivých znaků I, V, X, L, C, D a M (římských číslic)
            k určité hodnotě.*/
            if (cisliceRimske.length == 1) {
                int vysledek = 0;
                switch (cisliceRimske[0]) {
                    case 'I':
                        vysledek = 1;
                        break;
                    case 'V':
                        vysledek = 5;
                        break;
                    case 'X':
                        vysledek = 10;
                        break;
                    case 'L':
                        vysledek = 50;
                        break;
                    case 'C':
                        vysledek = 100;
                        break;
                    case 'D':
                        vysledek = 500;
                        break;
                    case 'M':
                        vysledek = 1000;
                        break;
                }
                System.out.println("Výsledek je:" + vysledek);
            } else {
                int[] cisliceRimskeHodnota = new int[cisliceRimske.length];
                for (int i = 0; i < cisliceRimske.length; i++) {
                    switch (cisliceRimske[i]) {
                        case 'I':
                            cisliceRimskeHodnota[i] = 1;
                            break;
                        case 'V':
                            cisliceRimskeHodnota[i] = 5;
                            break;
                        case 'X':
                            cisliceRimskeHodnota[i] = 10;
                            break;
                        case 'L':
                            cisliceRimskeHodnota[i] = 50;
                            break;
                        case 'C':
                            cisliceRimskeHodnota[i] = 100;
                            break;
                        case 'D':
                            cisliceRimskeHodnota[i] = 500;
                            break;
                        case 'M':
                            cisliceRimskeHodnota[i] = 1000;
                            break;
                    }
                }

                /* Podmínky, aby zapsané číslo odpovídalo pravidlům zapisování
                pomocí římských číslic.*/
                // PRAVIDLO 3A
                for (int i = 2; i < cisliceRimskeHodnota.length; i++) {
                    if ((cisliceRimskeHodnota[i] >= cisliceRimskeHodnota[i - 1]) && (cisliceRimskeHodnota[i] > cisliceRimskeHodnota[i - 2])) {
                        System.err.println("Není možné, aby se v zadaném čísle vyskytovaly dva symboly o nižší hodnotě, případně nižší a stejné hodnotě než symbol po nich následující.");
                        System.exit(1);
                    }
                }

                // PRAVIDLO 3B
                for (int i = 1; i < cisliceRimskeHodnota.length; i++) {
                    if (cisliceRimskeHodnota[i] > cisliceRimskeHodnota[i - 1]) {
                        if ((cisliceRimskeHodnota[i] == 5 && cisliceRimskeHodnota[i - 1] == 1)
                                || (cisliceRimskeHodnota[i] == 10 && cisliceRimskeHodnota[i - 1] == 1)
                                || (cisliceRimskeHodnota[i] == 50 && cisliceRimskeHodnota[i - 1] == 10)
                                || (cisliceRimskeHodnota[i] == 100 && cisliceRimskeHodnota[i - 1] == 10)
                                || (cisliceRimskeHodnota[i] == 500 && cisliceRimskeHodnota[i - 1] == 100)
                                || (cisliceRimskeHodnota[i] == 1000 && cisliceRimskeHodnota[i - 1] == 100)) {
                        } else {
                            System.err.println("Není možné, aby se v zadaném čísle vyskytoval symbol nižší hodnoty před symbolem vyšší hodnoty, kromě případů IV, IX, XL, XC, CD a CM.");
                            System.exit(1);
                        }
                    }
                }

                // PRAVIDLO 3C
                for (int i = 2; i < cisliceRimskeHodnota.length; i++) {
                    if (cisliceRimskeHodnota[i] < cisliceRimskeHodnota[i - 1] && cisliceRimskeHodnota[i - 1] > cisliceRimskeHodnota[i - 2]) {
                        if (((cisliceRimskeHodnota[i - 2] == 10 && cisliceRimskeHodnota[i - 1] == 50) && ((cisliceRimskeHodnota[i] == 5) || (cisliceRimskeHodnota[i] == 1)))
                                || ((cisliceRimskeHodnota[i - 2] == 10 && cisliceRimskeHodnota[i - 1] == 100) && ((cisliceRimskeHodnota[i] == 5) || (cisliceRimskeHodnota[i] == 1)))
                                || ((cisliceRimskeHodnota[i - 2] == 100 && cisliceRimskeHodnota[i - 1] == 500) && ((cisliceRimskeHodnota[i] == 50) || (cisliceRimskeHodnota[i] == 10) || (cisliceRimskeHodnota[i] == 5) || (cisliceRimskeHodnota[i] == 1)))
                                || ((cisliceRimskeHodnota[i - 2] == 100 && cisliceRimskeHodnota[i - 1] == 1000) && ((cisliceRimskeHodnota[i] == 50) || (cisliceRimskeHodnota[i] == 10) || (cisliceRimskeHodnota[i] == 5) || (cisliceRimskeHodnota[i] == 1)))) {
                        } else {
                            System.err.println("Není možné, aby se v zadaném čísle vyskytoval po symbole nejprve nižší a poté vyšší hodnoty symbol nižší hodnoty, kromě případů XLI, XLV, XCI, XCV, CDI, CDV, CDX, CDL, CML, CMX, CMV, CMI.");
                            System.exit(1);
                        }
                    }
                }

                // PRAVIDLO 4A
                for (int i = 1; i < cisliceRimskeHodnota.length; i++) {
                    if (cisliceRimskeHodnota[i] == 5 && cisliceRimskeHodnota[i - 1] == 5) {
                        System.err.println("Není možné, aby se v zadaném čísle vyskytoval symbol V na dvou po sobě jdoucích pozicích.");
                        System.exit(1);
                    } else if (cisliceRimskeHodnota[i] == 50 && cisliceRimskeHodnota[i - 1] == 50) {
                        System.err.println("Není možné, aby se v zadaném čísle vyskytoval symbol L na dvou po sobě jdoucích pozicích.");
                        System.exit(1);
                    } else if (cisliceRimskeHodnota[i] == 500 && cisliceRimskeHodnota[i - 1] == 500) {
                        System.err.println("Není možné, aby se v zadaném čísle vyskytoval symbol D na dvou po sobě jdoucích pozicích.");
                        System.exit(1);
                    }
                }

                // PRAVIDLO 4B
                for (int i = 3; i < cisliceRimskeHodnota.length; i++) {
                    if ((cisliceRimskeHodnota[i] == cisliceRimskeHodnota[i - 1]) && (cisliceRimskeHodnota[i] == cisliceRimskeHodnota[i - 2]) && (cisliceRimskeHodnota[i] == cisliceRimskeHodnota[i - 3])) {
                        System.err.println("Není možné, aby se v zadaném čísle opakovaly symboly I, V, X, L, C, D a M více než třikrát v řadě za sebou.");
                        System.exit(1);
                    }
                }

                // PRAVIDLO 5
                int I = 0;
                int V = 0;
                int X = 0;
                int L = 0;
                int C = 0;
                int D = 0;
                int M = 0;
                for (int i = 0; i < cisliceRimskeHodnota.length; i++) {
                    switch (cisliceRimskeHodnota[i]) {
                        case 1:
                            I += 1;
                            break;
                        case 5:
                            V += 1;
                            break;
                        case 10:
                            X += 1;
                            break;
                        case 50:
                            L += 1;
                            break;
                        case 100:
                            C += 1;
                            break;
                        case 500:
                            D += 1;
                            break;
                        case 1000:
                            M += 1;
                            break;
                    }
                }
                if (I > 4 || V > 4 || X > 4 || L > 4 || C > 4 || D > 4 || M > 4) {
                    System.err.println("Není možné, aby se v zadaném čísle vyskytovaly symboly I, V, X, L, C, D a M více než čtyřikrát.");
                    System.exit(1);
                }

                /* Souběžné přičítání/odčítání odpovídající hodnoty k/od výsledného
                čísla (na základě porovnání hodnoty i-tého a následujícího znaku)
                vyjádřeného arabskými číslicemi. Poslední prvek je vždy pouze
                přičten a to samostatně.*/
                int hodnotaVysledna = 0;
                for (int i = 0; i < cisliceRimskeHodnota.length - 1; i++) {
                    if (cisliceRimskeHodnota[i + 1] > cisliceRimskeHodnota[i]) {
                        cisliceRimskeHodnota[i] = cisliceRimskeHodnota[i] * (-1);
                    }
                    hodnotaVysledna += cisliceRimskeHodnota[i];
                }
                
                int posledniPrvek = cisliceRimskeHodnota[cisliceRimskeHodnota.length - 1];
                
                hodnotaVysledna += posledniPrvek;

                System.out.println("Výsledek je: " + hodnotaVysledna);
            }
        } while (!"0".equals(zadaneRCislo));
    }

    // Metoda pro načtení znaků odpovídajících arabským číslicím.
    public static int readInt() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    // Metoda pro zjišťování římských číslic v řádu jednotek.
    public static String radJednotek(char[] cislice) {
        String jednotky = new String();
        switch (cislice[0]) {
            case '1':
                jednotky = "I";
                break;
            case '2':
                jednotky = "II";
                break;
            case '3':
                jednotky = "III";
                break;
            case '4':
                jednotky = "IV";
                break;
            case '5':
                jednotky = "V";
                break;
            case '6':
                jednotky = "VI";
                break;
            case '7':
                jednotky = "VII";
                break;
            case '8':
                jednotky = "VIII";
                break;
            case '9':
                jednotky = "IX";
                break;
            case '0':
                jednotky = "";
                break;
        }
        return jednotky;
    }

    // Metoda pro zjišťování římských číslic v řádu desítek.
    public static String radDesitek(char[] cislice) {
        String desitky = new String();
        switch (cislice[1]) {
            case '1':
                desitky = "X";
                break;
            case '2':
                desitky = "XX";
                break;
            case '3':
                desitky = "XXX";
                break;
            case '4':
                desitky = "XL";
                break;
            case '5':
                desitky = "L";
                break;
            case '6':
                desitky = "LX";
                break;
            case '7':
                desitky = "LXX";
                break;
            case '8':
                desitky = "LXXX";
                break;
            case '9':
                desitky = "XC";
                break;
            case '0':
                desitky = "";
                break;
        }
        return desitky;
    }

    // Metoda pro zjišťování římských číslic v řádu stovek.
    public static String radStovek(char[] cislice) {
        String stovky = new String();
        switch (cislice[2]) {
            case '1':
                stovky = "C";
                break;
            case '2':
                stovky = "CC";
                break;
            case '3':
                stovky = "CCC";
                break;
            case '4':
                stovky = "CD";
                break;
            case '5':
                stovky = "D";
                break;
            case '6':
                stovky = "DC";
                break;
            case '7':
                stovky = "DCC";
                break;
            case '8':
                stovky = "DCCC";
                break;
            case '9':
                stovky = "CM";
                break;
            case '0':
                stovky = "";
                break;
        }
        return stovky;
    }

    // Metoda pro zjišťování římských číslic v řádu tisíců.
    public static String radTisicu(char[] cislice) {
        String tisice = new String();
        switch (cislice[3]) {
            case '1':
                tisice = "M";
                break;
            case '2':
                tisice = "MM";
                break;
            case '3':
                tisice = "MMM";
                break;
        }
        return tisice;
    }

    // Metoda pro načtení znaků odpovídajících římským číslicím.
    public static String readString() throws IOException {
        Scanner s = new Scanner(System.in);
        return s.next();
    }
}