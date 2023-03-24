package ru.kli.view.buttonsEvents;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.kli.controller.FileOperation;
import ru.kli.model.BaseDirectory;
import ru.kli.view.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTree implements ActionListener {
    private static final Logger LOGGER = Logger.getLogger(ButtonTree.class);

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JOptionPane.showMessageDialog(null,FileOperation.getFileOperation()
                    .getDirectoryTrees(BaseDirectory.basePath, ""));
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Измени корневую папку");
            LOGGER.log(Level.ERROR, ex.getMessage());
        }
    }
}
