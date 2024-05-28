package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ReactorDB {
    private String name;
    private ReactorStructure type;
    private String country;
    private String operator;
    private String owner;
    private int thermalCapacity;
    private String region;
    private int shutdownYear;
    private int connectionYear;
    private Map<Integer, Double> loadFactor;
    private Map<Integer, Double> fuelLoad = new HashMap<>();

    public int getConnectionYear() {
        return connectionYear;
    }
    public void setConnectionYear(int connectionYear) {
        this.connectionYear = connectionYear;
    }
    public int getShutdownYear() {
        return shutdownYear;
    }
    public void setShutdownYear(int shutdownYear) {
        this.shutdownYear = shutdownYear;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReactorStructure getReactorClass() {
        return type;
    }
    public void setType(String type_name, ArrayList<ReactorStructure> reactorTypes) {
        chooseType(type_name, reactorTypes);
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getThermalCapacity() {
        return thermalCapacity;
    }
    public void setThermalCapacity(int thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public Map<Integer, Double> getLoadFactor() {
        return loadFactor;
    }
    public void setLoadFactor(Map<Integer, Double> loadFactor) {
        this.loadFactor = loadFactor;
    }
    public Map<Integer, Double> getFuelLoad() {
        return fuelLoad;
    }
    public void setFuelLoad(Map<Integer, Double> fuelLoad) {
        this.fuelLoad = fuelLoad;
    }

    private void chooseType(String type_name, ArrayList<ReactorStructure> reactorTypes){
        switch (type_name) {
            case "PWR" ->
                findType(reactorTypes, "PWR");
            case "PHWR" ->
                    findType(reactorTypes, "PHWR");
            case "BWR" ->
                    findType(reactorTypes, "BWR");
            case "LWGR" ->
                    findType(reactorTypes, "RBMK");
            case "GCR" ->
                    findType(reactorTypes, "MAGNOX");
            case "FBR" ->
                    findType(reactorTypes, "BN");
            case "RBMK" ->
                    findType(reactorTypes, "RBMK");
            case "VVER" ->
                    findType(reactorTypes, "VVER-1200");
        }
    }

    private void findType(ArrayList<ReactorStructure> reactorTypes, String typeName) {
        for (ReactorStructure type : reactorTypes) {
            if (typeName.equals(type.getReactorClass())) {
                this.type = type;
                break;
            }
        }
    }
}
