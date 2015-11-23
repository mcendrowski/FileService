/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author MCENDROWSKI
 */
public class Startup {
    public static void main(String[] args) throws IOException {
                // TODO code application logic here
        

        File readFile = new File(File.separatorChar + "temp" + File.separatorChar
                + "Lab5.txt");
        File writeFile = new File(File.separatorChar + "temp" + File.separatorChar
                + "Lab6.csv");
        
        FileService fl = new FileService(readFile,writeFile,new GarageDataFormatter(),new CsvFormatter());
        
        Map<Integer,Map<String, String>> testListMap = fl.decode();        

        
        for (String item: testListMap.get(1).values()){
            System.out.println(item);
        }
        for (String item: testListMap.get(2).values()){
            System.out.println(item);
        }
        
        fl.encode(testListMap);
        
        fl.saveOneRecord(testListMap.get(2));        
        

    }
    

}
