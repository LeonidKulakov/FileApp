package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;
import ru.kli.view.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSetBaseDirectory implements ActionListener {
    private SimpleGUI simpleGUI;

    public ButtonSetBaseDirectory(SimpleGUI simpleGUI) {
        this.simpleGUI = simpleGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,FileOperation.getFileOperation().setBasePath(simpleGUI.getInput().getText()));
    }
}
