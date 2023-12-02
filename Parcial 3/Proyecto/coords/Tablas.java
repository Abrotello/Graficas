package coords;

public class Tablas {

    private int[] puntosX = { 200, 200, 260, 1050, 1050, 990 };
    private int[] puntosY = { 500, 480, 450, 500, 480, 450 };
    private int[] puntosZ = { 10, 10, 10, 10, 10, 10 };

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

    public Tablas() {}
}
