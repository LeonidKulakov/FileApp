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
            JOptionPane.showMessageDialog(null
                    ,"НАЧАЛО ПРЕЗЕНТАЦИИ ЗА КОТОРУЮ ДОЛЖНЫ ДОБАВИТЬ 1 БАЛЛ!!!");
            JOptionPane.showMessageDialog(null
                    ,"Я прикрутил Swing просто по приколу, надоели консольные приложения");
            openImage("my_data_for_testing/tedting_directory/second/java-logo (1).jpg");
            JOptionPane.showMessageDialog(null
                    ,"Конец презентации. Спасибо за внимание!");
            openImage("my_data_for_testing/tedting_directory/second/iAsosbpW1mM.jpg");
        }
    }

    private void openImage(String path){
        File f = new File(path);
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(f);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
