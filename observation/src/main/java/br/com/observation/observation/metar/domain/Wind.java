package br.com.observation.observation.metar.domain;

public class Wind {

    private Long direction;
    private Long speed;
    private Long gust;
    private WindDirectionVariation windDirectionVariaton;
    
    public Wind(final Long direction, 
                final Long speed,
                final Long gust,
                final WindDirectionVariation windDirectionVariaton) {
        this.direction = direction;
        this.speed = speed;
        this.gust = gust;
        this.windDirectionVariaton = windDirectionVariaton;
    }

    public Long getSpeed() {
        return speed;
    }

    public Long getGust() {
        return gust;
    }

    public WindDirectionVariation getWindDirectionVariaton() {
        return windDirectionVariaton;
    }

    public Long getDirection() {
        return direction;
    }
    
}
