package ru.kli.view.buttonsEvents;

import org.apache.log4j.Level;
import ru.kli.controller.FileOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ButtonShowPages implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "В файле "
                + FileOperation.getFileOperation().getFileModel().getPages().size()
                + " страниц, укажите какую открыть";
        String pageNumber = JOptionPane.showInputDialog(null, message);
        try {
            int pageN = Integer.parseInt(pageNumber);
            JOptionPane.showMessageDialog(null
                    , FileOperation.getFileOperation().showFileText(pageN));
            switchPages(pageN);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Не корректный ввод");
        }
    }

    private static void switchPages(int pageN) {
        int operation = 0;
        while (operation == 0 || operation == 1) {
            operation = JOptionPane.showConfirmDialog(null, "Показать следующую страницу?");
            if (operation == 1) {
                operation = JOptionPane.showConfirmDialog(null, "Показать предыдущую страницу?");
                if (operation == 0) {
                    JOptionPane.showMessageDialog(null
                            , FileOperation.getFileOperation().showFileText(--pageN));
                }
            } else if (operation == 0) {
                JOptionPane.showMessageDialog(null
                        , FileOperation.getFileOperation().showFileText(++pageN));
            }
        }
    }
}
