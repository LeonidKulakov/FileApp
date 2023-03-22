package ru.kli.view;

import ru.kli.controller.FileOperation;
import ru.kli.model.BaseDirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyView {

    private FileOperation fileOperation;

    public MyView(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    public void mainMenu() {
        int operation = 0;
        while (operation != -1) {
            System.out.println("Выбери операцию \n1-Показать структуру коллекции " +
                    "\n2-Открыть документ \n3-Выполнить поиск по документу " +
                    "\n4-заменить слово в документе \n5-Создание документа " +
                    "\n6-посмотреть дату последнего изменения \n7-Посмотреть размер документа" +
                    "\n8-Посмотреть содержимое документа \n9-Задать корневую папку" +
                    "\nЛюбой другой символ - Выход");
            operation = fileOperation.checkOperation();
            switch (operation) {
                case 1 -> System.out.println(fileOperation
                        .getDirectoryTrees(BaseDirectory.basePath, ""));
                case 2 -> showOpenDocument();
                case 3 -> showResultFindWord();
                case 4 -> showResultReplaceWord();
                case 5 -> showResultCreateFile();
                case 6 -> showDateLastChangeFile();
                case 7 -> showFileSizeBytes();
                case 8 -> showFileText(fileOperation.getFileModel().getPages());
                case 9 -> System.out.println(fileOperation.setBasePath());
            }
        }
    }

    private void showOpenDocument() {
        System.out.println("Введи путь и имя файла");
        if (fileOperation.openFile())
            System.out.println("Файл успешно открыт");
        else
            System.out.println("Файл не открыт");
    }

    private void showResultFindWord() {
        if (fileOperation.isFileIsOpen()) {
            System.out.println("Введи слово для поиска");
            ArrayList<Integer> indexAndPage = fileOperation.findWord();
            if (indexAndPage.size() != 0) {
                for (int i = 0; i < indexAndPage.size(); i = i + 2) {
                    System.out.printf("Слово найдено на %d странице, индекс %d %n"
                            , indexAndPage.get(i)
                            , indexAndPage.get(i + 1));
                }
            } else {
                System.out.println("Поиск не дал результатов");
            }
        } else {
            System.out.println("Откройте файл");
        }
    }

    private void showResultReplaceWord() {
        System.out.println("Введи слово для замены, затем новое слово");
        fileOperation.replaceWord();
        System.out.println("Замена произведена");
    }

    private void showResultCreateFile() {
        System.out.println("Введи путь и имя файла");
        if (fileOperation.createNewFiles()) {
            System.out.println("Файл успешно создан");
        } else {
            System.out.println("Файл не создан");
        }
    }

    //TODO переделать
    public void showFileText(List<String> pages) {
        System.out.printf("В открытом файле %d страниц, укажите номер страницы \n", pages.size());
        Scanner scanner = new Scanner(System.in);
        try {
            int pageNumber = Integer.parseInt(scanner.nextLine());
            int maxPageNumber = pages.size();

            if (pageNumber > maxPageNumber) {
                System.out.println("Дятел, тут нет столько страниц");
            } else {
                System.out.println(pages.get(pageNumber - 1));
                changePage(pageNumber, maxPageNumber, pages);
            }
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
        }
    }
    //TODO переделать
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

    public void showDateLastChangeFile() {
        if (fileOperation.isFileIsOpen())
            System.out.println("Дата последнего изменения выбранного файла: "
                    + fileOperation.getDateLastChangeFile());
        else
            System.out.println("Откройте файл");
    }

    public void showFileSizeBytes() {
        if (fileOperation.isFileIsOpen())
            System.out.println("Размер выбранного файла: "
                    + fileOperation.getFileSizeBytes() + " byte");
        else
            System.out.println("Откройте файл");
    }

}
