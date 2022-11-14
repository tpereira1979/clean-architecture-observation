package br.com.observation.observation.metar.domain.error;

public class ReportWeatherInformationError {

    private String key;
    private String description;

    public ReportWeatherInformationError(final String key, final String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
