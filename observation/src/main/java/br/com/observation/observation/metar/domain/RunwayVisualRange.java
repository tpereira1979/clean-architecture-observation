package br.com.observation.observation.metar.domain;

public class RunwayVisualRange {

    private String runway;
    private Long value;
    private String tendency;
    
    public RunwayVisualRange(final String runway, final Long value, final String tendency) {
        this.runway = runway;
        this.value = value;
        this.tendency = tendency;
    }

    public String getRunway() {
        return runway;
    }
    
    public Long getValue() {
        return value;
    }

    public String getTendency() {
        return tendency;
    }    
}
