package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonShowDate implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (FileOperation.getFileOperation().isFileIsOpen()) {
            String message = "Дата последнего изменения выбранного файла: "
                    + FileOperation.getFileOperation().getDateLastChangeFile();
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "Откройте файл");
        }
    }
}
