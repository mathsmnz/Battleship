package com.gameLogic;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JFrame {
    public final Container screen;
    public final boolean sucess = false;
    final Color Gunmetal = new Color(32, 44, 57);
    final Color Charcoal = new Color(40, 56, 69);
    final Color Platinum = new Color(235, 235, 235);
    final int[] mode = {0, 0};
    public Player returnPlayer = new Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);
    public Player returnPlayer2 = new Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);
    Font defaultFont = new Font("IBM 3270", Font.PLAIN, 12);
    Color LCharcoal = new Color(52, 73, 91);
    Color PacificBlue = new Color(8, 164, 189);
    Color RedRYB = new Color(255, 51, 31);
    Color SpringGreen = new Color(50, 232, 117);
    String attackMode;
    boolean selec;
    private JRadioButton randomGame;

    public DrawGame(int gameStatus, String windowLabel) {
        //Starts the GUI
        super(windowLabel);
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(348, 165);

        /*StartMenu(screen);
        GamePlayHandler(screen);*/

        switch (gameStatus) {
            case 1:
                StartMenu(screen);
                break;
            case 2:
                //returnPlayer = GameStartHandler(screen);
                break;
            case 3:
                //GamePlayHandler(screen);
                break;
        }

        setVisible(true);
        setLocationRelativeTo(null);
    }

    void StartMenu(Container screen) {
        Container panel;
        panel = getContentPane();
        panel.setLayout(null);
        panel.setBackground(Gunmetal);
        panel.setVisible(true);

        screen.setSize(348, 165);
        JButton[] gameMode = new JButton[3];
        JButton sair = new JButton();
        randomGame = new JRadioButton();

        randomGame = new JRadioButton("Aleatório");
        randomGame.setBounds(250, 35, 75, 20);
        randomGame.setBackground(Charcoal);
        randomGame.setForeground(Platinum);
        screen.add(randomGame);
        gameMode[0] = new JButton("Jogador V Jogador");
        gameMode[0].setBounds(95, 10, 150, 20);
        gameMode[0].setBackground(Charcoal);
        gameMode[0].setForeground(Platinum);
        screen.add(gameMode[0]);
        gameMode[1] = new JButton("Jogador V CPU");
        gameMode[1].setBounds(95, 35, 150, 20);
        gameMode[1].setBackground(Charcoal);
        gameMode[1].setForeground(Platinum);
        screen.add(gameMode[1]);
        gameMode[2] = new JButton("Debug");
        gameMode[2].setBounds(95, 60, 150, 20);
        gameMode[2].setBackground(Charcoal);
        gameMode[2].setForeground(Platinum);
        screen.add(gameMode[2]);
        sair = new JButton("Sair");
        sair.setBounds(120, 85, 100, 25);
        sair.setBackground(Charcoal);
        sair.setForeground(Platinum);
        screen.add(sair);


        for (int i = 0; i < 3; i++) {
            int x = i;
            gameMode[i].addActionListener(
                    e -> {
                        switch (x) {
                            case 0:
                                if (mode[1] == 0) {
                                    System.out.println("Jogador V Jogador");
                                    ///mode[0] = 1;
                                    DrawGameStart p1 = new DrawGameStart(returnPlayer, returnPlayer2, 1);
                                    dispose();
                                    p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                } else {
                                    playerCreator createPlayer = new playerCreator(1);
                                    returnPlayer = createPlayer.p1;

                                    createPlayer = new playerCreator(2);
                                    returnPlayer2 = createPlayer.p1;
                                    long time = System.currentTimeMillis();
                                    DrawGameAttack attack = new DrawGameAttack(returnPlayer2, returnPlayer, time);
                                    attack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    dispose();
                                }
                                break;
                            case 1:
                                System.out.println("Jogador V CPU");
                                //mode[0] = 2;
                                playerCreator createPlayer = new playerCreator(2);
                                returnPlayer2 = createPlayer.p1;
                                returnPlayer2.Mode = 1;
                                returnPlayer2.playerCtrl = 1;


                                if (mode[1] == 0) {
                                    DrawGameStart p1 = new DrawGameStart(returnPlayer, returnPlayer2, 2);
                                    returnPlayer = p1.playerReturn;
                                    returnPlayer.Mode = 0;
                                    dispose();
                                    System.out.println(returnPlayer.Nome);
                                    p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                } else {
                                    createPlayer = new playerCreator(1);
                                    returnPlayer = createPlayer.p1;

                                    long time = System.currentTimeMillis();
                                    DrawGameAttack attack = new DrawGameAttack(returnPlayer2, returnPlayer, time);
                                    attack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    dispose();
                                }
                                break;
                            case 2:
                                System.out.println("CPU V CPU");
                                mode[0] = 3;
                                createPlayer = new playerCreator(1);
                                returnPlayer2 = createPlayer.p1;
                                returnPlayer2.Mode = 2;
                                returnPlayer2.playerCtrl = 2;
                                long time = System.currentTimeMillis();
                                DrawGameOwn attack = new DrawGameOwn(returnPlayer2, returnPlayer2, time);
                                dispose();
                                break;
                        }

                    }
            );
            sair.addActionListener(
                    e -> {
                        System.out.println("Sair");
                        System.exit(0);
                    }
            );

            randomGame.addActionListener(
                    e -> {
                        selec = randomGame.isSelected();
                        System.out.println(selec);
                        if (selec) {
                            System.out.println("Modo Aleatório");
                            mode[1] = 1;
                        } else {
                            System.out.println("Modo Normal");
                            mode[1] = 0;
                        }
                    }
            );
        }
    }
}
