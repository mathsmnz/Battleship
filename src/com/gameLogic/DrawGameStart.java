package com.gameLogic;

import com.gameLogic.ships.airCarrier;
import com.gameLogic.ships.escorteur;
import com.gameLogic.ships.fighterJet;
import com.gameLogic.ships.submarine;
import com.ui.DrawButton;
import com.ui.DrawLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawGameStart extends JFrame {
    final Font defaultFont = new Font("IBM 3270", Font.PLAIN, 12);
    final Color Gunmetal = new Color(32, 44, 57);
    final Color Charcoal = new Color(40, 56, 69);
    final Color LCharcoal = new Color(52, 73, 91);
    final Color Platinum = new Color(235, 235, 235);
    final Color SpringGreen = new Color(50, 232, 117);
    public Player playerReturn = new Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);
    public Player PlayerTWO = new Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);
    public boolean exited = false;
    JLabel[] HLabel = new JLabel[10];
    JLabel[] VLabel = new JLabel[10];
    Color PacificBlue = new Color(8, 164, 189);
    Color RedRYB = new Color(255, 51, 31);
    private JComboBox<? extends String> selector;
    private JTextField score;
    private JButton newGame;
    private JButton restartGame;
    private int op;

    public DrawGameStart(Player p1, Player p2, int pCtrl) {
        super("Insira suas peças");
        Container screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(625, 700);

        playerReturn = p1;
        playerReturn.playerCtrl = pCtrl;
        PlayerTWO = p2;

        JButton[][] gridPos = new JButton[10][10];
        drawGameStart(screen, gridPos, pCtrl);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    void drawGameStart(Container scr, JButton[][] gridPos, int mode) {
        scr.setSize(625, 700);

        String[] shipList = new String[]{"Porta-avião", "Submarino", "Navio de Escolta", "Caça"};
        final List<String> strings = new ArrayList<>(Arrays.asList(shipList));
        selector = new JComboBox<>(shipList);
        scr.add(selector);
        selector.setBounds(40, 5, 545, 30);
        selector.setFont(defaultFont);
        selector.setForeground(Platinum);
        selector.setBackground(Charcoal);

        playerReturn.playerCtrl = mode;
        playerReturn.dica = 3;

        DrawLabel drawL = new DrawLabel();

        HLabel = new JLabel[10];
        HLabel = drawL.drawLabel('h', scr);
        VLabel = new JLabel[10];
        VLabel = drawL.drawLabel('v', scr);

        DrawButton drawB = new DrawButton();

        drawB.drawButton(40, 60, 0, gridPos, scr, Charcoal, "A");
        drawB.drawButton(40, 115, 1, gridPos, scr, Charcoal, "B");
        drawB.drawButton(40, 170, 2, gridPos, scr, Charcoal, "C");
        drawB.drawButton(40, 225, 3, gridPos, scr, Charcoal, "D");
        drawB.drawButton(40, 280, 4, gridPos, scr, Charcoal, "E");
        drawB.drawButton(40, 335, 5, gridPos, scr, Charcoal, "F");
        drawB.drawButton(40, 390, 6, gridPos, scr, Charcoal, "G");
        drawB.drawButton(40, 445, 7, gridPos, scr, Charcoal, "H");
        drawB.drawButton(40, 500, 8, gridPos, scr, Charcoal, "I");
        drawB.drawButton(40, 555, 9, gridPos, scr, Charcoal, "J");


        JButton newGame = new JButton("Avançar");
        newGame.setBounds(40, 620, 100, 25);
        scr.add(newGame);
        newGame.setFont(defaultFont);
        newGame.setBackground(Charcoal);
        newGame.setForeground(Platinum);
        score = new JTextField("Coloque Seu Nome!");
        score.setBounds(145, 620, 335, 25);
        scr.add(score);
        score.setEditable(true);
        score.setFont(defaultFont);
        score.setBackground(Charcoal);
        score.setForeground(Platinum);
        JButton restartGame = new JButton("Reiniciar Jogo");
        restartGame.setBounds(485, 620, 100, 25);
        scr.add(restartGame);
        restartGame.setFont(defaultFont);
        restartGame.setBackground(Charcoal);
        restartGame.setForeground(Platinum);

        int[] selShip = {0, 0, 0, 0};
        int[] r1 = {11, 11, 11, 11};
        int[] r2 = {11, 11};
        int[] r3 = {11, 11, 11};
        int[] r4 = {11, 11};

        restartGame.addActionListener(
                e -> {
                    System.out.println("restart");
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            if ((k % 2) == 0) {
                                if ((l % 2) == 0) {
                                    gridPos[k][l].setBackground(Charcoal);
                                } else {
                                    gridPos[k][l].setBackground(LCharcoal);
                                }
                            } else {
                                if ((l % 2) != 0) {
                                    gridPos[k][l].setBackground(Charcoal);
                                } else {
                                    gridPos[k][l].setBackground(LCharcoal);
                                }
                            }
                            gridPos[k][l].setForeground(Platinum);
                        }
                    }
                    selShip[0] = 0;
                    selShip[1] = 0;
                    selShip[2] = 0;
                    selShip[3] = 0;
                }
        );

        score.addActionListener(
                ae -> {
                    playerReturn.Nome = score.getText();
                    System.out.println(playerReturn.Nome);
                }
        );

        selector.addActionListener(
                e -> {
                    System.out.println(selector.getSelectedItem());
                    op = selector.getSelectedIndex();
                    System.out.println(op);
                    if (selShip[op] == 1) {
                        JOptionPane.showMessageDialog(scr, "»Peça já posicionada");
                    }
                }
        );

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String hello = "Pressed " + i + " " + j;
                int x = i;
                int y = j;
                gridPos[i][j].addActionListener(
                        e -> {
                            switch (op) {
                                case 0:
                                    if (selShip[op] == 0) {
                                        if ((9 - y) > 2) {
                                            for (int k = 0; k < 4; k++) {
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y, y + 1, y + 2, y + 3};
                                            playerReturn.porta = new airCarrier((short) 4, xcord, ycord, r1, "Porta Aviões");
                                            System.out.println(playerReturn.porta.getNome() + " " + x);

                                            selShip[0] = 1;
                                            System.out.println(selShip[0]);
                                        } else {
                                            JOptionPane.showMessageDialog(scr, "»Posição Inválida");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(scr, "»Peça já posicionada");
                                    }
                                    break;
                                case 1:
                                    if (selShip[op] == 0) {
                                        if ((9 - y) > 0) {
                                            for (int k = 0; k < 2; k++) {
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y, y + 1};
                                            playerReturn.sub = new submarine((short) 2, xcord, ycord, r2, "Submarino");
                                            System.out.println(playerReturn.sub.getNome() + " " + x);

                                            selShip[1] = 1;
                                            System.out.println(selShip[1]);
                                        } else {
                                            JOptionPane.showMessageDialog(scr, "»Posição Inválida");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(scr, "»Peça já posicionada");
                                    }
                                    break;
                                case 2:
                                    if (selShip[op] == 0) {
                                        if ((9 - y) > 1) {
                                            for (int k = 0; k < 3; k++) {
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y, y + 1, y + 2};
                                            playerReturn.escolta = new escorteur((short) 3, xcord, ycord, r3, "Navio de Escolta");
                                            System.out.println(playerReturn.escolta.getNome() + " " + x);

                                            selShip[2] = 1;
                                            System.out.println(selShip[2]);
                                        } else {
                                            JOptionPane.showMessageDialog(scr, "»Posição Inválida");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(scr, "»Peça já posicionada");
                                    }
                                    break;
                                case 3:
                                    if (selShip[op] == 0) {
                                        if ((9 - y) > 0) {
                                            for (int k = 0; k < 2; k++) {
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y, y + 1};
                                            playerReturn.caça = new fighterJet((short) 2, xcord, ycord, r4, "Caça");
                                            System.out.println(playerReturn.caça.getNome() + " " + x);

                                            selShip[3] = 1;
                                            System.out.println(selShip[3]);
                                        } else {
                                            JOptionPane.showMessageDialog(scr, "»Posição Inválida");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(scr, "»Peça já posicionada");
                                    }
                                    break;
                            }
                            System.out.println(hello);
                        }
                );
            }
        }

        newGame.addActionListener(
                e -> {
                    if ((selShip[0] == 0) || (selShip[1] == 0) || (selShip[2] == 0) || (selShip[3] == 0)) {
                        JOptionPane.showMessageDialog(scr, "»Posicione suas peças primeiro");
                    } else {
                        if (mode == 1) {
                            DrawGameStart next = new DrawGameStart(PlayerTWO, playerReturn, 2);
                            next.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            dispose();
                        } else if (mode == 2) {
                            System.out.println("new game");
                            System.out.println(playerReturn.Nome);
                            long time = System.currentTimeMillis();
                            DrawGameAttack attack = new DrawGameAttack(playerReturn, PlayerTWO, time);
                            attack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            dispose();
                        }
                    }
                }
        );

    }
}

