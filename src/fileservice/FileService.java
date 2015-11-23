/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MCENDROWSKI
 */
public class FileService {

    /**
     * @param args the command line arguments
     */
   
    File readFile;
    File writeFile;
    FormatStrategy input;
    FormatStrategy output;

    public FileService(File readFile, File writeFile, FormatStrategy input,FormatStrategy output) {
        this.readFile = readFile;
        this.writeFile = writeFile;
        this.input = input;
        this.output = output;
    }
    
    public Map<Integer,Map<String,String>> decode() throws IOException{
        return input.decode(readFileLines());
    }
    
    
     public List<String> readFileLines() throws IOException {
        List<String> lines = new ArrayList<>();
        
//        File file = new File(this.readFile);
        BufferedReader in = new BufferedReader(new FileReader(this.readFile));
	   String line = in.readLine();
	   while(line != null){
		  lines.add(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
        
        return lines;
    }
     
public void saveOneRecord(Map<String,String> newRecord) throws IOException{
    boolean append = true;
    
    PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(this.writeFile, append)));
     for (String line: output.encodeOneRecord(newRecord)){
            out.println(line);
        }
     out.close();
    
}
     
       public void encode(Map<Integer,Map<String,String>> mapOfRecords) throws IOException {
        boolean append = false;

//        File file2 = new File(File.separatorChar + "temp" + File.separatorChar
//                + "Lab1.txt");

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(this.writeFile, append)));

        for (String line: output.encode(mapOfRecords)){
            out.println(line);
        }


        out.close();
    }
     
 
    
    
}
