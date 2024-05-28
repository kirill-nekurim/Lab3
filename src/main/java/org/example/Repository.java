package org.example;

import java.util.ArrayList;

public class Repository {
    ArrayList<ReactorStructure> list = new ArrayList<>();
    private ArrayList<ReactorDB> reactors;
    public ArrayList<ReactorDB> getReactors() {
        return reactors;
    }
    public void setReactors(ArrayList<ReactorDB> reactors) {
        this.reactors = reactors;
    }
    public void setList(ArrayList<ReactorStructure> list) {
        this.list = list;
    }

    public ArrayList<ReactorStructure> getReactorTypes() {
        return list;
    }

}
