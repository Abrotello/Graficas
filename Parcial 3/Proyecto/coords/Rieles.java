package coords;

public class Rieles {
    /*                         A    B     C    D                       */
    private int[] puntosX = { 500, 550, 800, 850 };
    private int[] puntosY = { 500, 500, 500, 500 };
    private int[] puntosZ = { 10,  10,  10, 10 };

    public int[] getPuntosX() {
        return this.puntosX;
    }

    public void setPuntosX(int[] puntosX) {
        this.puntosX = puntosX;
    }

    public int[] getPuntosY() {
        return this.puntosY;
    }

    public void setPuntosY(int[] puntosY) {
        this.puntosY = puntosY;
    }

    public int[] getPuntosZ() {
        return this.puntosZ;
    }

    public void setPuntosZ(int[] puntosZ) {
        this.puntosZ = puntosZ;
    }

    public Rieles() {}
}
