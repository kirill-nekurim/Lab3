package org.example.Operation;

import org.example.ReactorStructure;
import org.example.Readers.FileReader;
import org.example.Readers.JSONParser;
import org.example.Readers.XMLParser;
import org.example.Readers.YAMLParser;
import org.example.Repository;

import java.io.File;
import java.util.ArrayList;

public class Director {
    Repository repository = new Repository();
    FileReader XMLfilereader = new XMLParser();
    public Director() {
        FileReader YAMLfilereader = new YAMLParser();
        FileReader JSONfilereader = new JSONParser();
        XMLfilereader.setNextReader(YAMLfilereader);
        YAMLfilereader.setNextReader(JSONfilereader);
    }

    public void setList(File file) {
            repository.setList(XMLfilereader.read(file));
            for (ReactorStructure reactor : repository.getList()){
                reactor.setParameters();
            }

    }

    public ArrayList<ReactorStructure> getList() {
        return repository.getList();
    }
}
