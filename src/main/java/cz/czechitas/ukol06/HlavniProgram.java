package cz.czechitas.ukol06;


import cz.czechitas.ukol06.svatky.SvatkySluzba;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

/**
 * Hlaví třída pro aplikaci Svátky.
 */
public class HlavniProgram {
    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new HlavniProgram().run();
    }

    /**
     * Hlavní metoda obsahující výkonný kód.
     */
    public void run() throws IOException {
        SvatkySluzba seznamSvatku = new SvatkySluzba();
        List<String> svatkyDnes = seznamSvatku.vyhledatSvatkyDnes();

        MonthDay day = MonthDay.of(07, 24);
        List<String> svatkyKdy = seznamSvatku.vyhledatSvatkyKeDni(day);

        System.out.println(seznamSvatku.vyhledatSvatkyKeDni(MonthDay.of(8,11)));

        if (svatkyDnes.isEmpty()) {
            System.out.println("Dnes nemá svátek nikdo.");
        } else if (svatkyDnes.size() == 1) {
            System.out.printf("Dnes má svátek %s.", svatkyDnes.get(0)).println();
        } else {
            System.out.println("Dnes mají svátek:");
            svatkyDnes.forEach((svatek) -> System.out.printf("- %s", svatek).println());
        }

        if (svatkyKdy.isEmpty()) {
            System.out.printf("Dne %s nemá svátek nikdo", day);
        } else if (svatkyKdy.size() == 1) {
            System.out.printf("%s má svátek %s.", day, svatkyDnes.get(0)).println();
        } else {
            System.out.printf("%s mají svátek: %n", day);
            svatkyKdy.forEach((svatek) -> System.out.printf("- %s", svatek).println());
        }
    }

}
