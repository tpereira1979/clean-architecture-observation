package br.com.observation.observation.metar.domain.error;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportWeatherNotificationError {

    private Map<String, String> errors = new HashMap<>();
    
    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addErrors(Map<String, String> errors) {
        this.errors.putAll(errors);
    }

    public void addError(String key, String description) {
        this.errors.put(key, description);
    }

    public boolean hasError() {
        return !errors.isEmpty();
    }

    public String getDescriptionErrors() {
        return this.errors.values()
                               .stream()
                               .collect(Collectors.joining(", "));
    }

    public String getKeyErrors() {
        return errors.keySet()
                     .stream()
                     .collect(Collectors.joining(", "));
    }

    public String getValue(String key) {
        return errors.get(key);
    }
    
}
