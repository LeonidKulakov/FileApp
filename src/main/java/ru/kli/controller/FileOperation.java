package ru.kli.controller;

import ru.kli.model.TextContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileOperation {

    private TextContainer textContainer;

    public FileOperation() {
        this.textContainer = new TextContainer();
    }
/**
 * Открывает файл записывая его в TextContainer, но не выводит на экран
 * @param path принимает путь к файлу для открытия
 * */
    public void openFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(path)))
        ) {
            int counterLines = 0;
            StringBuilder sb = new StringBuilder();
            //  str - промежуточная строка, для удобства
            String str = "";

            while (str != null) {
                str = bufferedReader.readLine();
                if (str != null) {
                    sb.append(str).append("\n");
                    counterLines++;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    textContainer.getPages().add(sb.toString());
                }
                if (counterLines >= 10) {
                    sb.deleteCharAt(sb.length() - 1);
                    textContainer.getPages().add(sb.toString());

                    sb.setLength(0);
                    counterLines = 0;
                }
            }
            //TODO в енам
            System.out.println("Файл успешно открыт");
        } catch (FileNotFoundException e) {
            //TODO файл не найден
            throw new RuntimeException(e);
            //TODO ошибка чтения файла
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void documentSearch() {

    }









    public TextContainer getTextContainer() {
        return textContainer;
    }
}
