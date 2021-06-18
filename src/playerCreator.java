import java.util.Random;
public class playerCreator {
    int[] mode = {0,0};
    Player p1 = new Player(null, null, null, null, null, 0, 0, 0);

    private void genShips(){
        Random rand = new Random();
        int up  = 0;
        int[] x1 = {0};
        int[] x2 = {0};
        int[] x3 = {0};
        int[] x4 = {0};

        int y = 0;

        airCarrier s1;
        submarine  s2;
        escorteur  s3;
        fighterJet s4;

            //Generate airCarrier
            up = 9;
            x1[0] =  rand.nextInt(up);
            
            while((x1[0] == x2[0]) || (x1[0] == x3[0]) || (x1[0] == x4[0])){
                x1[0] =  rand.nextInt(up);
            }

            up = 6;
            y = rand.nextInt(up);
            int[] a = {y, y+1,y+2,y+3};
            s1 = new airCarrier((short)4, x1, a, "Porta Aviões");
            p1.porta = s1;

            //Generate submarine
            up = 9;
            x2[0] =  rand.nextInt(up);

            while((x2[0] == x3[0]) || (x2[0] == x4[0]) || (x2[0] == x3[0])){
                x2[0] =  rand.nextInt(up);
            }

            up = 8;
            y = rand.nextInt(up);

            while((y == s1.coordY[0])){
                y =  rand.nextInt(up);
            }

            int[] b = {y, y+1};
            s2 = new submarine((short)2, x2, b, "Submarino");
            p1.sub = s2;

            //Generate escorteur
            up = 9;
            x3[0] =  rand.nextInt(up);

            while((x3[0] == x4[0]) || (x3[0] == x1[0]) || (x3[0] == x2[0])){
                x3[0] =  rand.nextInt(up);
            }

            up = 7;
            y = rand.nextInt(up);

            while((y == s2.coordY[0]) || (y == s1.coordY[0])){
                y =  rand.nextInt(up);
            }

            int[] c = {y, y+1, y + 2};
            s3 = new escorteur((short)2, x3, c, "Navio de Escolta");
            p1.escolta = s3;

            //Generate fighterJet
            up = 9;
            x4[0] =  rand.nextInt(up);

            while((x4[0] == x1[0]) || (x4[0] == x2[0]) || (x4[0] == x3[0])){
                x4[0] =  rand.nextInt(up);
            }

            up = 7;
            y = rand.nextInt(up);

            while((y == s3.coordY[0]) || (y == s2.coordY[0]) || (y == s1.coordY[0])){
                y =  rand.nextInt(up);
            }

            int[] d = {y, y+1};
            s4 = new fighterJet((short)2, x4, d, "Caça");
            p1.caça = s4;

    }

    public Player returnPlayer(){
        return p1;
    }

    public playerCreator(int[] Mode){
        this.mode = Mode;
        genShips();
        p1.Nome = "Player1";
        p1.Mode = 1;
    }
}
