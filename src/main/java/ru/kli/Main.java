package ru.kli;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.kli.view.SimpleGUI;

public class Main  {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Старт программы");
        SimpleGUI simpleGUI = new SimpleGUI();
        simpleGUI.setVisible(true);
        LOGGER.log(Level.INFO, "Завершение программы");

    }

}