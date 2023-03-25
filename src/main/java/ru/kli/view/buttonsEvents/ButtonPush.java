package ru.kli.view.buttonsEvents;

import ru.kli.view.EasterEgg;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonPush implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Просили салют, вот вам салют!");
        EasterEgg easterEgg = new EasterEgg();
    }
}
