import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawGame extends JFrame {
    public        JButton[][] gridPos;
    public  final Container   screen;
    public       JButton     restartGame;
    public       JButton     newGame;
    private       JButton[]   ship;
    private       JComboBox   selector;
    private       JTextField  score;
    private       JTextField  attackSelector;
    private       JLabel[]    HLabel;
    private       JLabel[]    VLabel;

    private JButton[] gameMode; 
    private JButton   sair;
    private JRadioButton randomGame;

    private Player placeholder;

    Font  defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal =    new Color(32,44,57);
    Color Charcoal =    new Color(40,56,69);
    Color LCharcoal =   new Color(52,73,91);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB =      new Color(255,51,31);
    Color Platinum =    new Color(235,235,235);
    Color SpringGreen = new Color(50,232,117);

    String attackMode;

    private void DrawButton(int x, int y, int i,Container scr, Color color, String buttonLabel){
        for(int a = 0; a < 10; a++){
            String text  = buttonLabel + Integer.toString(a);
            gridPos[i][a] = new JButton(text); gridPos[i][a].setBounds (x, y, 50, 50) ;scr.add(gridPos[i][a]);
            gridPos[i][a].setFont(defaultFont);
            

            if(color == Charcoal){
                gridPos[i][a].setForeground(Platinum);
            }else{
                gridPos[i][a].setForeground(Gunmetal);
            }
            if((i % 2) == 0){
                if((a % 2) == 0){
                    gridPos[i][a].setBackground(color);
                }else{
                    gridPos[i][a].setBackground(LCharcoal);
                }
            }else{
                if((a % 2) != 0){
                    gridPos[i][a].setBackground(color);
                }else{
                    gridPos[i][a].setBackground(LCharcoal);
                }
            }


            x = x + 55;
        }
    }

    private void DrawLabel(char sel, Container scr){
        if(sel == 'h'){
            int x = 60;
            for(int i = 0; i < 10; i++){
                HLabel[i] = new JLabel(Integer.toString(i)); HLabel[i].setBounds(x, 35, 25, 25); HLabel[i].setFont(defaultFont); scr.add(HLabel[i]); 
                HLabel[i].setForeground(Platinum);
                x = x + 55;
            }
        }else{
            int y = 75;
            char c = 'A';
            
            for(int i = 0; i < 10; i++){
                VLabel[i] = new JLabel(Character.toString(c)); VLabel[i].setBounds(15, y, 25, 25);  VLabel[i].setFont(defaultFont); scr.add(VLabel[i]);
                VLabel[i].setForeground(Platinum);
                y = y + 55;
                c = (char)(c + 1);
            }
            
        }
    }

    void DrawGameStart(Container scr){
        setSize(625,700);
        gridPos = new JButton[10][10];

        final List<String> strings = new ArrayList<String>();
        String[] shipList = new String[]{"Porta-avião", "Submarino", "Navio de Escolta", "Caça"};
        strings.addAll(Arrays.asList(shipList));
        selector = new JComboBox (shipList); scr.add(selector) ;selector.setBounds (40, 5, 545, 30); 
        selector.setFont(defaultFont);
        selector.setForeground(Platinum);
        selector.setBackground(Charcoal);

        HLabel = new JLabel[10];
        DrawLabel('h', screen);
        VLabel = new JLabel[10];
        DrawLabel('v', screen);
        DrawButton(40, 60,  0, screen, Charcoal, "A");
        DrawButton(40, 115, 1, screen, Charcoal, "B");
        DrawButton(40, 170, 2, screen, Charcoal, "C");
        DrawButton(40, 225, 3, screen, Charcoal, "D");
        DrawButton(40, 280, 4, screen, Charcoal, "E");
        DrawButton(40, 335, 5, screen, Charcoal, "F");
        DrawButton(40, 390, 6, screen, Charcoal, "G");
        DrawButton(40, 445, 7, screen, Charcoal, "H");
        DrawButton(40, 500, 8, screen, Charcoal, "I");
        DrawButton(40, 555, 9, screen, Charcoal, "J");

        newGame = new JButton("Iniciar Jogo");               newGame.setBounds(40, 620, 100, 25);      scr.add(newGame); newGame.setFont(defaultFont); newGame.setBackground(Charcoal); newGame.setForeground(Platinum);
        score = new JTextField("Coloque Seu Nome!");  score.setBounds( 145, 620, 335, 25);      scr.add(score); score.setEditable(true); score.setFont(defaultFont); score.setBackground(Charcoal); score.setForeground(Platinum);
        restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25); scr.add(restartGame); restartGame.setFont(defaultFont); restartGame.setBackground(Charcoal); restartGame.setForeground(Platinum);
    }

    void DrawGameCycle(Container scr){
        setSize(760,700);
        gridPos = new JButton[10][10];

        score = new JTextField("Pontuação");  score.setBounds(40, 5, 545, 30);      scr.add(score); score.setEditable(false); score.setFont(defaultFont); 
        score.setBackground(Charcoal); score.setForeground(Platinum);

        HLabel = new JLabel[10];
        DrawLabel('h', screen);
        VLabel = new JLabel[10];
        DrawLabel('v', screen);

        DrawButton(40, 60,  0, screen, Charcoal, "A");
        DrawButton(40, 115, 1, screen, Charcoal, "B");
        DrawButton(40, 170, 2, screen, Charcoal, "C");
        DrawButton(40, 225, 3, screen, Charcoal, "D");
        DrawButton(40, 280, 4, screen, Charcoal, "E");
        DrawButton(40, 335, 5, screen, Charcoal, "F");
        DrawButton(40, 390, 6, screen, Charcoal, "G");
        DrawButton(40, 445, 7, screen, Charcoal, "H");
        DrawButton(40, 500, 8, screen, Charcoal, "I");
        DrawButton(40, 555, 9, screen, Charcoal, "J");

        ship = new JButton[4];
        ship[0] = new JButton("Porta Aviões");     ship[0].setBounds(590,265,150,25); scr.add(ship[0]); ship[0].setBackground(Charcoal); ship[0].setForeground(Platinum);
        ship[1] = new JButton("Submarino");        ship[1].setBounds(590,300,150,25); scr.add(ship[1]); ship[1].setBackground(Charcoal); ship[1].setForeground(Platinum);
        ship[2] = new JButton("Navio de Escolta"); ship[2].setBounds(590,340,150,25); scr.add(ship[2]); ship[2].setBackground(Charcoal); ship[2].setForeground(Platinum);
        ship[3] = new JButton("Caça");             ship[3].setBounds(590,375,150,25); scr.add(ship[3]); ship[3].setBackground(Charcoal); ship[3].setForeground(Platinum);

        attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); scr.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
        newGame = new JButton("Novo Jogo");                  newGame.setBounds(40, 620, 100, 25);                                         scr.add(newGame);        newGame.setFont(defaultFont);        newGame.setBackground(Charcoal);        newGame.setForeground(Platinum);
        restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25);                                    scr.add(restartGame);    restartGame.setFont(defaultFont);    restartGame.setBackground(Charcoal);    restartGame.setForeground(Platinum);

    }

    int[] mode = {0,0};
    boolean selec;
    int[] StartMenu(Container screen){
        setSize(348, 165);
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
                                break;
                            case 1:
                                System.out.println("Jogador V CPU");
                                mode[0] = 2;
                                break;
                            case 2:
                                System.out.println("CPU V CPU");
                                mode[0] = 3;
                                break;
                        }
                        
                    }
                }
            );
            sair.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.out.println("Sair");
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
    Player GameStartHandler(Container screen){
        placeholder = new Player(null, null, null, null, null, 0, 0, 0);
        DrawGameStart(screen);
        int i = 0;
        int j = 0;
        int[] selShip = {0,0,0,0};
        
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
                    selShip[0] = 0;
                    selShip[1] = 0;
                    selShip[2] = 0;
                    selShip[3] = 0;
                }
            }
        );

        score.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    placeholder.Nome = score.getText();
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
        
        for(i = 0; i < 10; i++){
            for(j = 0; j < 10; j++){
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
    
    void GamePlayHandler(Container screen){
        DrawGameCycle(screen);
        

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

        ship[0].addActionListener(
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
                            switch(attackMode){
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
                        }
                    }
                );
            }
        }   

    }

    public Player p;

    public DrawGame(int gameStatus, String windowLabel){
        //Starts the GUI
        super(windowLabel);
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);

        

        switch (gameStatus){
            case 1:
                StartMenu(screen);
                break;
            case 2:
                p = GameStartHandler(screen);
                break;
            case 3:
                GamePlayHandler(screen);
                break;
        }

        setVisible(true);
        setLocationRelativeTo(null);
    }
}
