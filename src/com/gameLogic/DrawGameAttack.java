package com.gameLogic;

import com.gameLogic.ships.cpuAttack;
import com.ui.DrawButton;
import com.ui.DrawLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawGameAttack extends JFrame {
    public final Container screen;
    public final JButton[][] gridPos = new JButton[10][10];
    final Font defaultFont = new Font("IBM 3270", Font.PLAIN, 12);
    final Font biggerFont = defaultFont.deriveFont(100);
    final Color Gunmetal = new Color(32, 44, 57);
    final Color Charcoal = new Color(40, 56, 69);
    final Color PacificBlue = new Color(8, 164, 189);
    final Color Platinum = new Color(235, 235, 235);
    final Color SpringGreen = new Color(50, 232, 117);
    public JComboBox selector;
    public JTextField score;
    public JButton[] ship;
    public JTextField attackSelector;
    public String attackMode = null;
    public JButton newGame;
    public JButton restartGame;
    JLabel timer;
    long startTime = 0;
    long elapsedTime = System.currentTimeMillis() - startTime;
    JLabel[] HLabel = new JLabel[10];
    JLabel[] VLabel = new JLabel[10];
    Color LCharcoal = new Color(52, 73, 91);
    Color RedRYB = new Color(255, 51, 31);
    boolean hasAttacked = false;

    public DrawGameAttack(Player target, Player source, long gTime) {
        super("Posicione seu ataque em [" + target.Nome + "]");
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(760, 700);

        startTime = gTime;

        if (source.Score == 11) {
            JOptionPane.showMessageDialog(screen, "com.gameLogic.Player " + source.Nome + " ganhou e " + target.Nome + " perdeu ");
            elapsedTime = System.currentTimeMillis() - startTime;
            JOptionPane.showMessageDialog(screen, "TEMPO DE JOGO:" + (elapsedTime / 60) + ":" + (elapsedTime % 60));
            System.exit(0);
        }

        elapsedTime = System.currentTimeMillis() - startTime;

        drawGameAttack(screen, gridPos, target, source, source.cooldown);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void disableAttack(JButton[][] gridPos) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gridPos[i][j].setEnabled(false);
            }
        }
        ship[0].setEnabled(false);
        ship[1].setEnabled(false);
        ship[2].setEnabled(false);
        ship[3].setEnabled(false);
    }

    private void drawHitGrid(ArrayList<String> pos, JButton[][] gridPos, Container scr, Player p1) {
        System.out.println(pos);
        if (pos != null) {
            for (String coord : pos) {
                int x = Character.getNumericValue(coord.charAt(0));
                int y = Character.getNumericValue(coord.charAt(2));
                System.out.printf("%d  e %d", x, y);
                gridPos[x][y].setBackground(PacificBlue);
                gridPos[x][y].setForeground(Charcoal);
            }
        }
        if (p1.caça.getCoordRem()[0] == 1) {
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setBackground(SpringGreen);
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.caça.getCoordRem()[1] == 1) {
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setBackground(SpringGreen);
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.sub.getCoordRem()[0] == 1) {
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setBackground(SpringGreen);
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.sub.getCoordRem()[1] == 1) {
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setBackground(SpringGreen);
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.escolta.getCoordRem()[0] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setBackground(SpringGreen);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.escolta.getCoordRem()[1] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setBackground(SpringGreen);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.escolta.getCoordRem()[2] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setBackground(SpringGreen);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[0] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setBackground(SpringGreen);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[1] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setBackground(SpringGreen);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[2] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setBackground(SpringGreen);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[3] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setBackground(SpringGreen);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setForeground(Platinum);
        }
    }

    public void drawGameAttack(Container scr, JButton[][] gridPos, Player tgt, Player src, Boolean cooldown) {
        scr.setSize(760, 700);

        score = new JTextField("Pontuação " + src.Score);
        score.setBounds(40, 5, 545, 30);
        scr.add(score);
        score.setEditable(false);
        score.setFont(defaultFont);
        score.setBackground(Charcoal);
        score.setForeground(Platinum);

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

        drawHitGrid(src.attackHist, gridPos, scr, tgt);

        ship = new JButton[4];
        ship[0] = new JButton("Porta Aviões");
        ship[0].setBounds(590, 265, 150, 25);
        scr.add(ship[0]);
        ship[0].setBackground(Charcoal);
        ship[0].setForeground(Platinum);
        ship[0].setFont(defaultFont);
        ship[1] = new JButton("Submarino");
        ship[1].setBounds(590, 300, 150, 25);
        scr.add(ship[1]);
        ship[1].setBackground(Charcoal);
        ship[1].setForeground(Platinum);
        ship[1].setFont(defaultFont);
        ship[2] = new JButton("Navio de Escolta");
        ship[2].setBounds(590, 340, 150, 25);
        scr.add(ship[2]);
        ship[2].setBackground(Charcoal);
        ship[2].setForeground(Platinum);
        ship[2].setFont(defaultFont);
        ship[3] = new JButton("Caça");
        ship[3].setBounds(590, 375, 150, 25);
        scr.add(ship[3]);
        ship[3].setBackground(Charcoal);
        ship[3].setForeground(Platinum);
        ship[3].setFont(defaultFont);
        timer = new JLabel(String.valueOf(elapsedTime));
        timer.setBounds(655, 405, 150, 25);
        timer.setFont(biggerFont);
        scr.add(timer);
        timer.setBackground(Charcoal);
        timer.setForeground(Platinum);

        if (src.porta.getTAM() == 0) {
            ship[0].setEnabled(false);
        }
        if (src.sub.getTAM() == 0) {
            ship[1].setEnabled(false);
        }
        if (src.escolta.getTAM() == 0) {
            ship[2].setEnabled(false);
        }
        if (src.caça.getTAM() == 0) {
            ship[3].setEnabled(false);
        }

        ActionListener taskPerformer = evt -> {
            elapsedTime = System.currentTimeMillis() - startTime;
            long elapsedSeconds = elapsedTime / 1000;
            long secondsDisplay = elapsedSeconds % 60;
            long elapsedMinutes = elapsedSeconds / 60;
            timer.setText(elapsedMinutes + ":" + secondsDisplay);
            scr.add(timer);
        };
        Timer timerGet = new Timer(100, taskPerformer);
        timerGet.setRepeats(true);
        timerGet.start();

        ActionListener screenRefresher = evt -> {
            if (hasAttacked) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        gridPos[i][j].setEnabled(false);
                    }
                }
                ship[0].setEnabled(false);
                ship[1].setEnabled(false);
                ship[2].setEnabled(false);
                ship[3].setEnabled(false);
            }
        };
        Timer screenRefreseh = new Timer(10, screenRefresher);
        screenRefreseh.setRepeats(true);
        screenRefreseh.start();

        attackSelector = new JTextField(attackMode);
        attackSelector.setBounds(590, 230, 150, 25);
        attackSelector.setEditable(false);
        scr.add(attackSelector);
        attackSelector.setFont(defaultFont);
        attackSelector.setBackground(Charcoal);
        attackSelector.setForeground(Platinum);
        JButton newGame = new JButton("Novo Jogo");
        newGame.setBounds(40, 620, 100, 25);
        scr.add(newGame);
        newGame.setFont(defaultFont);
        newGame.setBackground(Charcoal);
        newGame.setForeground(Platinum);
        JButton restartGame = new JButton("Reiniciar Jogo");
        restartGame.setBounds(485, 620, 100, 25);
        scr.add(restartGame);
        restartGame.setFont(defaultFont);
        restartGame.setBackground(Charcoal);
        restartGame.setForeground(Platinum);
        JButton nextTurn = new JButton("Passar turno");
        nextTurn.setBounds(210, 620, 100, 25);
        scr.add(nextTurn);
        JButton hint = new JButton("Dica");
        hint.setBounds(315, 620, 100, 25);                                              //scr.add(hint);

        nextTurn.addActionListener(
                e -> {
                    if (src.Score == 11) {
                        JOptionPane.showMessageDialog(scr, "com.gameLogic.Player " + src.Nome + " ganhou e " + tgt.Nome + " perdeu ");
                        elapsedTime = System.currentTimeMillis() - startTime;
                        JOptionPane.showMessageDialog(scr, "TEMPO DE JOGO:" + (elapsedTime / 60) + ":" + (elapsedTime % 60));
                        System.exit(0);
                    } else {
                        dispose();
                        if (tgt.Mode == 1) {
                            cpuAttack cpuAtt = new cpuAttack(src, tgt, startTime);
                            dispose();
                        } else {
                            DrawGameOwn next = new DrawGameOwn(tgt, src, startTime);
                            //src, tgt, startTime
                            next.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            System.out.println(src.attackHist);
                        }
                    }
                }
        );

        newGame.addActionListener(
                e -> {
                    DrawGame restart = new DrawGame(1, "Inicie o jogo");
                    restart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        );

        restartGame.addActionListener(
                e -> {
                    System.out.println("restart");
                    int[] r1 = {11, 11, 11, 11};
                    int[] r2 = {11, 11};
                    int[] r3 = {11, 11, 11};
                    int[] r4 = {11, 11};
                    src.Score = 0;
                    src.cooldown = false;
                    src.caça.setCoordRem(r4);
                    src.sub.setCoordRem(r2);
                    src.escolta.setCoordRem(r3);
                    src.porta.setCoordRem(r1);
                    src.attackHist = new ArrayList<>();

                    tgt.Score = 0;
                    tgt.cooldown = false;
                    tgt.caça.setCoordRem(r4);
                    tgt.sub.setCoordRem(r2);
                    tgt.escolta.setCoordRem(r3);
                    tgt.porta.setCoordRem(r1);
                    tgt.attackHist = new ArrayList<>();

                    DrawGameAttack next = new DrawGameAttack(src, tgt, startTime);
                    next.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();

                }
        );

        ship[0].addActionListener(
                e -> {
                    attackMode = "Porta Aviões";
                    attackSelector = new JTextField(attackMode);
                    attackSelector.setBounds(590, 230, 150, 25);
                    attackSelector.setEditable(false);
                    screen.add(attackSelector);
                    attackSelector.setFont(defaultFont);
                    attackSelector.setBackground(Charcoal);
                    attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
        );

        ship[1].addActionListener(
                e -> {
                    attackMode = "Submarino";
                    attackSelector = new JTextField(attackMode);
                    attackSelector.setBounds(590, 230, 150, 25);
                    attackSelector.setEditable(false);
                    screen.add(attackSelector);
                    attackSelector.setFont(defaultFont);
                    attackSelector.setBackground(Charcoal);
                    attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
        );

        ship[2].addActionListener(
                e -> {
                    attackMode = "Navio de Escolta";
                    attackSelector = new JTextField(attackMode);
                    attackSelector.setBounds(590, 230, 150, 25);
                    attackSelector.setEditable(false);
                    screen.add(attackSelector);
                    attackSelector.setFont(defaultFont);
                    attackSelector.setBackground(Charcoal);
                    attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
        );

        ship[3].addActionListener(
                e -> {
                    attackMode = "Caça";
                    attackSelector = new JTextField(attackMode);
                    attackSelector.setBounds(590, 230, 150, 25);
                    attackSelector.setEditable(false);
                    screen.add(attackSelector);
                    attackSelector.setFont(defaultFont);
                    attackSelector.setBackground(Charcoal);
                    attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
        );

        if (src.attackHist == null) {
            src.attackHist = new ArrayList<>();
        }

        for (int k = 0; k < 10; k++) {
            for (int l = 0; l < 10; l++) {
                int x = k;
                int xu = x + 1;
                int xd = x - 1;
                int y = l;
                int yr = y + 1;
                int yl = y - 1;
                gridPos[k][l].addActionListener(
                        e -> {
                            if (attackMode != null) {
                                switch (attackMode) {
                                    case "Porta Aviões":
                                        if (cooldown) {
                                            JOptionPane.showMessageDialog(screen, "»Espere mais um turno");
                                        } else {
                                            //Checa se acertou algo
                                            gridPos[x][y].setBackground(PacificBlue);
                                            gridPos[x][y].setForeground(Charcoal);
                                            src.attackHist.add(x + "+" + y);
                                            hasAttacked = true;
                                            disableAttack(gridPos);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((y == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                } else if ((y == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((y == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                } else if ((y == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((y == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);

                                                    src.cooldown = true;
                                                } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);

                                                    src.cooldown = true;
                                                } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((y == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                } else if ((y == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                } else if ((y == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);

                                                    src.cooldown = true;
                                                } else if ((y == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = true;

                                                }
                                            }
                                            gridPos[x][y].setEnabled(false);
                                            System.out.println("Ataque em cada dois turnos");
                                        }
                                        break;
                                    case "Submarino":
                                        //Checa se acertou algo
                                        gridPos[x][y].setBackground(PacificBlue);
                                        gridPos[x][y].setForeground(Charcoal);
                                        src.attackHist.add(x + "+" + y);
                                        hasAttacked = true;
                                        disableAttack(gridPos);
                                        if ((x == tgt.caça.getCoordX()[0])) {
                                            if ((y == tgt.caça.getCoordY()[0])) {
                                                tgt.caça.getCoordRem()[0] = 1;
                                                tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.caça.getCoordY()[1])) {
                                                tgt.caça.getCoordRem()[1] = 1;
                                                tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            }
                                            src.cooldown = false;
                                        } else if ((x == tgt.sub.getCoordX()[0])) {
                                            if ((y == tgt.sub.getCoordY()[0])) {
                                                tgt.sub.getCoordRem()[0] = 1;
                                                tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.sub.getCoordY()[1])) {
                                                tgt.sub.getCoordRem()[1] = 1;
                                                tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            }
                                        } else if ((x == tgt.escolta.getCoordX()[0])) {
                                            if ((y == tgt.escolta.getCoordY()[0])) {
                                                tgt.escolta.getCoordRem()[0] = 1;
                                                tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                tgt.escolta.getCoordRem()[1] = 1;
                                                tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                tgt.escolta.getCoordRem()[2] = 1;
                                                tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            }
                                        } else if ((x == tgt.porta.getCoordX()[0])) {
                                            if ((y == tgt.porta.getCoordY()[0])) {
                                                tgt.porta.getCoordRem()[0] = 1;
                                                tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.porta.getCoordY()[1])) {
                                                tgt.porta.getCoordRem()[1] = 1;
                                                tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.porta.getCoordY()[2])) {
                                                tgt.porta.getCoordRem()[2] = 1;
                                                tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            } else if ((y == tgt.porta.getCoordY()[3])) {
                                                tgt.porta.getCoordRem()[3] = 1;
                                                tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                src.Score = src.Score + 1;
                                                gridPos[x][y].setBackground(SpringGreen);
                                                gridPos[x][y].setForeground(Charcoal);
                                                src.cooldown = false;

                                            }
                                        }
                                        gridPos[x][y].setEnabled(false);
                                        System.out.println("Ataque a todo turno");
                                        src.cooldown = false;
                                        break;
                                    case "Navio de Escolta":
                                        if ((y == 9) || (!gridPos[x][yr].isEnabled()) || (src.escolta.getTAM() == 0)) {
                                            JOptionPane.showMessageDialog(screen, "»Posição  de ataque Inválida");
                                        } else {
                                            gridPos[x][y].setBackground(PacificBlue);
                                            gridPos[x][y].setForeground(Charcoal);
                                            src.attackHist.add(x + "+" + (y + 1));
                                            src.attackHist.add(x + "+" + y);
                                            hasAttacked = true;
                                            disableAttack(gridPos);
                                            //Checa se acertou algo
                                            gridPos[x][y].setBackground(PacificBlue);
                                            gridPos[x][y].setForeground(Charcoal);

                                            hasAttacked = true;
                                            disableAttack(gridPos);
                                            src.attackHist.add(x + "+" + y);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((y == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((y == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((y == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((y == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;
                                                } else if ((y == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;
                                                }
                                            }
                                            gridPos[x][y].setEnabled(false);

                                            gridPos[x][yr].setBackground(PacificBlue);
                                            gridPos[x][yr].setForeground(Charcoal);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((yr == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = yr;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((yr == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((yr == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((yr == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            }
                                            gridPos[x][y + 1].setEnabled(false);

                                            System.out.println("Ataque dois blocos");
                                        }
                                        src.cooldown = false;
                                        break;
                                    case "Caça":
                                        if ((x == 0) || (y == 9) || (x == 9) || (y == 0) || (!gridPos[x][yr].isEnabled()) || (!gridPos[x][yl].isEnabled()) || (!gridPos[xu][y].isEnabled()) || (!gridPos[xd][y].isEnabled()) || (src.caça.getTAM() == 0)) {
                                            JOptionPane.showMessageDialog(scr, "»Ataque Inválido");
                                        } else {

                                            hasAttacked = true;
                                            disableAttack(gridPos);
                                            src.attackHist.add(x + "+" + y);
                                            src.attackHist.add(x + 1 + "+" + y);
                                            src.attackHist.add(x - 1 + "+" + y);
                                            src.attackHist.add(x + "+" + (y + 1));
                                            src.attackHist.add(x + "+" + (y - 1));
                                            gridPos[x][yr].setBackground(PacificBlue);
                                            gridPos[x][yr].setForeground(Charcoal);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((yr == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = yr;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((yr == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((yr == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((yr == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                } else if ((yr == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yr].setBackground(SpringGreen);
                                                    gridPos[x][yr].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yr);
                                                }
                                            }
                                            gridPos[x][y + 1].setEnabled(false);

                                            gridPos[x][yl].setBackground(PacificBlue);
                                            gridPos[x][yl].setForeground(Charcoal);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((yl == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((yl == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((yl == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((yl == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                } else if ((yl == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][yl].setBackground(SpringGreen);
                                                    gridPos[x][yl].setForeground(Charcoal);
                                                    src.attackHist.add(x + "+" + yl);
                                                }
                                            }
                                            gridPos[x][yl].setEnabled(false);

                                            gridPos[xu][y].setBackground(PacificBlue);
                                            gridPos[xu][y].setForeground(Charcoal);
                                            if ((xu == tgt.caça.getCoordX()[0])) {
                                                if ((y == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                }
                                            } else if ((xu == tgt.sub.getCoordX()[0])) {
                                                if ((y == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                }
                                            } else if ((xu == tgt.escolta.getCoordX()[0])) {
                                                if ((y == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                }
                                            } else if ((xu == tgt.porta.getCoordX()[0])) {
                                                if ((y == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xu][y].setBackground(SpringGreen);
                                                    gridPos[xu][y].setForeground(Charcoal);
                                                    src.attackHist.add(xu + "+" + y);
                                                }
                                            }
                                            gridPos[xu][y].setEnabled(false);

                                            gridPos[xd][y].setBackground(PacificBlue);
                                            gridPos[xd][y].setForeground(Charcoal);
                                            if ((xd == tgt.caça.getCoordX()[0])) {
                                                if ((y == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                }
                                            } else if ((xd == tgt.sub.getCoordX()[0])) {
                                                if ((y == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                }
                                            } else if ((xd == tgt.escolta.getCoordX()[0])) {
                                                if ((y == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                }
                                            } else if ((xd == tgt.porta.getCoordX()[0])) {
                                                if ((y == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                } else if ((y == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[xd][y].setBackground(SpringGreen);
                                                    gridPos[xd][y].setForeground(Charcoal);
                                                    src.attackHist.add(xd + "+" + y);
                                                }
                                            }
                                            gridPos[xd][y].setEnabled(false);

                                            gridPos[x][y].setBackground(PacificBlue);
                                            gridPos[x][y].setForeground(Charcoal);
                                            if ((x == tgt.caça.getCoordX()[0])) {
                                                if ((y == tgt.caça.getCoordY()[0])) {
                                                    tgt.caça.getCoordRem()[0] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.caça.getCoordY()[1])) {
                                                    tgt.caça.getCoordRem()[1] = 1;
                                                    tgt.caça.setTAM((short) (tgt.caça.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.sub.getCoordX()[0])) {
                                                if ((y == tgt.sub.getCoordY()[0])) {
                                                    tgt.sub.getCoordRem()[0] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.sub.getCoordY()[1])) {
                                                    tgt.sub.getCoordRem()[1] = 1;
                                                    tgt.sub.setTAM((short) (tgt.sub.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.escolta.getCoordX()[0])) {
                                                if ((y == tgt.escolta.getCoordY()[0])) {
                                                    tgt.escolta.getCoordRem()[0] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.escolta.getCoordY()[1])) {
                                                    tgt.escolta.getCoordRem()[1] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.escolta.getCoordY()[2])) {
                                                    tgt.escolta.getCoordRem()[2] = 1;
                                                    tgt.escolta.setTAM((short) (tgt.escolta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            } else if ((x == tgt.porta.getCoordX()[0])) {
                                                if ((y == tgt.porta.getCoordY()[0])) {
                                                    tgt.porta.getCoordRem()[0] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.porta.getCoordY()[1])) {
                                                    tgt.porta.getCoordRem()[1] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.porta.getCoordY()[2])) {
                                                    tgt.porta.getCoordRem()[2] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                } else if ((y == tgt.porta.getCoordY()[3])) {
                                                    tgt.porta.getCoordRem()[3] = 1;
                                                    tgt.porta.setTAM((short) (tgt.porta.getTAM() - 1));
                                                    src.Score = src.Score + 1;
                                                    gridPos[x][y].setBackground(SpringGreen);
                                                    gridPos[x][y].setForeground(Charcoal);
                                                    src.cooldown = false;

                                                }
                                            }
                                            gridPos[x][y].setEnabled(false);

                                            System.out.println("Ataque a cada 2 turnos");
                                        }
                                        src.cooldown = false;
                                        break;

                                }
                            } else {
                                JOptionPane.showMessageDialog(scr, "Escolha uma peça antes");
                            }
                            System.out.println('x');
                        }
                );
            }
        }
    }
}
