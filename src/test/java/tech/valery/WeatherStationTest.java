package tech.valery;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.valery.weatherstation.displays.CurrentConditionsDisplay;
import tech.valery.weatherstation.Observer;
import tech.valery.weatherstation.WeatherData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class WeatherStationTest {

    private WeatherData weatherData;

    @BeforeEach
    public void setUp(){
        weatherData = new WeatherData();
    }

    @Test
    public void GivenWeatherStationData_WhenObserverHasAttached_ThenReturnedSizeOfListIs1(){

        Observer currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.registerObserver(currentConditionsDisplay);
        assertEquals(1, weatherData.countObservers());
    }

    @Test
    public void GivenDisplayIsAttached_WhenNotifyObservers_ThenUpdateOnObserverIsCalled(){

        Observer observer = mock(Observer.class);

        weatherData.registerObserver(observer);
        weatherData.notifyObservers();

        verify(observer, times(1)).update();
    }
}
