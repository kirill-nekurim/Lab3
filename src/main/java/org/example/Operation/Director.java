package org.example.Operation;

import org.example.ReactorStructure;
import org.example.Readers.FileReader;
import org.example.Readers.JSONParser;
import org.example.Readers.XMLParser;
import org.example.Readers.YAMLParser;
import org.example.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Director {
    Repository repository = new Repository();
    private Calculator calculator = new Calculator();
    private Distributor distributor = new Distributor();
    FileReader XMLfilereader = new XMLParser();
    public Director() {
        FileReader YAMLfilereader = new YAMLParser();
        FileReader JSONfilereader = new JSONParser();
        XMLfilereader.setNextReader(YAMLfilereader);
        YAMLfilereader.setNextReader(JSONfilereader);
    }
    public void setList(File file) {
            repository.setList(XMLfilereader.read(file));
            for (ReactorStructure reactor : repository.getReactorTypes()){
                reactor.setParameters();
            }

    }
    public ArrayList<ReactorStructure> getList() {
        return repository.getReactorTypes();
    }

    public void readDatabase() {
        DBReader reader = new DBReader();
        if (repository.getReactorTypes() != null) {
            repository.setReactors(reader.readDB(repository.getReactorTypes()));
            calculator.calculateFuelLoad(repository.getReactors());
        } else {
            System.out.println("Сначала прочитайте типы реакторов!");
        }
    }
    public Map<String, Map<Integer, Double>> aggregateByOperator() {
        if (repository.getReactors() != null) {
            return distributor.aggregateByOperator(repository.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }
    public Map<String, Map<Integer, Double>> aggregateByCountry() {
        if (repository.getReactors() != null) {
            return distributor.aggregateByCountry(repository.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }
    public Map<String, Map<Integer, Double>> aggregateByRegion() {
        if (repository.getReactors() != null) {
            return distributor.aggregateByRegion(repository.getReactors());
        } else {
            System.out.println("Сначала прочитайте БД!");
            return null;
        }
    }
}
