package ru.kli;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.kli.controller.FileOperation;
import ru.kli.enumData.UriEnum;
import ru.kli.view.MyView;

import java.util.Scanner;

/**
 * Создать приложение «Коллекция текстовых документов».
 * Проект должен позволять выполнять базовые операции с текстовыми документами:
 * ------------------------------------------------------------------------------------------
 * (Готово)
 * открытие документа (если содержимое документа не помещается на
 * одном экране, нужно организовать постраничный вывод с возможностью перехода
 * вперед или назад на одну страницу),
 * ------------------------------------------------------------------------------------------
 * (Готово)
 * поиск по документу (пользователь вводит слово для поиска,
 * после чего производится поиск, вывод результатов должен быть
 * осуществлен с возможностью перехода на следующее или предыдущее место, где
 * найдено искомое слово / комбинация слов),
 * ------------------------------------------------------------------------------------------
 * (Готово)
 * замена слова или комбинации слов в документе,
 * ------------------------------------------------------------------------------------------
 * (Готово)
 * создание нового документа.
 * ------------------------------------------------------------------------------------------
 * (Готово)
 * При старте проекта отображается структура коллекции.
 * ------------------------------------------------------------------------------------------
 * ------------Кроме уже перечисленных возможностей-----------------
 * ------------------------------------------------------------------------------------------
 * пользователь может задать корневую папку коллекции, !!!!!!!!!!!Не понял, что именно требуется!!!!!!!!!!!!!!
 * ------------------------------------------------------------------------------------------
 * (Готово, кроме автора)
 * посмотреть свойства документа (размер, автор, дата создания), !!!!!!!!!!!!!!Где брать автора!!!!!!!!!!!!!!
 * ------------------------------------------------------------------------------------------
 * сортировать коллекцию документов (по размеру, автору, дате создания).
 * ------------------------------------------------------------------------------------------
 * !!!!!!!Хочу сделать дублирование в файл, что бы не загромождать код ифами!!!!!!!!
 * Интерфейс приложения должен позволять выводить результат работы приложения
 * в консоль или файл. Приложение должно поддерживать интерфейс командной строки
 */
public class Main {

    /**
     * Сохранение изменений??????????
     * Что за задание корневой папки?????
     * Отдельный контроллер для работы с текстом????
     * Как понять кто автор?????
     * Для сортировки нужно в корне пересмотреть концепцию приложения????
     * Резонно ли выносить вывод данных в файл в отдельный функционал?????
     * Инъекция view в controller, не нравится сама концепция, но вывод осуществить проще
     * Расширение функционала для работы с docx по средствам apache poi
     * */

    private static final Logger LOGGER = Logger.getLogger(Main.class);




    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Старт приложения");

        Scanner scanner = new Scanner(System.in);
        FileOperation fileOperation = new FileOperation();
        MyView view = new MyView();


        fileOperation.showAllFile(UriEnum.BASE_URI.getUri(), "");
        int operation = 0;
        while (operation != -1) {
            System.out.println("Выбери операцию \n1-Показать структуру коллекции " +
                    "\n2-Открыть документ \n3-Выполнить поиск по документу " +
                    "\n4-заменить слово в документе \n5-Создание документа " +
                    "\n6-посмотреть дату последнего изменения \n7-Посмотреть размер документа" +
                    "\nЛюбой другой символ - Выход");
            operation = checkOperation(scanner.nextLine());
            switch (operation) {
                case 1 -> fileOperation.showAllFile(UriEnum.BASE_URI.getUri(), "");
                case 2 -> {
                    fileOperation.openFile(setPath());
                    //TODO обернуть NumberFormatException
                    view.showFileText(fileOperation.getTextContainer().getPages());
                }
                case 3 -> {
                    fileOperation.openFile(setPath());
                    System.out.println("Введи слово для поиска");
                    String word = scanner.nextLine();
                    //TODO обернуть NumberFormatException
                    fileOperation.findWord(word);
                }
                case 4 -> {
                    System.out.println("Введи слово для замены");
                    String regex = scanner.nextLine();
                    System.out.println("Введи новое слово");
                    String replacement = scanner.nextLine();
                    fileOperation.replaceWord(regex,replacement);
                }
                case 5 -> fileOperation.createNewFiles();
                case 6 -> System.out.println("6");
                case 7 -> System.out.println("7");
            }
        }
    }

    public static int checkOperation(String oper) {
        int operation = 0;
        try {
            operation = Integer.parseInt(oper);
            if (operation < 1 || operation > 7)
                operation = -1;
        } catch (NumberFormatException e) {
            return -1;
        }
        return operation;
    }

    private static String setPath(){
        String path;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи путь и имя файла");
        path = UriEnum.BASE_URI.getUri();
        path += "/";
        path +=scanner.nextLine();
        return path;
    }
//    public static void main(String[] args) {
//        File file = new File("my_data_for_testing/song_testing_directory/song_text/rock/Перемен.txt");
//        FileOperation fileOperation = new FileOperation();
//        fileOperation.openFile("my_data_for_testing/song_testing_directory/song_text/rock/Перемен.txt");
//        myView view = new myView();
//        try {
//            view.showFileText(fileOperation.getTextContainer().getPages());
//        } catch (NumberFormatException e) {
//            System.err.println("Ну здравствуйте");
//        }
//        fileOperation.findWord("Перемен");
//        fileOperation.replaceWord("Перемен", "!!!!!!!!!!!!");
//
//        Date date = fileOperation.getDateLastChangeFile(file);
//        view.showDateLastChangeFile(date);
//        view.showFileSizeBytes(fileOperation.getFileSizeBytes(file));
//        fileOperation.showAllFile("my_data_for_testing","");
//
//        try (FileInputStream fileInputStream = new FileInputStream(
//                "my_data_for_testing/text_tedting_directory/Эволюция Хакайна.docx"))
//        {
//
//            // открываем файл и считываем его содержимое в объект XWPFDocument
//            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
//            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxFile);
//
//            // считываем верхний колонтитул (херед документа)
//            XWPFHeader docHeader = headerFooterPolicy.getDefaultHeader();
//            System.out.println(docHeader.getText());
//
//            // печатаем содержимое всех параграфов документа в консоль
//            List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
//            System.out.println(paragraphs.get(7).getText());
//            for (XWPFParagraph p : paragraphs) {
//                System.out.println(p.getText());
//            }
//            // считываем нижний колонтитул (футер документа)
//            XWPFFooter docFooter = headerFooterPolicy.getDefaultFooter();
//            System.out.println(docFooter.getText());
//
//            /*System.out.println("_____________________________________");
//            // печатаем все содержимое Word файла
//            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
//            System.out.println(extractor.getText());*/
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}