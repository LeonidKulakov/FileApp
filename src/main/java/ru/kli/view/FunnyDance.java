package ru.kli.view;

import javax.swing.*;

public class FunnyDance extends JFrame {

    public static final String GIF_PATH = "my_data_for_testing/tedting_directory/first/last/image_862110190009247920329.gif";

    public FunnyDance() {
        super("Hello kitty");

        this.add(new JPanel().add(new JLabel(new ImageIcon(GIF_PATH))));
        this.setBounds(1000,410,530, 400);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

