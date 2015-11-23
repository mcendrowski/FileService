/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MCENDROWSKI
 */
public class GarageDataFormatter implements FormatStrategy {

    public GarageDataFormatter() {
    }

    private List<List<String>> convertLinesToRecords(List<String> listOfLines) {
        int lineCounter = 0;
        int recordCounter = 0;
        List<String> listOfOneRecord = new ArrayList<>();
        int linesInOneRecord = 1;
        List<List<String>> listOfRecords = new ArrayList<>();

//        for (String line : listOfLines) {
//            lineCounter++;
//            listOfOneRecord.add(line);
//            if (lineCounter == linesInOneRecord) {
//                listOfRecords.add(listOfOneRecord);
//                listOfOneRecord = new ArrayList<>();
//                lineCounter = 0;
//            }
//
//        }
        String line = listOfLines.get(lineCounter);

        while (!"".equals(line)) {
            lineCounter++;
            recordCounter++;
            listOfOneRecord.add(line);
            if (recordCounter == linesInOneRecord) {
                listOfRecords.add(listOfOneRecord);
                listOfOneRecord = new ArrayList<>();
                recordCounter = 0;
            }
            line = listOfLines.get(lineCounter);
        }

        return listOfRecords;
    }

    @Override
    public List<String> encode(Map<Integer, Map<String, String>> mapOfRecords) {
        List<String> listOfLines = new ArrayList<>();
        for (Map<String, String> mapOfSingleRecord : mapOfRecords.values()) {
            listOfLines.add(mapOfSingleRecord.get("hours") + " " + mapOfSingleRecord.get("fees"));
        }
        return listOfLines;
    }

    @Override
    public List<String> encodeOneRecord(Map<String, String> oneRecord) {
        List<String> listOfLines = new ArrayList<>();
        listOfLines.add(oneRecord.get("hours") + " " + oneRecord.get("fees"));
        return listOfLines;
    }

    @Override
    public Map<Integer, Map<String, String>> decode(List<String> listOfLines) {

        List<List<String>> listOfRecords = convertLinesToRecords(listOfLines);
        Map<String, String> mapOfSingleTicket;
        Map<Integer, Map<String, String>> mapOfTickets = new HashMap<>();
        String[] array;
        int counter = 1;
        for (List<String> record : listOfRecords) {
            mapOfSingleTicket = new HashMap<>();
            array = record.get(0).split(" ");
            mapOfSingleTicket.put("hours", array[0]);
            mapOfSingleTicket.put("fees", array[1]);
            mapOfTickets.put(counter, mapOfSingleTicket);
            counter++;
        }

        return mapOfTickets;
    }

//    private ArrayList stringToArray(String dataLines){
//        
//    }
    public static void main(String[] args) {

//        List<String> testList = new ArrayList<>();
//        testList.add("10.00");
//        testList.add("20.00");
//        
//        for(String item:testList){
//            System.out.println(item);
//        }
//        String dataLines = "20.00 10.00";
//        List<Map<String, String>> testListMap=decode("20.00 10.00"); // = new ArrayList<>();
//        testListMap=decode("20.00 10.00");
    }

}
