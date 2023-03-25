package ru.kli.view.buttonsEvents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ButtonPush implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Просили салют, вот вам салют!");
        File f = new File("my_data_for_testing/tedting_directory/second/MediumUnnaturalAfricanfisheagle-max-1mb.gif");
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(f);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
