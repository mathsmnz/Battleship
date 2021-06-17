public abstract class Ship{
    String Nome;
    short TAM;
    int coordX[];
    int coordY[];

    public Ship(short tam, int X[], int Y[], String n){
        this.Nome = n;
        this.TAM = tam;
        this.coordY = Y;
        this.coordX = X;
    }
}
