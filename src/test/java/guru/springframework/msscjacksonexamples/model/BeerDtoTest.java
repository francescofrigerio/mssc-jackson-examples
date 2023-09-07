package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// LEZIONE 106
@JsonTest
class BeerDtoTest extends  BaseTest {

    // Prendiamo l'oggetto dal contesto di SpringBoot
    @Autowired
    ObjectMapper objectMapper;

    // Test della serializzazione
    // da uun oggetto java Pojo a un Json
    @Test
    void testSerializeDto() throws JsonProcessingException  {
         BeerDto beerDto = getDto();

         // Aggiungo l'eccezzione alla classe altrimenti
        // da un errore icompiletime l metodo writeValueAsString
        // Il Json viene configurato da SpringBoot
         String jsonString = objectMapper.writeValueAsString(beerDto);

        // Verificare sulla console la costruzione della stringa in formato json
         System.out.println(jsonString);
    }

    // Test della Deserializzazione
    // da un Json su un oggetto java Pojo
    @Test
    void testDeserializeDto() throws IOException {
        String json = "{\"id\":\"75afb08e-0954-4f3c-a10a-88349fe0303e\"," +
                      "\"beerName\":\"Pippe Frenke\",\"beerStyle\":\"Ale\", " +
                      "\"upc\":12344555512,\"price\":12.35," +
                      "\"createdDate\":\"2023-09-07T08:36:36.6445417+02:00\"," +
                      "\"lastUpdatedDate\":\"2023-09-07T08:36:36.6455457+02:00\"}";

        // Aggiungo l'eccezzione alla classe altrimenti
        // da un errore compiletime il metodo readValue
        // Verificare sulla console la costruzione dell'oggetto
        BeerDto dto = objectMapper.readValue(json,BeerDto.class);

        System.out.println(dto.toString());

    }

}