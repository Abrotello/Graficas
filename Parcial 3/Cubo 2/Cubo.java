public class Cubo {
    //                         A   B   C   D   E   F   G   H
    private int[] puntosX = { 1, 1, 3, 3, 1, 1, 3, 3 };
    private int[] puntosY = { 1, 3, 1, 3, 1, 3, 1, 3 };
    private int[] puntosZ = { 1, 1, 1, 1, 3, 3, 3, 3 };

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
