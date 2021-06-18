import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawGame extends JFrame{
    public  final Container   screen;

    private JButton[] gameMode; 
    private JButton   sair;
    private JRadioButton randomGame;

    public  Player returnPlayer;
    public  Player returnPlayer2;

    Font  defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal =    new Color(32,44,57);
    Color Charcoal =    new Color(40,56,69);
    Color LCharcoal =   new Color(52,73,91);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB =      new Color(255,51,31);
    Color Platinum =    new Color(235,235,235);
    Color SpringGreen = new Color(50,232,117);

    String attackMode;

    int[] mode = {0,0};
    boolean selec;

    int[] StartMenu(Container screen){
        Container panel;
        panel = getContentPane();
        panel.setLayout(null);
        panel.setBackground(Gunmetal);
        panel.setVisible(true);

        screen.setSize(348, 165);
        gameMode       = new JButton[3];
        sair             = new JButton();
        randomGame  = new JRadioButton();

        randomGame  = new JRadioButton("Aleatório");    randomGame.setBounds(250,35,75,20);  randomGame.setBackground(Charcoal);  randomGame.setForeground(Platinum);  screen.add(randomGame);
        gameMode[0] = new JButton("Jogador V Jogador"); gameMode[0].setBounds(95,10,150,20); gameMode[0].setBackground(Charcoal); gameMode[0].setForeground(Platinum); screen.add(gameMode[0]);
        gameMode[1] = new JButton("Jogador V CPU");     gameMode[1].setBounds(95,35,150,20); gameMode[1].setBackground(Charcoal); gameMode[1].setForeground(Platinum); screen.add(gameMode[1]);
        gameMode[2] = new JButton("CPU V CPU");         gameMode[2].setBounds(95,60,150,20); gameMode[2].setBackground(Charcoal); gameMode[2].setForeground(Platinum); screen.add(gameMode[2]);
        sair        = new JButton("Sair");              sair.setBounds(120,85,100,25);      sair.setBackground(Charcoal);        sair.setForeground(Platinum);        screen.add(sair);

        for(int i = 0; i < 3; i++){
            int x = i;
            gameMode[i].addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        switch (x){
                            case 0:
                                System.out.println("Jogador V Jogador");
                                mode[0] = 1;
                                dispose();
                                DrawGameStart p1 = new DrawGameStart();
                                returnPlayer = p1.PlayerONE;
                                System.out.println(returnPlayer.Nome);
                                DrawGameStart p2 = new DrawGameStart();
                                returnPlayer2 = p2.PlayerONE;
                                System.out.println(returnPlayer2.Nome);
                                break;
                            case 1:
                                System.out.println("Jogador V CPU");
                                mode[0] = 2;
                                dispose();
                                p1 = new DrawGameStart();
                                returnPlayer = p1.PlayerONE;
                                System.out.println(returnPlayer.Nome);
                                break;
                            case 2:
                                System.out.println("CPU V CPU");
                                mode[0] = 3;
                                //dispose(); 
                                break;
                        }
                        
                    }
                }
            );
            sair.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.out.println("Sair");
                        System.exit(0);
                    }
                }
            );
            
            randomGame.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        selec = randomGame.isSelected();
                        System.out.println(selec);
                        if(selec == true){
                            System.out.println("Modo Aleatório");
                            mode[1] = 1;
                        }else{
                            System.out.println("Modo Normal");
                            mode[1] = 0;
                        }
                    }
                }
            );
        }
        return mode;
    } 

    int op;
    boolean cooldown;
    
    /*void GamePlayHandler(Container screen){
        JButton[][] gridPos;
        gridPos = new JButton[10][10];
        JButton[][] gridPos2;
        gridPos2 = new JButton[10][10];

        JButton restartGame = new JButton(); 
        JButton newGame = new JButton();

        Container Attack;
        Attack = getContentPane();
        Attack.setLayout(null);
        Attack.setBackground(Gunmetal);
        Attack.setVisible(true);

        DrawGameAttack Att =  new DrawGameAttack();
        Att.drawGameAttack(Attack,gridPos, restartGame, newGame);

        newGame.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("new game");
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
                    op = 0;
                }
            }
        );

        /*ship[0].addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    attackMode = "Porta Aviões";
                    attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); screen.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
            }
        );

        ship[1].addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    attackMode = "Submarino";
                    attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); screen.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
            }
        );

        ship[2].addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    attackMode = "Navio de Escolta";
                    attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); screen.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
            }
        );

        ship[3].addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    attackMode = "Caça";
                    attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); screen.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
                    System.out.println(attackMode);
                }
            }
        );

        for(int k = 0; k < 10; k++){
            for(int l = 0; l < 10; l++){
                int x = k;
                int y = l;
                gridPos[k][l].addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            /*switch(attackMode){
                                case "Porta Aviões":
                                    if(cooldown == true){
                                        JOptionPane.showMessageDialog(screen, "»Espere mais um turno");
                                    }else{
                                        gridPos[x][y].setBackground(PacificBlue);
                                        gridPos[x][y].setForeground(Charcoal);
                                        gridPos[x][y].setEnabled(false);
                                        System.out.println("Ataque cinco blocos");
                                    }
                                    break;
                                case "Submarino":
                                    gridPos[x][y].setBackground(PacificBlue);
                                    gridPos[x][y].setForeground(Charcoal);
                                    gridPos[x][y].setEnabled(false);
                                    System.out.println("Ataque a todo turno");
                                    break;
                                case "Navio de Escolta":
                                    if(y == 9){
                                        JOptionPane.showMessageDialog(screen, "»Posição  de ataque Inválida");
                                    }else{
                                        gridPos[x][y].setBackground(PacificBlue);
                                        gridPos[x][y].setForeground(Charcoal);
                                        gridPos[x][y].setEnabled(false);

                                        gridPos[x][y + 1].setBackground(PacificBlue);
                                        gridPos[x][y + 1].setForeground(Charcoal);
                                        gridPos[x][y + 1].setEnabled(false);

                                        System.out.println("Ataque dois blocos");
                                    }
                                    break;
                                case "Caça":
                                    if((x == 0)||(y == 9)||(x == 9)||(y == 0)){
                                        JOptionPane.showMessageDialog(screen, "»Posição  de ataque Inválida");
                                    }else{

                                        gridPos[x][y + 1].setBackground(PacificBlue);
                                        gridPos[x][y + 1].setForeground(Charcoal);
                                        gridPos[x][y + 1].setEnabled(false);

                                        gridPos[x][y - 1].setBackground(PacificBlue);
                                        gridPos[x][y - 1].setForeground(Charcoal);
                                        gridPos[x][y - 1].setEnabled(false);

                                        gridPos[x + 1][y].setBackground(PacificBlue);
                                        gridPos[x + 1][y].setForeground(Charcoal);
                                        gridPos[x + 1][y].setEnabled(false);

                                        gridPos[x - 1][y].setBackground(PacificBlue);
                                        gridPos[x - 1][y].setForeground(Charcoal);
                                        gridPos[x - 1][y].setEnabled(false);

                                        gridPos[x][y].setBackground(PacificBlue);
                                        gridPos[x][y].setForeground(Charcoal);
                                        gridPos[x][y].setEnabled(false);

                                        System.out.println("Ataque a cada 2 turnos");
                                    }
                                    break;
                            }
                            System.out.println('x');
                        }
                    }
                );
            }
        }   

    }*/

    public DrawGame(int gameStatus, String windowLabel){
        //Starts the GUI
        super(windowLabel);
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(348, 165);

        /*StartMenu(screen);
        GamePlayHandler(screen);*/

        switch (gameStatus){
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
}
