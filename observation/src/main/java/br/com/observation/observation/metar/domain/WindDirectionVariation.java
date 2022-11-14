package br.com.observation.observation.metar.domain;

public class WindDirectionVariation {

    private Long from;
    private Long to;

    public WindDirectionVariation(final Long from, final Long to) {
        this.from = from;
        this.to = to;
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }
    
}
