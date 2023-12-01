package mov;

public class Transformacion3D {

    private int Tx, Ty, Tz;
    //Rotacion
    private double angulo;

    public Transformacion3D(int tx, int ty, int tz) {
        this.Tx = tx;
        this.Ty = ty;
        this.Tz = tz;
    }

    public Transformacion3D(double angulo_) {
        this.angulo = angulo_;
    }

    public Transformacion3D() {}

    public int[] trasladar(int x, int y, int z) {

        int[][] matrizT = {{1, 0, 0, Tx}, {0, 1, 0, Ty}, {0, 0, 1, Tz}};
        int[][] matrizP = {{x}, {y}, {z}, {1}};

        int[][] temp = new int[1][4];

        for(int i=0; i<matrizT.length; i++) {
            for(int j=0; j<matrizP[0].length; j++) {
                for(int k=0; k<matrizT[0].length; k++) {
                    temp[0][i] += matrizT[i][k] * matrizP[k][0];
                }
            }
        }

        int[] resultado = {temp[0][0], temp[0][1], temp[0][2]};
        return resultado;
    }

    public int[] escalar(int x, int y, int z) {
        
        int[][] matrizS = {{Tx, 0, 0, 0}, {0, Ty, 0, 0}, {0, 0, Tz, 0}};
        int[][] matrizP = {{x}, {y}, {z}, {1}};

        int[][] temp = new int[1][4];

        for(int i=0; i<matrizS.length; i++) {
            for(int j=0; j<matrizP[0].length; j++) {
                for(int k=0; k<matrizS[0].length; k++) {
                    temp[0][i] += matrizS[i][k] * matrizP[k][0];
                }
            }
        }
     
        int[] resultado = {temp[0][0], temp[0][1], temp[0][2]};
        return resultado;
    }

    public int[] rotar() {
        return null;
    }
}