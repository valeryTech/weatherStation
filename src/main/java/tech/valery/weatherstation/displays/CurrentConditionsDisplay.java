package tech.valery.weatherstation.displays;

import tech.valery.weatherstation.Display;
import tech.valery.weatherstation.Observer;
import tech.valery.weatherstation.WeatherData;

public class CurrentConditionsDisplay implements Observer, Display {

    private WeatherData weatherData;

    private double temperature;
    private double pressure;
    private double humidity;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.pressure = weatherData.getPressure();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and" + humidity + "% humidity");
    }
}
