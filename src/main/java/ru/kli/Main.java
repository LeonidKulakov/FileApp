package ru.kli;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.kli.controller.FileOperation;
import ru.kli.view.MyView;

/**
 * ------------------------------------------------------------------------------------------
 * пользователь может задать корневую папку коллекции, !!!!!!!!!!!Не понял, что именно требуется!!!!!!!!!!!!!!
 * ------------------------------------------------------------------------------------------
 * (Готово, кроме автора)
 * посмотреть свойства документа (размер, автор, дата создания), !!!!!!!!!!!!!!Где брать автора!!!!!!!!!!!!!!
 * ------------------------------------------------------------------------------------------
 * сортировать коллекцию документов (по размеру, автору, дате создания).
 * ------------------------------------------------------------------------------------------
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Старт программы");
        FileOperation fileOperation = new FileOperation();
        MyView myView = new MyView(fileOperation);
        myView.mainMenu();
        LOGGER.log(Level.INFO, "Завершение программы");
    }

}