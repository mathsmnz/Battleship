import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameHandler extends JFrame{
    int[] mode = {0,0};
    Player p1 = new Player(null, null, null, null, null, 0, 0, 0);
    Player p2 = new Player(null, null, null, null, null, 0, 0, 0);
    private Container screen;

    private GameHandler(){
        super("Insira seu nome!");
        setSize(348, 165);
        screen.setLayout(null);
        setBackground(new Color(32,44,57));
        setForeground(new Color(235,235,235));
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void genPlayer(){
        Random rand = new Random();
        int up  = 0;
        int[] x = {0};
        int y = 0;

        airCarrier s1;
        submarine  s2;
        escorteur  s3;
        fighterJet s4;

        System.out.println("Modo Aleatório");
        if(mode[0] == 1){
            //Generate airCarrier
            up = 9;
            x[0] =  rand.nextInt(up);
            up = 6;
            y = rand.nextInt(up);
            int[] a = {y, y+1,y+2,y+3};
            s1 = new airCarrier((short)4, x, a, "Porta Aviões");
            //Generate submarine
            up = 9;
            x[0] =  rand.nextInt(up);
            up = 8;
            y = rand.nextInt(up);
            int[] b = {y, y+1};
            s2 = new submarine((short)2, x, b, "Submarino");
            //Generate escorteur
            up = 9;
            x[0] =  rand.nextInt(up);
            up = 7;
            y = rand.nextInt(up);
            int[] c = {y, y+1, y + 2};
            s3 = new escorteur((short)2, x, c, "Navio de Escolta");
            //Generate fighterJet
            up = 9;
            x[0] =  rand.nextInt(up);
            up = 7;
            y = rand.nextInt(up);
            int[] d = {y, y+1};
            s3 = new escorteur((short)2, x, d, "Caça");
        }else if(mode[0] == 2){

        }else{

        }
        GameHandler draw = new GameHandler();
        
    }

    public void CreatePlayer(){
        while(true){            
            DrawGame gameStart = new DrawGame(1, "Escolha o modo");
            mode = gameStart.mode;
            if((mode[0] == 2) || (mode[0] == 3) || (mode[1] == 1)){
                genPlayer();
            }
            gameStart = new DrawGame(2, "Coloque suas peças");
        }
    }
}
