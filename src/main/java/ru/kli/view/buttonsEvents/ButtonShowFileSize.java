package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonShowFileSize implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (FileOperation.getFileOperation().isFileIsOpen()) {
            String message = "Размер выбранного файла: " + FileOperation.getFileOperation().getFileSizeBytes() + " byte";
            JOptionPane.showMessageDialog(null,message);
        } else {
            JOptionPane.showMessageDialog(null,"Откройте файл");
        }
    }
}
