package ru.kli.controller;

import ru.kli.model.TextContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileOperation {


    private TextContainer textContainer;

    public FileOperation() {
        this.textContainer = new TextContainer();
    }

    /**
     * Открывает файл записывая его в TextContainer, но не выводит на экран
     *
     * @param path принимает путь к файлу для открытия
     */
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

    //TODO Узнать как перенести функционал во view
    public void findWord(String word) {
        Scanner scanner = new Scanner(System.in);
        int operationNumber = 0;
        int index;

        OUT:
        for (int i = 0; i < textContainer.getPages().size(); i++) {
            index = 0;
            index = textContainer.getPages().get(i).indexOf(word, index);
            while (index != -1) {
                System.out.printf("Слово %s найдено на %d странице, индекс %d", word, (i + 1), index);
                System.out.println("\nИскать дальше 1, отмена поиска (Другое значение)");
                operationNumber = Integer.parseInt(scanner.nextLine());
                if (operationNumber == 1) {
                    index = textContainer.getPages().get(i).indexOf(word, index + word.length());
                } else {
                    System.out.println("Поиск завершен");
                    break OUT;
                }
            }
            System.out.println("Поиск не дал результатов");
        }
    }

    public void replaceWord(String regex, String replacement) {
        String s;
        for (int i = 0; i < textContainer.getPages().size(); i++) {
            s = textContainer.getPages().get(i).replaceAll(regex, replacement);
            textContainer.getPages().set(i, s);
        }
    }

    public Date getDateLastChangeFile(File file) {
        return new Date(file.lastModified());
    }

    public String getFileSizeBytes(File file) {
        return String.valueOf(file.length());
    }

    public void createNewFiles() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи URI файла");
        String uri = scanner.nextLine();
        File file = new File(uri);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //TODO убрать во view, но ХЗ корректно ли это
    public void showAllFile(String dir, String tab) {
        String newTab = tab + "        ";
        File file = new File(dir);
        File file2;
        String[] arr = file.list();
        for (String s : arr) {
            file2 = new File(dir + "/" + s);
            if (file2.isDirectory()) {
                System.out.println(tab + s);
                showAllFile(dir + "/" + s,newTab);
            } else if (file2.isFile()) {
                System.out.println(tab + s);
            }else {
                System.out.println(tab + s);
                tab += "        ";
                showAllFile(dir + "/" + s,newTab);
            }
        }

    }

    public TextContainer getTextContainer() {
        return textContainer;
    }
}
