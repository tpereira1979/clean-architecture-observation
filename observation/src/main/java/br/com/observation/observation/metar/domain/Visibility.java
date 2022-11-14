package br.com.observation.observation.metar.domain;

public class Visibility {
    
    private Long prevaling;
    private Long minimum;
    
    public Visibility(final Long prevaling, final Long minimum) {
        this.prevaling = prevaling;
        this.minimum = minimum;
    }

    public Long getPrevaling() {
        return prevaling;
    }

    public Long getMinimum() {
        return minimum;
    }
}
