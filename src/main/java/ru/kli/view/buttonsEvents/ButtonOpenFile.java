package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;
import ru.kli.view.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonOpenFile implements ActionListener {
    private SimpleGUI simpleGUI;

    public ButtonOpenFile(SimpleGUI simpleGUI) {
        this.simpleGUI = simpleGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (FileOperation.getFileOperation().openFile(simpleGUI.getInput().getText()))
            JOptionPane.showMessageDialog(null,"\nФайл успешно открыт");
        else
            JOptionPane.showMessageDialog(null,"\nФайл не открыт");
    }
}
