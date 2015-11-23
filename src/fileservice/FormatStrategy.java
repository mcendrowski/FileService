/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MCENDROWSKI
 */
public interface FormatStrategy {
    public abstract List<String> encode(Map<Integer,Map<String,String>> list);
    public abstract Map<Integer,Map<String,String>> decode(List<String> listOfLines); //(List<String> list);
//    public abstract List<Map<String,String>> decode(); //(String str);

    public abstract List<String> encodeOneRecord(Map<String, String> oneRecord);
    
}
