package ru.kli.view.buttonsEvents;

import ru.kli.controller.FileOperation;
import ru.kli.view.SimpleGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonFindWord implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (FileOperation.getFileOperation().isFileIsOpen()) {
            String word = JOptionPane.showInputDialog(null,"Введи слово для поиска");
            ArrayList<Integer> indexAndPage = FileOperation.getFileOperation().findWord(word);
            if (indexAndPage.size() != 0) {
                var sb = new StringBuilder();
                for (int i = 0; i < indexAndPage.size(); i = i + 2) {
                    sb.append("\nСлово найдено на "
                            + (indexAndPage.get(i) + 1)
                            + "странице, индекс "
                            + (indexAndPage.get(i + 1))+"\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Поиск не дал результатов");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Откройте файл");
        }
    }
}
