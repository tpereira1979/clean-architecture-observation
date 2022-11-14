package br.com.observation.observation.metar.domain;

public class AtmosphericPressure {

    private Long qnh;
    
    public AtmosphericPressure(final Long qnh) {
        this.qnh = qnh;
    }

    public Long getQnh() {
        return qnh;
    }
    
}
