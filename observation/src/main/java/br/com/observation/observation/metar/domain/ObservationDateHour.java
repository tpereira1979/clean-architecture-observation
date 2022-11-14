package br.com.observation.observation.metar.domain;

import java.time.LocalDateTime;

import br.com.observation.observation.metar.domain.error.ReportWeatherNotificationError;

public class ObservationDateHour {

    private ReportWeatherNotificationError notification;
    private LocalDateTime dateHour;

    public ObservationDateHour(final LocalDateTime dateHour) {
        if (dateHour == null) throw new IllegalArgumentException("O campo de data de observacao nao pode esta vazio");
        this.dateHour = dateHour;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }
    
}
