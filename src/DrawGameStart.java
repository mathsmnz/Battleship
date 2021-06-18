import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawGameStart extends JFrame{
    public       Container   screen;
    public       JComboBox   selector;
    public       JTextField  score;
    public       JButton  newGame;
    public       JButton     restartGame;
    public       JButton[][] gridPos = new JButton[10][10];

    public       Player      placeholder = new Player(null, null, null, null, null, 0, 0, 0);
    public       Player      PlayerONE   = new Player(null, null, null, null, null, 0, 0, 0);

    JLabel[] HLabel = new JLabel[10];
    JLabel[] VLabel = new JLabel[10];

    Font  defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal =    new Color(32,44,57);
    Color Charcoal =    new Color(40,56,69);
    Color LCharcoal =   new Color(52,73,91);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB =      new Color(255,51,31);
    Color Platinum =    new Color(235,235,235);
    Color SpringGreen = new Color(50,232,117);

    private int op;

    Player drawGameStart(Container scr, JButton[][] gridPos, JButton restartGame, JButton newGame){
        scr.setSize(625,700);

        final List<String> strings = new ArrayList<String>();
        String[] shipList = new String[]{"Porta-avião", "Submarino", "Navio de Escolta", "Caça"};
        strings.addAll(Arrays.asList(shipList));
        selector = new JComboBox (shipList); scr.add(selector); selector.setBounds (40, 5, 545, 30); 
        selector.setFont(defaultFont);
        selector.setForeground(Platinum);
        selector.setBackground(Charcoal);

        DrawLabel drawL = new DrawLabel();

        HLabel = new JLabel[10];
        HLabel = drawL.drawLabel('h', scr);
        VLabel = new JLabel[10];
        VLabel = drawL.drawLabel('v', scr);
        
        DrawButton drawB = new DrawButton();

        drawB.drawButton(40, 60,  0, gridPos, scr, Charcoal, "A");
        drawB.drawButton(40, 115, 1, gridPos, scr, Charcoal, "B");
        drawB.drawButton(40, 170, 2, gridPos, scr, Charcoal, "C");
        drawB.drawButton(40, 225, 3, gridPos, scr, Charcoal, "D");
        drawB.drawButton(40, 280, 4, gridPos, scr, Charcoal, "E");
        drawB.drawButton(40, 335, 5, gridPos, scr, Charcoal, "F");
        drawB.drawButton(40, 390, 6, gridPos, scr, Charcoal, "G");
        drawB.drawButton(40, 445, 7, gridPos, scr, Charcoal, "H");
        drawB.drawButton(40, 500, 8, gridPos, scr, Charcoal, "I");
        drawB.drawButton(40, 555, 9, gridPos, scr, Charcoal, "J");


        newGame = new JButton("Iniciar Jogo");               newGame.setBounds(40, 620, 100, 25);      scr.add(newGame); newGame.setFont(defaultFont); newGame.setBackground(Charcoal); newGame.setForeground(Platinum);
        score = new JTextField("Coloque Seu Nome!");  score.setBounds( 145, 620, 335, 25);      scr.add(score); score.setEditable(true); score.setFont(defaultFont); score.setBackground(Charcoal); score.setForeground(Platinum);
        restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25); scr.add(restartGame); restartGame.setFont(defaultFont); restartGame.setBackground(Charcoal); restartGame.setForeground(Platinum);

        int[] selShip = {0,0,0,0};
        
        newGame.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("new game");
                    System.out.println(placeholder.Nome);
                    dispose();
                }
            }
        );

        restartGame.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("restart");
                    for(int k = 0; k < 10; k++){
                        for(int l = 0; l < 10; l++){
                            if((k % 2) == 0){
                                if((l % 2) == 0){
                                    gridPos[k][l].setBackground(Charcoal);
                                    gridPos[k][l].setForeground(Platinum);
                                }else{
                                    gridPos[k][l].setBackground(LCharcoal);
                                    gridPos[k][l].setForeground(Platinum);
                                }
                            }else{
                                if((l % 2) != 0){
                                    gridPos[k][l].setBackground(Charcoal);
                                    gridPos[k][l].setForeground(Platinum);
                                }else{
                                    gridPos[k][l].setBackground(LCharcoal);
                                    gridPos[k][l].setForeground(Platinum);
                                }
                            }
                        }
                    }
                    selShip[0] = 0;
                    selShip[1] = 0;
                    selShip[2] = 0;
                    selShip[3] = 0;
                }
            }
        );

        score.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    placeholder.Nome = score.getText();
                    System.out.println(placeholder.Nome);
                }
            }
        );

        selector.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println(selector.getSelectedItem());
                    op = selector.getSelectedIndex();
                    System.out.println(op);
                    if(selShip[op] == 1){
                        JOptionPane.showMessageDialog(screen, "»Peça já posicionada");
                    }
                }
        
            }
        );
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                String hello = "Pressed " + Integer.toString(i) + " " + Integer.toString(j);
                int x = i;
                int y = j;
                gridPos[i][j].addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            switch(op){
                                case 0:
                                    if(selShip[op] == 0){
                                        if((9 - y) > 2){
                                            for(int k = 0; k < 4; k++){
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y,y+1,y+2,y+3};
                                            airCarrier s1 = new airCarrier((short)4, xcord, ycord, "Porta Aviões");
                                            placeholder.porta = s1;
                                            System.out.println(placeholder.porta.Nome + " " + x);

                                            selShip[0] = 1;
                                            System.out.println(selShip[0]);
                                        }else{
                                            JOptionPane.showMessageDialog(screen, "»Posição Inválida");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(screen, "»Peça já posicionada");
                                    }
                                    break;
                                case 1:
                                    if(selShip[op] == 0){
                                        if((9 - y) > 0){
                                            for(int k = 0; k < 2; k++){
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y,y+1};
                                            submarine s2 = new submarine((short)2, xcord, ycord, "Submarino");
                                            placeholder.sub = s2;
                                            System.out.println(placeholder.sub.Nome + " " + x);

                                            selShip[1] = 1;
                                            System.out.println(selShip[1]);
                                        }else{
                                            JOptionPane.showMessageDialog(screen, "»Posição Inválida");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(screen, "»Peça já posicionada");
                                    }
                                    break;
                                case 2:
                                    if(selShip[op] == 0){
                                        if((9 - y) > 1){
                                            for(int k = 0; k < 3; k++){
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y,y+1, y+2};
                                            escorteur s3 = new escorteur((short)3, xcord, ycord, "Navio de Escolta");
                                            placeholder.escolta = s3;
                                            System.out.println(placeholder.escolta.Nome + " " + x);

                                            selShip[2] = 1;
                                            System.out.println(selShip[2]);
                                        }else{
                                            JOptionPane.showMessageDialog(screen, "»Posição Inválida");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(screen, "»Peça já posicionada");
                                    }
                                    break;
                                case 3:
                                    if(selShip[op] == 0){
                                        if((9 - y) > 0){
                                            for(int k = 0; k < 2; k++){
                                                gridPos[x][y + k].setForeground(Charcoal);
                                                gridPos[x][y + k].setBackground(SpringGreen);
                                            }
                                            int[] xcord = {x};
                                            int[] ycord = {y,y+1};
                                            fighterJet s4 = new fighterJet((short)2, xcord, ycord, "Caça");
                                            placeholder.caça = s4;
                                            System.out.println(placeholder.caça.Nome + " " + x);

                                            selShip[3] = 1;
                                            System.out.println(selShip[3]);
                                        }else{
                                            JOptionPane.showMessageDialog(screen, "»Posição Inválida");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(screen, "»Peça já posicionada");
                                    }
                                    break;
                            }
                            System.out.println(hello);
                        }
                    }
                );
            }    
        }
        return placeholder;
    }

    public DrawGameStart(){
        super("Insira suas peças");
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(625,700);

        PlayerONE = drawGameStart(screen, gridPos, restartGame, newGame);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}

