package br.com.observation.metar.domain.error;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.observation.observation.metar.domain.error.ReportWeatherInformationError;
import br.com.observation.observation.metar.domain.error.ReportWeatherNotificationError;

public class ReportWeatherNotificationErrorTest {

    @Test
    public void shouldCreateNotificationError(){
        ReportWeatherNotificationError errors = new ReportWeatherNotificationError();
        errors.addError("observation.message.sent.later", 
        "Mensagem de observação não pode ser enviada com mais de 23 horas de atraso");
        errors.addError("observation.message.sent.early", 
        "Observação regular só pode ser enviado com 5 minutos de adiantamento");
        
        assertEquals("Mensagem de observação não pode ser enviada com mais de 23 horas de atraso", 
        errors.getValue("observation.message.sent.later"));
        assertEquals("Mensagem de observação não pode ser enviada com mais de 23 horas de atraso, Observação regular só pode ser enviado com 5 minutos de adiantamento", errors.getDescriptionErrors());
        assertEquals("observation.message.sent.later, observation.message.sent.early", errors.getKeyErrors());
    }

   
}
