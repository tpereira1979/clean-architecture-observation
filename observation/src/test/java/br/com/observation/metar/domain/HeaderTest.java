package br.com.observation.metar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.observation.observation.metar.domain.Header;
import br.com.observation.observation.metar.domain.ObservationReportType;

public class HeaderTest {

    @Test
    public void shoudAfterTwentyThreeHours() {
        LocalDateTime creationDate = LocalDateTime.of(2022, 11, 14, 19, 00);
        LocalDateTime observationMessage = LocalDateTime.of(2022, 11, 13, 17, 00);
        Header header = new Header(creationDate,
                                   observationMessage,
                                   ObservationReportType.REGULAR,
                                   "SBBR",
                                   Boolean.FALSE);
        assertTrue(header.getErrors().containsKey("observation.message.sent.later"));
    }

    @Test
    public void shoudBeforeTwentyThreeHours() {
        LocalDateTime creationDate = LocalDateTime.of(2022, 11, 14, 19, 00);
        LocalDateTime observationMessage = LocalDateTime.of(2022, 11, 13, 20, 00);
        Header header = new Header(creationDate, 
                                   observationMessage, 
                                   ObservationReportType.REGULAR, 
                                   "SBBR", 
                                   Boolean.FALSE);
        assertFalse(header.getErrors().containsKey("observation.message.sent.later"));
    }

    @Test
    public void shouldObservationReportRegularTypeInvalid() {
        LocalDateTime creationDate = LocalDateTime.of(2022, 11, 14, 19, 20);
        LocalDateTime observationMessage = LocalDateTime.of(2022, 11, 14, 19, 20);
        Header header = new Header(creationDate, 
                                   observationMessage, 
                                   ObservationReportType.REGULAR, 
                                   "SBBR", 
                                   Boolean.FALSE);
        
        assertTrue(header.getErrors().containsKey("observation.message.metar.report.invalid"));
    }

    @Test
    public void shouldObservationReportSpecialTypeInvalid() {
        LocalDateTime creationDate = LocalDateTime.of(2022, 11, 14, 19, 00);
        LocalDateTime observationMessage = LocalDateTime.of(2022, 11, 14, 19, 00);
        Header header = new Header(creationDate, 
                                   observationMessage, 
                                   ObservationReportType.SPECIAL, 
                                   "SBBR", 
                                   Boolean.FALSE);
        
        assertTrue(header.getErrors().containsKey("observation.message.speci.report.invalid"));
    }

    @Test
    public void shouldObservationDateAfterCreateDate() {
        LocalDateTime creationDate = LocalDateTime.of(2022, 11, 14, 19, 00);
        LocalDateTime observationMessage = LocalDateTime.of(2022, 11, 14, 20, 00);
        Header header = new Header(creationDate, 
                                   observationMessage, 
                                   ObservationReportType.REGULAR, 
                                   "SBBR", 
                                   Boolean.FALSE);
        
        assertTrue(header.getErrors().containsKey("observation.message.datehour.before.create"));
    }
}
