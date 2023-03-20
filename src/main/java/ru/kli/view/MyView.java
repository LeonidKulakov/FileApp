package ru.kli.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyView {


    public void showFileText(List<String> pages) throws NumberFormatException {
        System.out.printf("В открытом файле %d страниц, укажите номер страницы \n", pages.size());
        Scanner scanner = new Scanner(System.in);

        int pageNumber = Integer.parseInt(scanner.nextLine());
        int maxPageNumber = pages.size();

        if (pageNumber > maxPageNumber) {
            System.out.println("Дятел, тут нет столько страниц");
        } else {
            System.out.println(pages.get(pageNumber - 1));
            changePage(pageNumber, maxPageNumber, pages);
        }
    }

    private void changePage(int pageNumber, int maxPageNumber, List<String> pages) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        int operationNumber = 0;

        while (operationNumber != -1) {
            if (pageNumber == 1) {
                System.out.println("Показать следующую страницу 2 \nОтменить показ -1");
                operationNumber = Integer.parseInt(scanner.nextLine());
                if (operationNumber == 2) {
                    pageNumber++;
                    System.out.println(pages.get(pageNumber - 1));
                } else if (operationNumber != -1) {
                    System.out.println("Не правильно выбрана операция");
                }
            } else if (pageNumber == maxPageNumber) {
                System.out.println("Показать предыдущую страницу 1 \nОтменить показ -1");
                operationNumber = Integer.parseInt(scanner.nextLine());
                if (operationNumber == 1) {
                    pageNumber--;
                    System.out.println(pages.get(pageNumber - 1));
                } else if (operationNumber != -1) {
                    System.out.println("Не правильно выбрана операция");
                }
            } else {
                System.out.println("Показать предыдущую страницу 1 \nПоказать следующую страницу 2\nОтменить показ -1");
                operationNumber = Integer.parseInt(scanner.nextLine());
                if (operationNumber == 1) {
                    pageNumber--;
                    System.out.println(pages.get(pageNumber - 1));
                } else if (operationNumber == 2) {
                    pageNumber++;
                    System.out.println(pages.get(pageNumber - 1));
                } else if (operationNumber != -1) {
                    System.out.println("Не правильно выбрана операция");
                }
            }
        }
    }

    public void showDateLastChangeFile(Date date){
        System.out.println("Дата последнего изменения выбранного файла: " + date);
    }
    public void showFileSizeBytes(String fileSize){
        System.out.println("Размер выбранного файла: " + fileSize +" byte");

    }

}
