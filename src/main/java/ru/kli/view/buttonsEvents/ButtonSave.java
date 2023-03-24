package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSave implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (FileOperation.getFileOperation().saveText()){
            JOptionPane.showMessageDialog(null,"Текст сохранен");
        }else {
            JOptionPane.showMessageDialog(null,"Текст не сохранен");
        }
    }
}
