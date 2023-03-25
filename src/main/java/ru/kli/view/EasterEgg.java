package ru.kli.view;

import javax.swing.*;

public class EasterEgg extends JFrame {
    public static final String GIF_PATH = "my_data_for_testing/tedting_directory/second/MediumUnnaturalAfricanfisheagle-max-1mb.gif";

    public EasterEgg() {
        super("Easter Egg");

        this.add(new JPanel().add(new JLabel(new ImageIcon(GIF_PATH))));
        this.setBounds(50,410,490, 390);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
