package br.com.observation.observation.metar.domain;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.observation.observation.metar.domain.error.ReportWeatherNotificationError;

public class Header {

    private ReportWeatherNotificationError notification;
    private LocalDateTime observationDateHour;
    private LocalDateTime creationDate;
    private Location origin;
    private ObservationReportType observationReportType;
    private Boolean correction = Boolean.FALSE;
    

    public Header(final LocalDateTime creationDate,
                  final LocalDateTime observationDateHour,
                  final ObservationReportType observationReportType,
                  final String origin,
                  final Boolean correction) {
        if (creationDate == null) throw new IllegalArgumentException("Campo da data da criacao esta vazio");
        if (observationDateHour == null) throw new IllegalArgumentException("Campo data observacao nao pode estar vazio");
        if (origin == null) throw new IllegalArgumentException("O campo localidade esta vazio");
        if (observationReportType == null) throw new IllegalArgumentException("O tipo do report nao pode estar vazio");
        this.creationDate = creationDate;
        this.origin = new Location(origin);
        this.observationReportType = observationReportType;
        this.correction = correction;
        this.observationDateHour = observationDateHour;
        this.notification = new ReportWeatherNotificationError();
        this.validate();
    }
    
    private void validate() {        
        isObservationAfterTwentyThreeHoursValid();
        isObservationReportTypeValid();
        isObservationIsBeforeCreationDate();
    }
   
    public Map<String, String> getErrors() {
        return this.notification.getErrors();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Location getOrigin() {
        return origin;
    }

    public Boolean isCorrection() {
        return this.correction;
    }    
    
    public ObservationReportType getObservationReportType() {
        return observationReportType;
    }

    private void isObservationAfterTwentyThreeHoursValid() {
        LocalDateTime createDateHourLimited = this.creationDate.minusHours(23);
        boolean isNotAllowed = this.observationDateHour.isBefore(createDateHourLimited);
        if (isNotAllowed) notification.addError("observation.message.sent.later", "Mensagem de observação não pode ser enviada com mais de 23 horas de atraso");
    }

    private void isObservationReportTypeValid() {
        boolean observationSpecialTypeInvalid = ObservationReportType.SPECIAL.equals(this.observationReportType) && 
                                        this.observationDateHour.getMinute() == 0;
        boolean observationRegularTypeInvalid = ObservationReportType.REGULAR.equals(this.observationReportType) &&
                                        this.observationDateHour.getMinute() > 0;
        if (observationSpecialTypeInvalid) notification.addError("observation.message.speci.report.invalid", 
                                                                 "Não é permitido registrar observação especial em hora cheia");
        if (observationRegularTypeInvalid) notification.addError("observation.message.metar.report.invalid", 
                                                                 "Somente é permitido registrar observaçao regular em hora cheia");
    }

    private void isObservationIsBeforeCreationDate() {
        if (this.observationDateHour.isAfter(this.creationDate)) notification.addError("observation.message.datehour.before.create", 
                                                                                        "A data da observação nao pode ser maior que data que esta criando a mensagem");
    }
    
}
