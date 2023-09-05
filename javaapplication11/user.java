package javaapplication11;

import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class user extends car1 {

    static HashMap<String, ArrayList<String>> records = new HashMap<String, ArrayList<String>>();
    JFrame jframe;

    public void register(String user_name, String name, String password, String address, String phonenumber) {
        ArrayList<String> al = new ArrayList<String>();
        al.add(name);
        al.add(address);
        al.add(phonenumber);
        al.add(password);
        records.put(user_name, al);
        JOptionPane.showMessageDialog(jframe, "Successfuly register");
    }

    @Override
    public void login(String username, String password) {
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(jframe, "please register");
        } else {
            for (String i : records.keySet()) {
                if (username.equals(i)) {
                    if (password.equals(records.get(i).get(3))) {
                        JOptionPane.showMessageDialog(jframe, "succefuly login!");
                    } else {
                        JOptionPane.showMessageDialog(jframe, "wrong password");
                    }
                } else {
                    JOptionPane.showMessageDialog(jframe, "please register");
                }
            }
        }
    }
}
