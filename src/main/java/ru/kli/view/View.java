package ru.kli.view;

import java.util.List;
import java.util.Scanner;

public class View {


    public void showFileText(List<String> pages){
        System.out.printf("В открытом файле %d страниц, укажите номер страницы \n", pages.size());
        Scanner scanner = new Scanner(System.in);
        int pageNumber = Integer.parseInt(scanner.nextLine());
        if (pageNumber > pages.size()){
            System.out.println("Дятел, тут нет столько страниц");
        }else {
            System.out.println(pages.get(pageNumber-1));
        }

    }
}
