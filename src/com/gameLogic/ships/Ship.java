package com.gameLogic.ships;

public abstract class Ship {
    private String Nome;
    private short TAM;
    private int[] coordX;
    private int[] coordY;
    private int[] coordRem;

    public Ship(short tam, int[] X, int[] Y, int[] rem, String n) {
        this.setNome(n);
        this.setTAM(tam);
        this.setCoordY(Y);
        this.setCoordX(X);
        this.setCoordRem(rem);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public short getTAM() {
        return TAM;
    }

    public void setTAM(short TAM) {
        this.TAM = TAM;
    }

    public int[] getCoordX() {
        return coordX;
    }

    public void setCoordX(int[] coordX) {
        this.coordX = coordX;
    }

    public int[] getCoordY() {
        return coordY;
    }

    public void setCoordY(int[] coordY) {
        this.coordY = coordY;
    }

    public int[] getCoordRem() {
        return coordRem;
    }

    public void setCoordRem(int[] coordRem) {
        this.coordRem = coordRem;
    }
}
