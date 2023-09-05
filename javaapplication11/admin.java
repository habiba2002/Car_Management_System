package javaapplication11;

import com.opencsv.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class admin extends car1 {

    static String username = "admin";
    static String password = "admin";
    JFrame jframe;
    public void add(String chassis, String model, String color, String price, String year, String manufacturer) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv", true))) {
            String stat = chassis + "," + model + "," + color + "," + price + "," + year + "," + manufacturer;
            String[] record = stat.split(",");
            writer.writeNext(record);
            JOptionPane.showMessageDialog(jframe, "Add car successfully");
        } catch (IOException io) {
            JOptionPane.showMessageDialog(jframe, io.getMessage());
        }

    }

    public void edit(String search, String replacment) throws FileNotFoundException, IOException {
        CSVReader r = new CSVReader(new FileReader("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv"));
        List<String[]> allelements = r.readAll();
        int row = rownum(search);
        String[] a = allelements.get(row - 1);
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(search)) {
                a[i] = replacment;
            }
        }
        allelements.set(row - 1, a);
        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Mostafa_Eltokhy\\Desktop\\cars.csv"));
        writer.writeAll(allelements);
        writer.close();
        JOptionPane.showMessageDialog(jframe, "Edit car successfully");
    }

    @Override
    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            JOptionPane.showMessageDialog(jframe, "welcome Boss");
        } else {
            JOptionPane.showMessageDialog(jframe, "you are not an admin");
        }

    }
}
