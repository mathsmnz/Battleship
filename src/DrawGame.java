import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawGame extends JFrame{
    public  final JButton[][] gridPos;
    public  final Container   screen;
    private       JButton     restartGame;
    private       JButton     newGame;
    private       JButton[]   ship;
    private       JComboBox   selector;
    private       JTextField  score;
    private       JLabel[]    HLabel;
    private       JLabel[]    VLabel;


    Font defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal = new Color(32,44,57);
    Color Charcoal = new Color(40,56,69);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB = new Color(255,51,31);
    Color Platinum = new Color(235,235,235);

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
            gridPos[i][a].setBackground(color);

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

        JButton newGame = new JButton("Iniciar Jogo");               newGame.setBounds(40, 620, 100, 25);      scr.add(newGame); newGame.setFont(defaultFont); newGame.setBackground(Charcoal); newGame.setForeground(Platinum);
        JTextField score = new JTextField("Selecione suas Peças!");  score.setBounds( 145, 620, 335, 25);      scr.add(score); score.setEditable(false); score.setFont(defaultFont); score.setBackground(Charcoal); score.setForeground(Platinum);
        JButton restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25); scr.add(restartGame); restartGame.setFont(defaultFont); restartGame.setBackground(Charcoal); restartGame.setForeground(Platinum);
    }

    void DrawGameCycle(Container scr){
        setSize(760,700);
        JTextField score = new JTextField("Pontuação");  score.setBounds(40, 5, 545, 30);      scr.add(score); score.setEditable(false); score.setFont(defaultFont); 
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
        ship[0] = new JButton("Porta Aviões");     ship[0].setBounds(590,265,150,25); scr.add(ship[0]);
        ship[1] = new JButton("Submarino");        ship[1].setBounds(590,300,150,25); scr.add(ship[1]);
        ship[2] = new JButton("Navio de Escolta"); ship[2].setBounds(590,340,150,25); scr.add(ship[2]);
        ship[3] = new JButton("Caça");             ship[3].setBounds(590,375,150,25); scr.add(ship[3]);

        JButton newGame = new JButton("Novo Jogo");               newGame.setBounds(40, 620, 100, 25);      scr.add(newGame); newGame.setFont(defaultFont); newGame.setBackground(Charcoal); newGame.setForeground(Platinum);
        JButton restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25); scr.add(restartGame); restartGame.setFont(defaultFont); restartGame.setBackground(Charcoal); restartGame.setForeground(Platinum);

    }

    public DrawGame(int gameStatus, String windowLabel){
        //Starts the GUI
        super(windowLabel);
    
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        
        gridPos = new JButton[10][10];
        //DrawGameStart(screen);
        DrawGameCycle(screen);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
