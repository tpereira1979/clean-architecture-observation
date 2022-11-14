package br.com.observation.observation.metar.domain;

public class CloudLayer {

    private String coverage;
    private Long height;

    public CloudLayer(final String coverage, final Long height) {
        this.coverage = coverage;
        this.height = height;
    }

    public String getCoverage() {
        return coverage;
    }

    public Long getHeight() {
        return height;
    }
}
