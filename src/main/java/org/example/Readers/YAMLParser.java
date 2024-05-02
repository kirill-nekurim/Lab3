package org.example.Readers;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.io.FilenameUtils;
import org.example.ReactorStructure;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.lang.reflect.Type;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YAMLParser extends FileReader {

    @Override
    public ArrayList<ReactorStructure> read(File file) {
        ArrayList<ReactorStructure> list;
        if("json".equals(FilenameUtils.getExtension(file.getAbsolutePath()))){
            try{
                list = readYAML(file);
                for(ReactorStructure reactor : list){
                    reactor.setFileType("YAML");
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

    private ArrayList<ReactorStructure> readYAML(File file) throws IOException, FileNotFoundException {
Map<String, ReactorStructure> map = null;
try{
    YAMLMapper mapper = new YAMLMapper();
    map = mapper.readValue(file, new TypeReference<Map<String, ReactorStructure>>(){

    });
} catch (IOException e){
    Logger.getLogger(YAMLParser.class.getName()).log(Level.SEVERE, null, e);
}
ArrayList<ReactorStructure> list = new ArrayList<>(map.values());
return list;
    }
}
