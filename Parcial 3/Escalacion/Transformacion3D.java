public class Transformacion3D {

    //Traslacion
    private int Tx, Ty, Tz;
    //Escalacion
    private float Sx, Sy, Sz;
    //Rotacion
    private double angulo;

    public Transformacion3D(int tx, int ty, int tz) {
        this.Tx = tx;
        this.Ty = ty;
        this.Tz = tz;
    }

    public Transformacion3D(float sx, float sy, float sz) {
        this.Sx = sx;
        this.Sy = sy;
        this.Sz = sz;
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
        
        float[][] matrizS = {{Sx, 0, 0, 0}, {0, Sy, 0, 0}, {0, 0, Sz, 0}};
        float[][] matrizP = {{x}, {y}, {z}, {1}};

        float[][] temp = new float[1][4];

        for(int i=0; i<matrizS.length; i++) {
            for(int j=0; j<matrizP[0].length; j++) {
                for(int k=0; k<matrizS[0].length; k++) {
                    temp[0][i] += matrizS[i][k] * matrizP[k][0];
                }
            }
        }
     
        int[] resultado = {(int)temp[0][0], (int)temp[0][1], (int)temp[0][2]};
        return resultado;
    }

    public int[] rotar() {
        return null;
    }
}