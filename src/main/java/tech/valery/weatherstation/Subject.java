package tech.valery.weatherstation;

public interface Subject {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);

    void notifyObservers();

    int countObservers();
}
