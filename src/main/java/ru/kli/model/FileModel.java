package ru.kli.model;

import java.util.ArrayList;

/**
 * Хранит в себе List страниц открытого файла
 * */
public class FileModel {
    private String fileName;
    private ArrayList<String> pages;

    public FileModel() {
        pages = new ArrayList<>();
    }

    public ArrayList<String> getPages() {
        return pages;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
