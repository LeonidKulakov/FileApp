package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;
import ru.kli.view.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonReplaceWord implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String word = JOptionPane.showInputDialog(null,"Введи слово для замены");
        String repWord = JOptionPane.showInputDialog(null,"Введи слово новое слово");
        FileOperation.getFileOperation().replaceWord(word,repWord);
        JOptionPane.showMessageDialog(null, "Операция выполнена");
    }
}
