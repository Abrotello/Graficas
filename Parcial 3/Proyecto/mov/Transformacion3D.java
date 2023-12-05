package mov;

public class Transformacion3D {

    private float Tx, Ty, Tz;
    

    public Transformacion3D(float tx, float ty, float tz) {
        this.Tx = tx;
        this.Ty = ty;
        this.Tz = tz;
    }


    public Transformacion3D() {}

    public int[] trasladar(int x, int y, int z) {

        float[][] matrizT = {{1, 0, 0, Tx}, {0, 1, 0, Ty}, {0, 0, 1, Tz}};
        float[][] matrizP = {{x}, {y}, {z}, {1}};

        float[][] temp = new float[1][4];

        for(int i=0; i<matrizT.length; i++) {
            for(int j=0; j<matrizP[0].length; j++) {
                for(int k=0; k<matrizT[0].length; k++) {
                    temp[0][i] += matrizT[i][k] * matrizP[k][0];
                }
            }
        }

        int[] resultado = {(int)temp[0][0], (int)temp[0][1], (int)temp[0][2]};
        return resultado;
    }

    public int[] escalar(int x, int y, int z) {
        
        float[][] matrizS = {{Tx, 0, 0, 0}, {0, Ty, 0, 0}, {0, 0, Tz, 0}};
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
}