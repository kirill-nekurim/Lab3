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

}
