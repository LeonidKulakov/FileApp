package ru.kli.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.kli.model.BaseDirectory;
import ru.kli.model.FileModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileOperation {
    private static final Logger LOGGER = Logger.getLogger(FileOperation.class);
    public static final int MAX_OPERATION = 9;
    StringBuilder builder = new StringBuilder();
    private boolean fileIsOpen;
    public static final String TAB = "        ";
    private FileModel fileModel;

    public FileOperation() {
        this.fileModel = new FileModel();
        fileIsOpen = false;
    }


    public boolean openFile() {
        String path = setPath();
        fileModel.setFileName(path);
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(path)))
        ) {
            int counterLines = 0;
            StringBuilder sb = new StringBuilder();
            String str = "";

            while (str != null) {
                str = bufferedReader.readLine();
                if (str != null) {
                    sb.append(str).append("\n");
                    counterLines++;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    fileModel.getPages().add(sb.toString());
                }
                if (counterLines >= 10) {
                    sb.deleteCharAt(sb.length() - 1);
                    fileModel.getPages().add(sb.toString());

                    sb.setLength(0);
                    counterLines = 0;
                }
            }
            fileIsOpen = true;
            return true;
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return false;
        }
    }

    public ArrayList<Integer> findWord() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int index;
        ArrayList<Integer> indexAndPage = new ArrayList<>();
        for (int i = 0; i < fileModel.getPages().size(); i++) {
            index = 0;
            index = fileModel.getPages().get(i).indexOf(word, index);
            while (index != -1) {
                indexAndPage.add(i);
                indexAndPage.add(index);
                index = fileModel.getPages().get(i).indexOf(word, index + word.length());
            }
        }
        return indexAndPage;
    }

    public void replaceWord() {
        Scanner scanner = new Scanner(System.in);
        String regex = scanner.nextLine();
        String replacement = scanner.nextLine();
        String s;
        for (int i = 0; i < fileModel.getPages().size(); i++) {
            s = fileModel.getPages().get(i).replaceAll(regex, replacement);
            fileModel.getPages().set(i, s);
        }
    }

    public Date getDateLastChangeFile() {
        File file = new File(fileModel.getFileName());
        return new Date(file.lastModified());
    }

    public String getFileSizeBytes() {
        File file = new File(fileModel.getFileName());
        return String.valueOf(file.length());
    }

    public boolean createNewFiles() {
        Scanner scanner = new Scanner(System.in);
        String uri = scanner.nextLine();
        File file = new File(uri);
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return false;
        }
    }

    private String getDirectoryTree(String dir, String tab) {
        var sb = new StringBuilder();
        sb.append(tab).append(TAB);
        File file = new File(dir);
        String[] arr = file.list();
        for (String s : arr) {
            file = new File(dir + "/" + s);
            if (file.isDirectory()) {
                builder.append(tab).append(s).append("\n");
                getDirectoryTree(dir + "/" + s, sb.toString());
            } else if (file.isFile()) {
                builder.append(tab).append(s).append("\n");
            } else {
                builder.append(tab).append(s).append("\n");
                getDirectoryTree(dir + "/" + s, sb.toString());
            }
        }
        return builder.toString();
    }

    /**
     * Метод обертка, для обнуления поля
     */
    public String getDirectoryTrees(String dir, String tab) {
        String s = getDirectoryTree(dir, tab);
        builder.setLength(0);
        return s;
    }

    public int checkOperation() {
        Scanner scanner = new Scanner(System.in);
        int operation = 0;
        try {
            operation = Integer.parseInt(scanner.nextLine());
            if (operation < 1 || operation > MAX_OPERATION)
                operation = -1;
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return -1;
        }
        return operation;
    }

    public boolean saveText() {
        if (fileIsOpen) {
            for (String s : fileModel.getPages()) {
                builder.append(s);
            }
            try (FileWriter writer = new FileWriter(
                    (BaseDirectory.basePath + "/" + fileModel.getFileName()), false)) {
                writer.write(builder.toString());
                builder.setLength(0);
                return true;
            } catch (IOException e) {
                LOGGER.log(Level.ERROR,e.getMessage());
                return false;
            }
        } else
            return false;
    }

    private String setPath() {
        String path;
        Scanner scanner = new Scanner(System.in);
        path = BaseDirectory.basePath;
        path += "/";
        path += scanner.nextLine();
        return path;
    }

    public String setBasePath() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        BaseDirectory.basePath = s;
        return "Базовая директория изменена, новая директория " + s;
    }

    public FileModel getFileModel() {
        return fileModel;
    }

    public boolean isFileIsOpen() {
        return fileIsOpen;
    }
}
