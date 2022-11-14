package br.com.observation.observation.metar.domain;

public class Location {

    private String icaoCode;

    public Location(final String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }    
}
