package ru.kli.view.buttonsEvents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ButtonPresentation implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        int operation = JOptionPane.showConfirmDialog(null, "Начать презентацию?");
        if (operation == 0) {
            JOptionPane.showMessageDialog(null,"НАЧАЛО ПРЕЗЕНТАЦИИ ЗА КОТОРУЮ ДОЛЖНЫ ДОБАВИТЬ 1 БАЛЛ!!!");
            File f = new File("my_data_for_testing/tedting_directory/second/iAsosbpW1mM.jpg");
            Desktop dt = Desktop.getDesktop();
            try {
                dt.open(f);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
