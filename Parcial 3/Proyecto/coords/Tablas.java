package coords;

public class Tablas {

    private int[] puntosX = { 350, 350, 410, 920, 920, 860 };
    private int[] puntosY = { 550, 530, 500, 550, 530, 500 }; 
    private int[] puntosZ = { 10, 10, 10, 10, 10, 10 };

    public int[][] cara;
    public int[][] cara2;

    public int[][] getCara() {
        return this.cara;
    }

    public void setCara(int[][] cara) {
        this.cara = cara;
    }

    public int[][] getCara2() {
        return this.cara2;
    }

    public void setCara2(int[][] cara2) {
        this.cara2 = cara2;
    }

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

    public Tablas(int[][] cara1, int[][] cara2) {
        this.cara = cara1;
        this.cara2 = cara2;
    }
}
