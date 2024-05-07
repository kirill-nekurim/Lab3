package org.example;

import java.util.ArrayList;

public class Repository {
    ArrayList<ReactorStructure> list = new ArrayList<>();

    public void setList(ArrayList<ReactorStructure> list) {
        this.list = list;
    }

    public ArrayList<ReactorStructure> getList() {
        return list;
    }
}
