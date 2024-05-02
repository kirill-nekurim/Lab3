package org.example.Operation;

import org.apache.commons.io.FilenameUtils;
import org.example.ReactorStructure;
import org.example.Readers.FileReader;
import org.example.Readers.JSONParser;
import org.example.Readers.XMLParser;
import org.example.Readers.YAMLParser;

import java.io.File;
import java.util.ArrayList;

public class Director {
    private ArrayList<ReactorStructure> list = new ArrayList<>();
    private FileReader XMLfilereader = new XMLParser();
    private FileReader YAMLfilereader = new YAMLParser();
    private  FileReader JSONfilereader = new JSONParser();
    public Director() {
        XMLfilereader.setNextReader(YAMLfilereader);
        YAMLfilereader.setNextReader(JSONfilereader);
    }

    public void setList(File file) {
        if("yaml".equals(FilenameUtils.getExtension(file.getAbsolutePath()))) {
            list = YAMLfilereader.read(file);
        } else if("xml".equals(FilenameUtils.getExtension(file.getAbsolutePath()))) {
            list = XMLfilereader.read(file);
        } else if("json".equals(FilenameUtils.getExtension(file.getAbsolutePath()))) {
            list = JSONfilereader.read(file); }
        else {// Обработать случай неподдерживаемого формата файла
            System.out.println("Неподдерживаемый формат файла!");
            return;
        }
        for (ReactorStructure reactor : list) {
            reactor.setParameters();
        }
    }

    public ArrayList<ReactorStructure> getList() {
        return list;
    }
}
