package org.example.Readers;

import java.io.File;
import java.util.ArrayList;

import org.example.ReactorStructure;

public abstract class FileReader {
    public FileReader nextReader;
    public void setNextReader(FileReader nextReader){
        this.nextReader = nextReader;
    }
    public abstract ArrayList<ReactorStructure> read(File file);

}
