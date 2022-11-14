package br.com.observation.observation.metar.domain.builder;

import br.com.observation.observation.metar.domain.Wind;
import br.com.observation.observation.metar.domain.WindDirectionVariation;

public class WindBuilder {

    private Long direction;
    private Long speed;
    private Long gust;
    private Long fromWindDirection;
    private Long toWindDirection;

    public static WindBuilder create() {
        return new WindBuilder();
    }

    public WindBuilder setDirection(final Long direction) {
        this.direction = direction;
        return this;
    }

    public WindBuilder setSpeed(final Long speed) {
        this.speed = speed;
        return this;
    }

    public WindBuilder setGust(final Long gust) {
        this.gust = gust;
        return this;
    }

    public WindBuilder setWindDirectionVariation(final Long from, final Long to) {
        this.fromWindDirection = from;
        this.toWindDirection = to;
        return this;
    }

    public Wind build() {
        return new Wind(direction, speed, gust, new WindDirectionVariation(fromWindDirection, toWindDirection));
    }
}
