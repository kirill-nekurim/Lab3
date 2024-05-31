package org.example.Operation;
import org.example.ReactorDB;

import java.util.ArrayList;

public class Calculator {
    public void calculateFuelLoad(ArrayList<ReactorDB> reactors) {

        for (ReactorDB reactor : reactors) {
                int year = 2014;
                while (year < 2025) {
                    double fuelLoad = 0;
                    if (reactor.getLoadFactor().containsKey(year)) {
                        fuelLoad = reactor.getThermalCapacity() * reactor.getLoadFactor().get(year) / 100 / reactor.getReactorClass().getBurnup();
                    } else if (reactor.getShutdownYear() >= year & reactor.getConnectionYear() <= year) {
                        fuelLoad = reactor.getThermalCapacity() * 85 / 100 / reactor.getReactorClass().getBurnup();
                    }
                    reactor.getFuelLoad().put(year, fuelLoad);
                    year++;
                }


        }
    }
}
