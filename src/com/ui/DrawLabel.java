package com.ui;

import javax.swing.*;
import java.awt.*;

public class DrawLabel {
    final Font defaultFont = new Font("IBM 3270", Font.PLAIN, 12);
    final Color Platinum = new Color(235, 235, 235);
    Color Gunmetal = new Color(32, 44, 57);
    Color Charcoal = new Color(40, 56, 69);
    Color LCharcoal = new Color(52, 73, 91);
    Color PacificBlue = new Color(8, 164, 189);
    Color RedRYB = new Color(255, 51, 31);
    Color SpringGreen = new Color(50, 232, 117);

    public JLabel[] drawLabel(char sel, Container scr) {
        JLabel[] HLabel = new JLabel[10];
        JLabel[] VLabel = new JLabel[10];
        if (sel == 'h') {
            int x = 60;
            for (int i = 0; i < 10; i++) {
                HLabel[i] = new JLabel(Integer.toString(i));
                HLabel[i].setBounds(x, 35, 25, 25);
                HLabel[i].setFont(defaultFont);
                scr.add(HLabel[i]);
                HLabel[i].setForeground(Platinum);
                x = x + 55;
            }
            return HLabel;
        } else {
            int y = 75;
            char c = 'A';

            for (int i = 0; i < 10; i++) {
                VLabel[i] = new JLabel(Character.toString(c));
                VLabel[i].setBounds(15, y, 25, 25);
                VLabel[i].setFont(defaultFont);
                scr.add(VLabel[i]);
                VLabel[i].setForeground(Platinum);
                y = y + 55;
                c = (char) (c + 1);
            }
            return VLabel;
        }
    }
}
