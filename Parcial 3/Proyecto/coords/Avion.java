package coords;

public class Avion {
    /*                         0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30  31   32   33  */
    private int[] puntosX = { 520, 490, 475, 520, 555, 520, 520, 555, 655, 570, 555, 655, 555, 480, 460, 540, 460, 530, 695, 600, 580, 700, 695, 585, 580, 600, 620, 555, 555, 620, 540, 530, 530, 540 };
    /*                         0   1  2   3   4   5   6    7   8    9   10   11  12  13  14  15  16  17  18  19  20  21  22   23  24  25  26  27  28  29  30  31  32  33                                 */
    private int[] puntosY = { 60, 50, 60, 80, 70, 55, 90, 100, 100, 80, 95, 130, 35, 15, 20, 50, 30, 55, 70, 45, 65, 90, 100, 70, 20, 25, 22, 18, 25, 35, 80, 75, 80, 85 };
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

    public Avion() {}
}
