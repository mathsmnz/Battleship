package com.executavel;

import com.gameLogic.DrawGame;

import javax.swing.*;

public class Main implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        DrawGame Draw = new DrawGame(1, "Inicie o jogo");
        while (!Draw.sucess) {
        }


        System.out.println("Draw.returnPlayer.Nome");
        
        /*com.gameLogic.Player player1 = new com.gameLogic.Player("Player1", null, null, null, null, 0, 0, 0);
        System.out.println("Hello, World!");
        com.gameLogic.DrawGame Draw = new com.gameLogic.DrawGame(1, "Jogue");
        player1  = Draw.returnPlayer;*/

        Draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*com.gameLogic.Player teste = new com.gameLogic.Player(null, null, null, null, null, 0, 0, 0);
        int[] i = {0,0};
        com.gameLogic.playerCreator p1 =  new com.gameLogic.playerCreator(i);
        teste = p1.p1;

        System.out.println(teste.caça.coordX);
        System.out.println(teste.sub.coordX);
        System.out.println(teste.escolta.coordX);
        System.out.println(teste.porta.coordX);*/

    }

    public void run() {
        // TODO Auto-generated method stub

    }
}
