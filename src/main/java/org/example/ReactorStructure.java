package org.example;

import java.util.ArrayList;

public class ReactorStructure {
    public String filetype;
    public String reactorClass;
    public double burnup;
    public double kpd;
    public double enrichment;
    public int termal_capacity;
    public double electrical_capacity;
    public int life_time;
    public double first_load;
    public ArrayList<String> parameters = new ArrayList<>();

    public void setFileType(String filetype) {
        this.filetype = filetype;
    }
    public void setReactorClass(String type) {
        this.reactorClass = reactorClass;
    }
    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }
    public void setKPD(double kpd) {
        this.kpd = kpd;
    }
    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }
    public void setTCapacity(int TCapacity) {
        this.termal_capacity = TCapacity;
    }
    public void setECapacity(Double ECapacity) {
        this.electrical_capacity = ECapacity;
    }
    public void setLifetime(int lifetime) {
        this.life_time = lifetime;
    }
    public void setFirstload(double firstload) {
        this.first_load = firstload;
    }
    public String getFiletype(){
        return this.filetype;
    }
    public String getReactorClass(){
        return this.reactorClass;
    }
    public double getBurnup() {
        return this.burnup;
    }
    public double getKPD() {
        return this.kpd;
    }
    public double getEnrichment() {
        return this.enrichment;
    }
    public int getTCapacity() {
        return this.termal_capacity;
    }
    public Double getECapacity() {
        return this.electrical_capacity;
    }
    public int getLifetime() {
        return this.life_time;
    }
    public double getFirstload() {
        return this.first_load;
    }
    public void setParameters(){
        parameters.add("Type of file - " + getFiletype());
        parameters.add("Burnup - " + getBurnup());
        parameters.add("KPD - " + getKPD());
        parameters.add("Enrichment   - " + getEnrichment());
        parameters.add("Termal capacity - " + getTCapacity());
        parameters.add("Electrical capacity - " + getECapacity());
        parameters.add("Life time - " + getLifetime());
        parameters.add("First load - " + getFirstload());
    }
    public ArrayList<String> getParameters(){
        return parameters;
    }
}
