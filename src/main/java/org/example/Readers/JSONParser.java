package org.example.Readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ReactorStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
public class JSONParser extends FileReader{

    @Override
    public ArrayList<ReactorStructure> read(File file) {
        ArrayList<ReactorStructure> list;
if("json".equals(FilenameUtils.getExtension(file.getAbsolutePath()))){
try{
    list = readJSON(file);
    for(ReactorStructure reactor : list){
        reactor.setFileType("JSON");
    }
    return list;
} catch (IOException e){
    e.printStackTrace();
}
}
else if(nextReader != null){
    return nextReader.read(file);
}
return null;
    }

    private ArrayList<ReactorStructure> readJSON(File file) throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<ReactorStructure> list = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, ReactorStructure.class));
        return list;
        }
}
