package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCreateFile implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = JOptionPane.showInputDialog(null,"Введи имя файла");
        if (FileOperation.getFileOperation().createNewFiles(fileName))
            JOptionPane.showMessageDialog(null, "Файл создан");
        else
            JOptionPane.showMessageDialog(null, "Файл не создан");
    }
}
