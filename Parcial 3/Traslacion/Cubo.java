public class Cubo {
    /*                         A   B   C   D   E   F   G   H               */
    private int[] puntosX = { 50, 150, 50, 150, 50, 150, 50, 150 };
    private int[] puntosY = { 150, 150, 250, 250, 150, 150, 250, 250 };
    private int[] puntosZ = { 150, 150, 150, 150, 250, 250, 250, 250 };

    public int[] getPuntosX() {
        return this.puntosX;
    }

    public int[] getPuntosY() {
        return this.puntosY;
    }

    public int[] getPuntosZ() {
        return this.puntosZ;
    }
    
    public Cubo() {}

}
