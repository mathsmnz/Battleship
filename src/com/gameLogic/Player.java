package com.gameLogic;

import com.gameLogic.ships.*;

import java.util.ArrayList;

public class Player {
    final int[] portaY = {0, 1, 2, 3};
    final int[] escoltaY = {0, 1, 3};
    final int[] caçaY = {0, 1};
    final int[] placeHolderX = {0};
    final Ship defPorta = new airCarrier((short) 4, placeHolderX, portaY, null, "Porta Aviões");
    final Ship defSub = new submarine((short) 2, placeHolderX, caçaY, null, "Submarino");
    final Ship defEscolta = new escorteur((short) 3, placeHolderX, escoltaY, null, "Navio de Escolta");
    final Ship defCaça = new fighterJet((short) 2, placeHolderX, caçaY, null, "Caça");
    public String Nome;
    public Ship porta;
    public Ship sub;
    public Ship escolta;
    public Ship caça;
    public int Score;
    public int dica;
    public int Mode;   //Diz se é IA ou não
    public int playerCtrl; //Diz se é player 1 ou 2
    public boolean cooldown;
    public ArrayList<String> attackHist;
    public int cooldownCount;

    public Player(String n, Ship p1, Ship p2, Ship p3, Ship p4, int score, int mode, int ctrl, int dica, boolean b, int c, ArrayList<String> attH) {
        this.porta = p1;
        this.sub = p2;
        this.escolta = p3;
        this.caça = p4;
        this.Score = score;
        this.Nome = n;
        this.playerCtrl = ctrl;
        this.Mode = mode;
        this.cooldown = b;
        this.attackHist = attH;
        this.dica = dica;
        this.cooldownCount = c;
    }

    void resetPlayer() {
        this.porta = defPorta;
        this.sub = defSub;
        this.escolta = defEscolta;
        this.caça = defCaça;
        this.Score = 0;
        this.Nome = "com.gameLogic.Player";
        this.playerCtrl = 0;
        this.Mode = 0;
        this.cooldown = false;
        this.attackHist = null;
        this.dica = 0;
        this.cooldownCount = 0;
    }
}
