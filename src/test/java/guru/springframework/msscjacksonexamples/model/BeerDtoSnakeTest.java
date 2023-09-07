package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

// LEZIONE 107
// La seguente annotazione permette
// Una strategia tramite il nome di una proprieta
// Property Naming strategy
// Jackson tramite la relfection Java ottiene il nome
// delle proprieta
// Vedere la classe PropertyNamesStrategy
// Cercare sotto Help/Find Action/Classes
// Si vede che è una classe di configurazione
// con una serie di opzioni
// Tra le quali SNAKE-CASE che possiamo
// settare nel file di properties specifico dei test
// Vedere la definizione del SNAKE_CASE
// all'inizio della classe PropertyNamingStrategy
@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends  BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    // Serialize test
    // vedere la seguente riga sulla console
    // the following profiles are active: snake
    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }



}
