import javax.swing.*;
import java.awt.*;

public class DrawGameAttack extends JFrame  {
    public       Container   screen;
    public       JComboBox   selector;
    public       JTextField  score;
    public       JButton[]   ship;
    public       JTextField  attackSelector;
    public       String      attackMode;
    public       JButton     newGame;
    public       JButton     restartGame;
    public       JButton[][] gridPos = new JButton[10][10];

    JLabel[] HLabel = new JLabel[10];
    JLabel[] VLabel = new JLabel[10];;

    Font  defaultFont = new Font("IBM 3270",Font.PLAIN, 12);
    Color Gunmetal =    new Color(32,44,57);
    Color Charcoal =    new Color(40,56,69);
    Color LCharcoal =   new Color(52,73,91);
    Color PacificBlue = new Color(8,164,189);
    Color RedRYB =      new Color(255,51,31);
    Color Platinum =    new Color(235,235,235);
    Color SpringGreen = new Color(50,232,117);

    public void drawGameAttack(Container scr, JButton[][] gridPos, JButton restartGame, JButton newGame, Player tgt, Player src){
        scr.setSize(760,700);
        gridPos = new JButton[10][10];

        score = new JTextField("Pontuação");  score.setBounds(40, 5, 545, 30);      scr.add(score); score.setEditable(false); score.setFont(defaultFont); 
        score.setBackground(Charcoal); score.setForeground(Platinum);

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


        ship = new JButton[4];
        ship[0] = new JButton("Porta Aviões");     ship[0].setBounds(590,265,150,25); scr.add(ship[0]); ship[0].setBackground(Charcoal); ship[0].setForeground(Platinum);
        ship[1] = new JButton("Submarino");        ship[1].setBounds(590,300,150,25); scr.add(ship[1]); ship[1].setBackground(Charcoal); ship[1].setForeground(Platinum);
        ship[2] = new JButton("Navio de Escolta"); ship[2].setBounds(590,340,150,25); scr.add(ship[2]); ship[2].setBackground(Charcoal); ship[2].setForeground(Platinum);
        ship[3] = new JButton("Caça");             ship[3].setBounds(590,375,150,25); scr.add(ship[3]); ship[3].setBackground(Charcoal); ship[3].setForeground(Platinum);

        attackSelector = new JTextField(attackMode);       attackSelector.setBounds(590,230,150,25); attackSelector.setEditable(false); scr.add(attackSelector); attackSelector.setFont(defaultFont); attackSelector.setBackground(Charcoal); attackSelector.setForeground(Platinum);
        newGame = new JButton("Novo Jogo");                  newGame.setBounds(40, 620, 100, 25);                                         scr.add(newGame);        newGame.setFont(defaultFont);        newGame.setBackground(Charcoal);        newGame.setForeground(Platinum);
        restartGame = new JButton("Reiniciar Jogo");         restartGame.setBounds(485, 620, 100, 25);                                    scr.add(restartGame);    restartGame.setFont(defaultFont);    restartGame.setBackground(Charcoal);    restartGame.setForeground(Platinum);

    }
    public DrawGameAttack(Player target, Player source){
        super("Posicione seu ataque");
        screen = getContentPane();
        screen.setLayout(null);
        screen.setBackground(Gunmetal);
        setSize(760,700);

        drawGameAttack(screen, gridPos, restartGame, newGame, target, source);

        setVisible(true);
        setLocationRelativeTo(null);
    }
}
