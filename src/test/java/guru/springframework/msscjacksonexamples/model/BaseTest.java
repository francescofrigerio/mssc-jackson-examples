package guru.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

// LEZIONE 106
public class BaseTest {

    BeerDto getDto() {
        return BeerDto.builder()
                .beerName("Pippe Beude")
                .beerStyle("Ale")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.35"))
                .upc(12344555512L).build();

    }
}
