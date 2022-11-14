package br.com.observation.observation.metar.domain;

import java.util.List;

import br.com.observation.observation.metar.domain.error.ReportWeatherNotificationError;

public class ReportWeatherInformation {

    private Header header;
    private Location location;
    private ObservationDateHour observationDateHour;
    private Wind wind;
    private Visibility visibility;
    private List<RunwayVisualRange> rvrs;
    private List<WeatherCondition> weatherConditions;
    private List<CloudLayer> cloudLayer;
    private Temperature airTemperature;
    private AtmosphericPressure qnh;
    private Remark remark;
    
    public ReportWeatherNotificationError validate() {
        ReportWeatherNotificationError notification = new ReportWeatherNotificationError();
        notification.addErrors(this.header.getErrors());
        return notification;
    }

    public Header getHeader() {
        return header;
    }
  

    public Location getLocation() {
        return location;
    }

    public ObservationDateHour getObservationDateHour() {
        return observationDateHour;
    }

    public Wind getWind() {
        return wind;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public List<RunwayVisualRange> getRvrs() {
        return rvrs;
    }

    public List<WeatherCondition> getWeatherConditions() {
        return weatherConditions;
    }

    public List<CloudLayer> getCloudLayer() {
        return cloudLayer;
    }

    public Temperature getAirTemperature() {
        return airTemperature;
    }

    public AtmosphericPressure getQnh() {
        return qnh;
    }
    
    public Remark getRemark() {
        return remark;
    }
            
}
