public class Cubo {
    //                         A   B   C   D   E   F   G   H
    private int[] puntosX = { 100, 100, 300, 300, 100, 100, 300, 300 };
    private int[] puntosY = { 100, 300, 100, 300, 100, 300, 100, 300 };
    private int[] puntosZ = { 100, 100, 100, 100, 300, 300, 300, 300 };

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
