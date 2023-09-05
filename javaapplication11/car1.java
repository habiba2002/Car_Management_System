/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import com.opencsv.*;
import edu.duke.FileResource;
import java.io.*;
import java.util.*;

/**
 *
 * @author Mostafa_Eltokhy
 */
public abstract class car1 {

    public abstract void login(String username, String password);

    public ArrayList search(String word) {
        String search = word;
        ArrayList<String> al = new ArrayList<String>();
        FileResource fr = new FileResource("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv");
        for (String s : fr.lines()) {
            if ('\"' == s.charAt(0)) {
                search = "\"" + word + "\"";
            }
            String[] line = s.split(",");
            for (String l : line) {
                if (search.equals(l)) {
                    al.add(s);
                }
            }
        }
        return al;
    }

    public String[] display(String word, int index) {
        String[] stat = null;
        ArrayList<String> al = search(word);
        stat = al.get(index).split(",");
        return stat;
    }

    public Boolean removeCar(String search) throws FileNotFoundException, IOException {
        if (search.charAt(0) == '\"') {
            search = search.substring(1, search.length() - 1);
        }
        CSVReader r = new CSVReader(new FileReader("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv"));
        List<String[]> allelements = r.readAll();
        int row = rownum(search);
        allelements.remove(row - 1);
        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv"));
        writer.writeAll(allelements);
        writer.close();
        return true;

    }

    public int rownum(String word) {
        String search = word;
        int numOfline = 0;
        int count = 0;
        FileResource fr = new FileResource("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv");
        for (String s : fr.lines()) {
            if ('\"' == s.charAt(0)) {
                search = "\"" + word + "\"";
            }
            String[] line = s.split(",");
            count++;
            if (numOfline == 0) {
                for (String l : line) {
                    if (search.equals(l)) {
                        numOfline = count;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return numOfline;
    }
}
