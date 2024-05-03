package org.example;



import java.util.ArrayList;

public class Repository {
    ArrayList<ReactorStructure> list = new ArrayList<>();

    public void setList(ArrayList<ReactorStructure> rlist) {
        list = rlist;
    }

    public ArrayList<ReactorStructure> getList() {
        return list;
    }
}
