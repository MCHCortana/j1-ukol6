package cz.czechitas.ukol06.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.time.MonthDay;
import java.util.List;
import java.util.stream.Stream;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("data/svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {

       seznamSvatku = objectMapper.readValue(cestaKDatum.toFile(), SeznamSvatku.class);

    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {

        List<Svatek> svatky = seznamSvatku.getSvatky();
        // získat seznam svátků

        Stream<Svatek> svatkyStream = svatky.stream();
        // převést na Stream

        Stream<Svatek> odpovidajiciZaznam = svatkyStream.filter(svatek -> svatek.getDen().equals(day));
        // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
        Stream<String> jmenoZeZaznamu = odpovidajiciZaznam.map(Svatek::getJmeno);

        // pomocí metody map() získat z objektu jméno
        // pomocí toList() převést na List
        return jmenoZeZaznamu.toList();
    }
}
