package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    @Test
    void zjistitKdyzNeniSvatek() throws IOException  {
        SvatkySluzba svatky = new SvatkySluzba();
        int resultNeniJmeno = 0;
        assertEquals(resultNeniJmeno, svatky.vyhledatSvatkyKeDni(MonthDay.of(5, 1)).size());
    }
    @Test
    void zjistiKdyzJeViceJmen() throws IOException{
        SvatkySluzba svatky = new SvatkySluzba();
        List<String> resultKdyzJeViceJmen = svatky.vyhledatSvatkyKeDni(MonthDay.of(4,24));
            assertEquals(resultKdyzJeViceJmen.get(0), "Jiří");
            assertEquals(resultKdyzJeViceJmen.get(1), "Jarilo");
            assertEquals(resultKdyzJeViceJmen.size(), 2);
    }
    @Test
    void zjistiKdyzJeJednoJmeno() throws IOException{
        SvatkySluzba svatky = new SvatkySluzba();
        List<String> resultKdyzJeViceJmen = svatky.vyhledatSvatkyKeDni(MonthDay.of(8,11));
        assertEquals(resultKdyzJeViceJmen.get(0), "Zuzana");
        assertEquals(resultKdyzJeViceJmen.size(), 1);


    }
};
