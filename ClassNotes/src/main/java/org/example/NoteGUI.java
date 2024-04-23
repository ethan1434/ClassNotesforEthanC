package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteGUI extends JFrame{
    JPanel mainPanel;
    JPanel dataPanel;
    JPanel resultPanel;

    JComboBox amountOfOwners;
    JComboBox amountOfDogs;
    JButton resultButton;
    JLabel totalDogs;

    NoteGUI() {
        setTitle("Dogs in the dog park");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dogNumber = String.valueOf(amountOfDogs.getSelectedItem());
                String peopleNumber = String.valueOf(amountOfOwners.getSelectedItem());

                int dogTotal = Integer.parseInt(dogNumber) * Integer.parseInt(peopleNumber);

                String dogPlural;
                if(dogTotal == 1){
                    dogPlural = " dog";
                } else {
                    dogPlural = " dogs";
                }
                totalDogs.setText(dogTotal + dogPlural);
            }
        });
    }
}
