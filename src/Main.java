import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        Player player1 = new Player(null, null, null, null, null, 0, 0, 0);
        System.out.println("Hello, World!");
        DrawGame Draw = new DrawGame(2, "Jogue");
        player1  = Draw.p; 
        /*Draw = new DrawGame(2, "Jogue");
        Draw = new DrawGame(3, "Posicione suas peças");
        Draw = new DrawGame(1, "Posicione suas peças");*/
        System.out.println(player1.caça.Nome);
        //Draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
