public class Player{
    String Nome;
    Ship porta;
    Ship sub;
    Ship escolta;
    Ship caça;
    int Score;
    int Mode;
    int playerCtrl;

    int[] portaY = {0,1,2,3};
    int[] escoltaY = {0,1,3};
    int[] caçaY = {0,1};
    int[] placeHolderX = {0};

    Ship defPorta = new airCarrier((short)4, placeHolderX, portaY, "Porta Aviões");
    Ship defSub = new submarine((short)2, placeHolderX, caçaY, "Submarino");
    Ship defEscolta = new escorteur((short)3, placeHolderX , escoltaY, "Navio de Escolta");
    Ship defCaça = new fighterJet((short)2, placeHolderX, caçaY, "Caça");

    public Player(String n, Ship p1, Ship p2, Ship p3, Ship p4, int score, int mode, int ctrl){
        this.porta = p1;
        this.sub = p2;
        this.escolta = p3;
        this.caça = p4;
        this.Score = score;
        this.Nome = n;
        this.playerCtrl = ctrl;
        this.Mode = mode;
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
