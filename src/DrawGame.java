import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawGame extends JFrame{
    public  JButton[][] gridPos;
    public  Container   screen;
    private JButton     restartGame;
    private JButton     newGame;

    void DrawButton(int x, int y, int i,Container scr){
        for(int a = 0; a < 10; a++){
            String text  = "X" + Integer.toString(a);
            gridPos[i][a] = new JButton(text); gridPos[i][a].setBounds (x, y, 50, 50); scr.add(gridPos[i][a]);
            x = x + 55;
        }
    }

    public DrawGame(){
        //Starts the GUI
        super("Table 1");
        setSize(625,680);

        screen = getContentPane();
        screen.setLayout(null);
        
        JLabel label = new JLabel("Your table");
        label.setFont(new Font("Consolas",Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        screen.add(label);


        gridPos = new JButton[10][10];

        int x = 40;
        int y = 60;
        DrawButton(40, 60,  0, screen);
        DrawButton(40, 115, 1, screen);
        DrawButton(40, 170, 2, screen);
        DrawButton(40, 225, 3, screen);
        DrawButton(40, 280, 4, screen);
        DrawButton(40, 335, 5, screen);
        DrawButton(40, 390, 6, screen);
        DrawButton(40, 445, 7, screen);
        DrawButton(40, 500, 8, screen);
        DrawButton(40, 555, 9, screen);

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
