package ru.kli;

import ru.kli.controller.FileOperation;

/**
 *
 * Создать приложение «Коллекция текстовых документов».
 * Проект должен позволять выполнять базовые операции с текстовыми документами:
 *
// * открытие документа (если содержимое документа не помещается на
// * одном экране, нужно организовать постраничный вывод с возможностью перехода
// * вперед или назад на одну страницу),
 *
// * поиск по документу (пользователь вводит слово для поиска,
// * после чего производится поиск, вывод результатов должен быть
// * осуществлен с возможностью перехода на следующее или предыдущее место, где
// * найдено искомое слово / комбинация слов),
 *
// * замена слова или комбинации слов в документе,
 *
 * создание нового документа.
 *
 * При старте проекта отображается структура коллекции.
 *
 * ------------Кроме уже перечисленных возможностей-----------------
 *
 * пользователь может задать корневую папку коллекции, !!!!!!!!!!!Не понял, что именно требуется!!!!!!!!!!!!!!
 *
 * посмотреть свойства документа (размер, автор, дата создания), !!!!!!!!!!!!!!Где брать автора!!!!!!!!!!!!!!
 *
 * сортировать коллекцию документов (по размеру, автору, дате создания).
 *
 * Интерфейс приложения должен позволять выводить результат работы приложения
 * в консоль или файл. Приложение должно поддерживать интерфейс командной строки
 *
 * */
public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        fileOperation.openFile("my_data_for_testing/song_testing_directory/song_text/rock/Перемен.txt");
//        View view = new View();
//        try {
//            view.showFileText(fileOperation.getTextContainer().getPages());
//        } catch (NumberFormatException e) {
//            System.err.println("Ну здравствуйте");
//        }
//        fileOperation.findWord("Перемен");
//        fileOperation.replaceWord("Перемен", "!!!!!!!!!!!!");


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





    }
}