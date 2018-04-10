package tech.valery.weatherstation;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private double temperature;
    private double pressure;
    private double humidity;

    private List<Observer> observerList = new ArrayList<>();

    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    public void deregisterObserver(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers() {
        for (Observer o :
               observerList ) {
            o.update();
        }
    }

    public int countObservers() {
        return observerList.size();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(double temperature, double pressure, double humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        measurementsChanged();

    }

}
