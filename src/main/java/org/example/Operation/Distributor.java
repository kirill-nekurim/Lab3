package org.example.Operation;
import org.example.ReactorDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Distributor {
    Map<String, Map<Integer, Double>> aggregateByOperator(ArrayList<ReactorDB> reactors) {
        Map<String, Map<Integer, Double>> map = new HashMap<>();
        for (ReactorDB reactor : reactors) {
            if (map.containsKey(reactor.getOperator())) {
                Map<Integer, Double> fuelLoad = map.get(reactor.getOperator());
                for (int year = 2014; year < 2025; year++) {
                    fuelLoad.put(year, reactor.getFuelLoad().get(year) + fuelLoad.get(year));
                }
            } else {
                map.put(reactor.getOperator(), new HashMap<>());
                Map<Integer, Double> fuelLoad = map.get(reactor.getOperator());
                fuelLoad.putAll(reactor.getFuelLoad());
            }
        }
        return map;
    }

    Map<String, Map<Integer, Double>> aggregateByCountry(ArrayList<ReactorDB> reactors) {
        Map<String, Map<Integer, Double>> map = new HashMap<>();
        for (ReactorDB reactor : reactors) {
            if (map.containsKey(reactor.getCountry())) {
                Map<Integer, Double> fuelLoad = map.get(reactor.getCountry());
                for (int year = 2014; year < 2025; year++) {
                    fuelLoad.put(year, reactor.getFuelLoad().get(year) + fuelLoad.get(year));
                }
            } else {
                map.put(reactor.getCountry(), new HashMap<>());
                Map<Integer, Double> fuelLoad = map.get(reactor.getCountry());
                fuelLoad.putAll(reactor.getFuelLoad());
            }
        }
        return map;
    }

    Map<String, Map<Integer, Double>> aggregateByRegion(ArrayList<ReactorDB> reactors) {
        Map<String, Map<Integer, Double>> map = new HashMap<>();
        for (ReactorDB reactor : reactors) {
            if (map.containsKey(reactor.getRegion())) {
                Map<Integer, Double> fuelLoad = map.get(reactor.getRegion());
                for (int year = 2014; year < 2025; year++) {
                    fuelLoad.put(year, reactor.getFuelLoad().get(year) + fuelLoad.get(year));
                }
            } else {
                map.put(reactor.getRegion(), new HashMap<>());
                Map<Integer, Double> fuelLoad = map.get(reactor.getRegion());
                fuelLoad.putAll(reactor.getFuelLoad());
            }
        }
        return map;
    }
}
