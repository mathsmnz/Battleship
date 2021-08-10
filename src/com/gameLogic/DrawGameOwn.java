package com.gameLogic;

import com.ui.DrawButton;
import com.ui.DrawLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawGameOwn extends JFrame {

    final Font defaultFont = new Font("IBM 3270", Font.PLAIN, 12);
    final Color Gunmetal = new Color(32, 44, 57);
    final Color Charcoal = new Color(40, 56, 69);
    final Color PacificBlue = new Color(8, 164, 189);
    final Color RedRYB = new Color(255, 51, 31);
    final Color Platinum = new Color(235, 235, 235);
    final Color SpringGreen = new Color(50, 232, 117);
    final Color UltraViolet = new Color(95, 75, 139);
    public Player placeholder = new Player("player", null, null, null, null, 0, 0, 0, 0, false, 0, null);
    JLabel[] HLabel = new JLabel[10];
    JLabel[] VLabel = new JLabel[10];
    Color LCharcoal = new Color(52, 73, 91);
    private JButton newGame;
    private JButton restartGame;

    public DrawGameOwn(Player player, Player nextPlayer, long startTime) {
        super("Seu Tabuleiro " + player.Nome);

        Container screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(625, 700);

        placeholder = player;
        System.out.println((placeholder.porta.getCoordY()[0] + "|" + placeholder.porta.getCoordY()[1] + "|" + placeholder.porta.getCoordY()[2] + "|" + placeholder.porta.getCoordY()[3]));
        JButton[][] gridPos = new JButton[10][10];
        drawGameOwn(screen, gridPos, restartGame, player, nextPlayer, startTime);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void drawHitGrid(ArrayList<String> pos, JButton[][] gridPos, Container scr) {
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
    }

    private void drawCaça(Player p1, JButton[][] gridPos, Container scr) {
        gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setBackground(Platinum);
        gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setForeground(Charcoal);
        gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setBackground(Platinum);
        gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setForeground(Charcoal);

        if (p1.caça.getCoordRem()[0] == 1) {
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setBackground(Color.BLACK);
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.caça.getCoordRem()[1] == 1) {
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setBackground(Color.BLACK);
            gridPos[p1.caça.getCoordX()[0]][p1.caça.getCoordY()[1]].setForeground(Platinum);
        }

    }

    private void drawSub(Player p1, JButton[][] gridPos, Container scr) {
        gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setBackground(UltraViolet);
        gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setForeground(Charcoal);
        gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setBackground(UltraViolet);
        gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setForeground(Charcoal);

        if (p1.sub.getCoordRem()[0] == 1) {
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setBackground(Color.BLACK);
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.sub.getCoordRem()[1] == 1) {
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setBackground(Color.BLACK);
            gridPos[p1.sub.getCoordX()[0]][p1.sub.getCoordY()[1]].setForeground(Platinum);
        }

    }

    private void drawEscolta(Player p1, JButton[][] gridPos, Container scr) {
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setBackground(SpringGreen);
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setForeground(Platinum);
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setBackground(SpringGreen);
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setForeground(Platinum);
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setBackground(SpringGreen);
        gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setForeground(Platinum);

        if (p1.escolta.getCoordRem()[0] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setBackground(Color.BLACK);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.escolta.getCoordRem()[1] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setBackground(Color.BLACK);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.escolta.getCoordRem()[2] == 1) {
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setBackground(Color.BLACK);
            gridPos[p1.escolta.getCoordX()[0]][p1.escolta.getCoordY()[2]].setForeground(Platinum);
        }

    }

    private void drawPorta(Player p1, JButton[][] gridPos, Container scr) {
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setBackground(RedRYB);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setForeground(Charcoal);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setBackground(RedRYB);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setForeground(Charcoal);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setBackground(RedRYB);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setForeground(Charcoal);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setBackground(RedRYB);
        gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setForeground(Charcoal);

        if (p1.porta.getCoordRem()[0] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setBackground(Color.BLACK);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[0]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[1] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setBackground(Color.BLACK);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[1]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[2] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setBackground(Color.BLACK);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[2]].setForeground(Platinum);
        }
        if (p1.porta.getCoordRem()[3] == 1) {
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setBackground(Color.BLACK);
            gridPos[p1.porta.getCoordX()[0]][p1.porta.getCoordY()[3]].setForeground(Platinum);
        }

    }

    public void drawGameOwn(Container scr, JButton[][] gridPos, JButton restartGame, Player p1, Player p2, long startTime) {
        scr.setSize(625, 700);

        JTextField score = new JTextField("Pontuação");
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

        drawHitGrid(p2.attackHist, gridPos, scr);

        drawCaça(p1, gridPos, scr);
        drawSub(p1, gridPos, scr);
        drawEscolta(p1, gridPos, scr);
        drawPorta(p1, gridPos, scr);


        JButton newGame = new JButton("Avançar");
        newGame.setBounds(40, 620, 100, 25);
        scr.add(newGame);
        newGame.setFont(defaultFont);
        newGame.setBackground(Charcoal);
        newGame.setForeground(Platinum);
        //restartGame = new JButton("Reiniciar Jogo");     restartGame.setBounds(485, 620, 100, 25);   scr.add(restartGame);    restartGame.setFont(defaultFont);    restartGame.setBackground(Charcoal);    restartGame.setForeground(Platinum);
        newGame.addActionListener(
                e -> {
                    DrawGameAttack next = new DrawGameAttack(p2, p1, startTime);
                    next.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
        );

    }

}
