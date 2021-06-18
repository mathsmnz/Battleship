import java.util.Random;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        //DrawGame Draw = new DrawGame(1, "nome");
        
        /*Player player1 = new Player("Player1", null, null, null, null, 0, 0, 0);
        System.out.println("Hello, World!");
        DrawGame Draw = new DrawGame(1, "Jogue");
        player1  = Draw.returnPlayer;*/
        //Draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Player teste = new Player(null, null, null, null, null, 0, 0, 0);
        int[] i = {0,0};
        playerCreator p1 =  new playerCreator(i);
        teste = p1.p1;

        System.out.println(teste.caça.coordX);
        System.out.println(teste.sub.coordX);
        System.out.println(teste.escolta.coordX);
        System.out.println(teste.porta.coordX);

    }
}
