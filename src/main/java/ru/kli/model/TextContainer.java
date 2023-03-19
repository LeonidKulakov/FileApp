package ru.kli.model;

import java.util.ArrayList;

/**
 * Хранит в себе List страниц открытого файла
 * */
public class TextContainer {

    private ArrayList<String> pages;

    public TextContainer() {
        pages = new ArrayList<>();
    }

    public ArrayList<String> getPages() {
        return pages;
    }

}
