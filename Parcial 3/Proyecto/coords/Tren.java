package coords;

public class Tren {
    /*                         0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30  31   32  */
    private int[] puntosX = { 670, 610, 610, 670, 658, 622, 660, 620, 620, 660, 660, 620, 620, 660, 640, 665, 615, 663, 617, 661, 619, 659, 621, 657, 623, 655, 625, 653, 627, 651, 630, 653, 633 };
    /*                         0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19  20  21  22  23  24  25  26  27  28  29  30  31  32           */
    private int[] puntosY = { 125, 125, 185, 185, 130, 130, 135, 135, 150, 150, 160, 160, 165, 165, 180, 110, 110, 100, 100, 90, 90, 80, 80, 70, 70, 60, 60, 50, 50, 40, 40, 30, 30 };
    private int[] puntosZ = { 10 };

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

    public Tren() {}
}
