import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawGame extends JFrame{
    public  JButton[][] gridPos;
    private JButton     restartGame;
    private JButton     newGame;

    public DrawGame(){
        //Starts the GUI
        super("Table 1");
        setSize(625,625);

        Container screen = getContentPane();
        screen.setLayout(null);
        
        JLabel label = new JLabel("Your table");
        label.setFont(new Font("Consolas",Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        screen.add(label);


        gridPos = new JButton[10][10];

        int x = 40;
        int y = 60;
        for(int a = 0; a < 10; a++){
            String text  = "A" + Integer.toString(a);
            gridPos[0][a] = new JButton(text); gridPos[0][a].setBounds (x, y, 50, 50); screen.add(gridPos[0][a]);
            x = x + 55;
        }

        x = 40;
        y = 115;
        for(int b = 0; b < 10; b++){
            String text  = "B" + Integer.toString(b);
            gridPos[1][b] = new JButton(text); gridPos[0][b].setBounds (x, y, 50, 50); screen.add(gridPos[0][b]);
            x = x + 55;
        }

        x = 40;
        y = 170;
        for(int c = 0; c < 10; c++){
            String text  = "C" + Integer.toString(c);
            gridPos[0][c] = new JButton(text); gridPos[0][c].setBounds (x, y, 50, 50); screen.add(gridPos[0][c]);
            x = x + 55;
        }

        x = 40;
        y = 225;
        for(int d = 0; d < 10; d++){
            String text  = "D" + Integer.toString(d);
            gridPos[0][d] = new JButton(text); gridPos[0][d].setBounds (x, y, 50, 50); screen.add(gridPos[0][d]);
            x = x + 55;
        }

        x = 40;
        y = 280;
        for(int e = 0; e < 10; e++){
            String text  = "E" + Integer.toString(e);
            gridPos[0][e] = new JButton(text); gridPos[0][e].setBounds (x, y, 50, 50); screen.add(gridPos[0][e]);
            x = x + 55;
        }

        x = 40;
        y = 335;
        for(int f = 0; f < 10; f++){
            String text  = "F" + Integer.toString(f);
            gridPos[0][f] = new JButton(text); gridPos[0][f].setBounds (x, y, 50, 50); screen.add(gridPos[0][f]);
            x = x + 55;
        }

        x = 40;
        y = 390;
        for(int g = 0; g < 10; g++){
            String text  = "F" + Integer.toString(g);
            gridPos[0][g] = new JButton(text); gridPos[0][g].setBounds (x, y, 50, 50); screen.add(gridPos[0][g]);
            x = x + 55;
        }

        x = 40;
        y = 445;
        for(int h = 0; h < 10; h++){
            String text  = "H" + Integer.toString(h);
            gridPos[0][h] = new JButton(text); gridPos[0][h].setBounds (x, y, 50, 50); screen.add(gridPos[0][h]);
            x = x + 55;
        }

        x = 40;
        y = 500;
        for(int i = 0; i < 10; i++){
            String text  = "I" + Integer.toString(i);
            gridPos[0][i] = new JButton(text); gridPos[0][i].setBounds (x, y, 50, 50); screen.add(gridPos[0][i]);
            x = x + 55;
        }



        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(100,50,100,20);
        exitButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Saindo do Jogo");
                    System.exit(0);
                }
            }
        );
        screen.add(exitButton);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
