package coords;

public class Carteles {
    /*                        0     1    2    3    4    5    6    7    8                    */
    private int[] puntosX = { 100, 250, 100, 250, 120, 260, 260, 170, 190 };
    private int[] puntosY = { 230, 230, 150, 150, 140, 140, 215, 310, 310 };
    private int[] puntosZ = { 10, 10, 10, 10, 10, 10, 10, 10, 10 };

    public int[] cara;
    public int[] cara2;
    public int[] cara3;
    public int[] cara4;

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

    public int[] getCara() {
        return this.cara;
    }

    public void setCara(int[] cara) {
        this.cara = cara;
    }

    public int[] getCara2() {
        return this.cara2;
    }

    public void setCara2(int[] cara2) {
        this.cara2 = cara2;
    }

    public int[] getCara3() {
        return this.cara3;
    }

    public void setCara3(int[] cara3) {
        this.cara3 = cara3;
    }

    public int[] getCara4() {
        return this.cara4;
    }

    public void setCara4(int[] cara4) {
        this.cara4 = cara4;
    }

    public Carteles() {}

    public Carteles(int[] cara1, int[] cara2, int[] cara3, int[] cara4) {
        this.cara = cara1;
        this.cara2 = cara2;
        this.cara3 = cara3;
        this.cara4 = cara4;
    } 

}
