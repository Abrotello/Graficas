public class Cubo {
    //                         A   B   C   D   E   F   G   H
    private int[] puntosX = { 10, 10, 30, 30, 10, 10, 30, 30 };
    private int[] puntosY = { 10, 30, 10, 30, 10, 30, 10, 30 };
    private int[] puntosZ = { 10, 10, 10, 10, 30, 30, 30, 30 };

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
