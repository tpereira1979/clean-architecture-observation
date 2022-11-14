package br.com.observation.metar.domain.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.observation.observation.metar.domain.Wind;
import br.com.observation.observation.metar.domain.builder.WindBuilder;

public class WindBuilderTest {

    @Test
    public void shouldBuilWind() {

        Wind wind = WindBuilder.create()
                               .setDirection(100l)
                               .setSpeed(10l)
                               .setGust(5l)
                               .setWindDirectionVariation(50l, 100l)
                               .build();
        assertEquals(100l, wind.getDirection());
        assertEquals(10l, wind.getSpeed());
        assertEquals(5l, wind.getGust());
        assertEquals(50l, wind.getWindDirectionVariaton().getFrom());
        assertEquals(100l, wind.getWindDirectionVariaton().getTo());
    }
    
}
