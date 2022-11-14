package br.com.observation.observation.metar.domain;

public class Temperature {

    private Double air;
    private Double dewPoint;

    public Temperature(final Double air, final Double dewPoint) {
        this.air = air;
        this.dewPoint = dewPoint;
    }

    public Double getAir() {
        return air;
    }

    public Double getDewPoint() {
        return dewPoint;
    }
    
}
