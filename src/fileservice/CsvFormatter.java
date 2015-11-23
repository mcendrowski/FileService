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
public class CsvFormatter implements FormatStrategy {

    public CsvFormatter() {
    }



    @Override
    public List<String> encode(Map<Integer, Map<String, String>> mapOfRecords) {
        List<String> listOfLines = new ArrayList<>();
        for (Map<String, String> mapOfSingleRecord : mapOfRecords.values()) {
            listOfLines.add(mapOfSingleRecord.get("hours") + "," + mapOfSingleRecord.get("fees"));
        }
        return listOfLines;
    }

    @Override
    public List<String> encodeOneRecord(Map<String, String> oneRecord) {
        List<String> listOfLines = new ArrayList<>();
        listOfLines.add(oneRecord.get("hours") + "," + oneRecord.get("fees"));
        return listOfLines;
    }

    @Override
    public Map<Integer, Map<String, String>> decode(List<String> listOfLines) {

        List<String> listOfRecords = listOfLines;
        Map<String, String> mapOfSingleRecord;
        Map<Integer, Map<String, String>> mapOfTickets = new HashMap<>();
        String[] array;
        int counter = 1;
        for (String record : listOfRecords) {
            mapOfSingleRecord = new HashMap<>();
            array = record.split(",");
            mapOfSingleRecord.put("hours", array[0]);
            mapOfSingleRecord.put("fees", array[1]);
            mapOfTickets.put(counter, mapOfSingleRecord);
            counter++;
        }

        return mapOfTickets;
    }





}
