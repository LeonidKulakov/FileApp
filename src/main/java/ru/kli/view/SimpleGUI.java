package ru.kli.view;

import ru.kli.view.buttonsEvents.ButtonCreateFile;
import ru.kli.view.buttonsEvents.ButtonFindWord;
import ru.kli.view.buttonsEvents.ButtonOpenFile;
import ru.kli.view.buttonsEvents.ButtonPresentation;
import ru.kli.view.buttonsEvents.ButtonPush;
import ru.kli.view.buttonsEvents.ButtonReplaceWord;
import ru.kli.view.buttonsEvents.ButtonSave;
import ru.kli.view.buttonsEvents.ButtonSetBaseDirectory;
import ru.kli.view.buttonsEvents.ButtonShowDate;
import ru.kli.view.buttonsEvents.ButtonShowFileSize;
import ru.kli.view.buttonsEvents.ButtonShowPages;
import ru.kli.view.buttonsEvents.ButtonTree;

import java.awt.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    private JButton buttonTree = new JButton("Показать структуру коллекции");
    private JButton buttonOpenFile = new JButton("Открыть документ");
    private JButton buttonFindWord = new JButton("Выполнить поиск по документу");
    private JButton buttonReplaceWord = new JButton("Заменить слово в документе");
    private JButton buttonCreateFile = new JButton("Создание документа");
    private JButton buttonShowDate = new JButton("Посмотреть дату последнего изменения");
    private JButton buttonShowFileSize = new JButton("Посмотреть размер документа");
    private JButton buttonShowPages = new JButton("Посмотреть содержимое документа");
    private JButton buttonSetBaseDirectory = new JButton("Задать корневую папку");
    private JButton buttonSave = new JButton("Сохранить файл");
    private JButton buttonPresentation = new JButton("Старт презентации");
    private JButton buttonPush = new JButton("Нажми меня");
    private JTextField input = new JTextField(null, 5);
    private JLabel label = new JLabel("Поле для ввода корневой папки или файла для открытия");


    public SimpleGUI() {
        super("Hello dummy");
        this.setBounds(400, 200, 800, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 2, 4, 4));
        container.add(label);
        container.add(input);
        buttonTree.addActionListener(new ButtonTree());
        container.add(buttonTree);
        buttonOpenFile.addActionListener(new ButtonOpenFile(this));
        container.add(buttonOpenFile);
        buttonFindWord.addActionListener(new ButtonFindWord());
        container.add(buttonFindWord);
        buttonReplaceWord.addActionListener(new ButtonReplaceWord());
        container.add(buttonReplaceWord);
        buttonCreateFile.addActionListener(new ButtonCreateFile());
        container.add(buttonCreateFile);
        buttonShowDate.addActionListener(new ButtonShowDate());
        container.add(buttonShowDate);
        buttonShowFileSize.addActionListener(new ButtonShowFileSize());
        container.add(buttonShowFileSize);
        buttonShowPages.addActionListener(new ButtonShowPages());
        container.add(buttonShowPages);
        buttonSetBaseDirectory.addActionListener(new ButtonSetBaseDirectory(this));
        container.add(buttonSetBaseDirectory);
        buttonSave.addActionListener(new ButtonSave());
        container.add(buttonSave);
        buttonPresentation.addActionListener(new ButtonPresentation());
        container.add(buttonPresentation);
        buttonPush.addActionListener(new ButtonPush());
        container.add(buttonPush);
    }

    public JTextField getInput() {
        return input;
    }

}