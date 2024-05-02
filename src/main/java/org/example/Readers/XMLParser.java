package org.example.Readers;

import org.apache.commons.io.FilenameUtils;
import org.example.ReactorStructure;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLParser extends FileReader{

    @Override
    public ArrayList<ReactorStructure> read(File file) {
        ArrayList<ReactorStructure> list;
        if("xml".equals(FilenameUtils.getExtension(file.getAbsolutePath()))){
            list = readXML(file);
            for (ReactorStructure reactor : list){
                reactor.setFileType("XML");
            }
            return list;
        } else if(nextReader != null){
            return nextReader.read(file);
        }
        return null;
    }

    private ArrayList<ReactorStructure> readXML(File file) {
        ArrayList<ReactorStructure> list = new ArrayList<>();
        ReactorStructure reactor = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // проходим по всем элементам xml файла
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new
                    FileInputStream(file.getAbsolutePath()));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "Reactor" -> {
                            reactor = new ReactorStructure();
                        }
                        case "class" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setReactorClass(xmlEvent.asCharacters().getData());
                        }
                        case "burnup" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setBurnup(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        }
                        case "kpd" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setKPD(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        }
                        case "enrichment" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setEnrichment(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        }
                        case "termal_capacity" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setTCapacity(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                        case "electrical_capacity" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setECapacity(Double.valueOf(xmlEvent.asCharacters().getData()));
                        }
                        case "life_time" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setLifetime(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                        case "first_load" -> {
                            xmlEvent = reader.nextEvent();
                            reactor.setFirstload(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        }
                        default -> {
                        }
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Reactor")) {
                        list.add(reactor);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException exc) {
        }
        return list;
    }
}
