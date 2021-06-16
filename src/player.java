public class player {
    String Nome;
    Ship porta;
    Ship sub;
    Ship escolta;
    Ship caça;
    int Score;
    boolean playerCtrl;

    int[] portaX = {0,0,0,0};
    int[] escoltaX = {0,0,0};
    int[] caçaX = {0,0};
    int[] placeHolderY = {0};

    Ship defPorta = new Ship((short) 4, portaX, placeHolderY, "Porta Aviões");
    Ship defSub = new Ship((short) 2, caçaX, placeHolderY, "Submarino");
    Ship defEscolta = new Ship((short) 3, escoltaX , placeHolderY, "Navio de Escolta");
    Ship defCaça = new Ship((short) 2, caçaX, placeHolderY, "Caça");

    public player(String n, Ship p1, Ship p2, Ship p3, Ship p4, int score, boolean ctrl){
        this.porta = p1;
        this.sub = p2;
        this.escolta = p3;
        this.caça = p4;
        this.Score = score;
        this.Nome = n;
        this.playerCtrl = ctrl;
    }
    void resetPlayer(){
        this.porta = defPorta;
        this.sub = defSub;
        this.escolta = defEscolta;
        this.caça = defCaça;
        this.Score = 0;
        this.Nome = "Player";
    }
}
