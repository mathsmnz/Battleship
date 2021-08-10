package com.gameLogic;

import com.gameLogic.ships.airCarrier;
import com.gameLogic.ships.escorteur;
import com.gameLogic.ships.fighterJet;
import com.gameLogic.ships.submarine;

import java.util.Random;

public class playerCreator {
    final Player p1 = new Player(null, null, null, null, null, 0, 0, 0, 0, false, 0, null);
    int[] mode = {0, 0};

    public playerCreator(int ctrl) {
        genShips();
        if (ctrl == 1) {
            p1.Nome = "com.gameLogic.Player 1";
        } else {
            p1.Nome = "com.gameLogic.Player 2";
        }
    }

    private void genShips() {
        Random rand = new Random();
        int up = 0;
        int[] x1 = {0};
        int[] x2 = {0};
        int[] x3 = {0};
        int[] x4 = {0};

        int y = 0;

        airCarrier s1;
        submarine s2;
        escorteur s3;
        fighterJet s4;

        //Generate com.gameLogic.ships.airCarrier
        up = 9;
        x1[0] = rand.nextInt(up);

            /*while((x1[0] == x2[0]) || (x1[0] == x3[0]) || (x1[0] == x4[0])){
                x1[0] =  rand.nextInt(up);
            }*/

        up = 6;
        y = rand.nextInt(up);
        int[] a = {y, y + 1, y + 2, y + 3};
        int[] r1 = {11, 11, 11, 11};
        s1 = new airCarrier((short) 4, x1, a, r1, "Porta Aviões");
        p1.porta = s1;

        //Generate com.gameLogic.ships.submarine
        up = 9;
        x2[0] = rand.nextInt(up);

        while (x2[0] == x3[0] || x2[0] == x1[0]) {
            x2[0] = rand.nextInt(up);
        }

        up = 8;
        y = rand.nextInt(up);

        while ((y == s1.getCoordY()[0])) {
            y = rand.nextInt(up);
        }

        int[] b = {y, y + 1};
        int[] r2 = {11, 11};
        s2 = new submarine((short) 2, x2, b, r2, "Submarino");
        p1.sub = s2;

        //Generate com.gameLogic.ships.escorteur
        up = 9;
        x3[0] = rand.nextInt(up);

        while ((x3[0] == x4[0]) || (x3[0] == x1[0]) || (x3[0] == x2[0])) {
            x3[0] = rand.nextInt(up);
        }

        up = 7;
        y = rand.nextInt(up);

        while ((y == s2.getCoordY()[0]) || (y == s1.getCoordY()[0])) {
            y = rand.nextInt(up);
        }

        int[] c = {y, y + 1, y + 2};
        int[] r3 = {11, 11, 11};
        s3 = new escorteur((short) 3, x3, c, r3, "Navio de Escolta");
        p1.escolta = s3;

        //Generate com.gameLogic.ships.fighterJet
        up = 9;
        x4[0] = rand.nextInt(up);

        while ((x4[0] == x1[0]) || (x4[0] == x2[0]) || (x4[0] == x3[0])) {
            x4[0] = rand.nextInt(up);
        }

        up = 7;
        y = rand.nextInt(up);

        while ((y == s3.getCoordY()[0]) || (y == s2.getCoordY()[0]) || (y == s1.getCoordY()[0])) {
            y = rand.nextInt(up);
        }

        int[] d = {y, y + 1};
        int[] r4 = {11, 11};
        s4 = new fighterJet((short) 2, x4, d, r4, "Caça");
        p1.caça = s4;
        p1.cooldownCount = 0;
        p1.dica = 3;

    }

    public Player returnPlayer() {
        return p1;
    }
}
