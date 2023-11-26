public class Escalacion {

    private int x1, y1;  
    private int x2, y2;
    private int x3, y3;
    private int x4, y4;

    private double[][] resultado;

    private final double pasosX = 0.2; //0.2
    private final double pasosY = 0.2; //0.2

    private double[][] matrizT = {
        {pasosX, 0, 0},
        {0, pasosY, 0},
        {0, 0, 1},
    };

    public Escalacion() {}

    public Escalacion(int x1_, int y1_, int x2_, int y2_, int x3_, int y3_, int x4_, int y4_) {

        this.x1 = x1_;
        this.y1 = y1_;
        
        this.x2 = x2_;
        this.y2 = y2_;
        
        this.x3 = x3_;
        this.y3 = y3_;
        
        this.x4 = x4_;
        this.y4 = y4_; 

    }

    public double[][] escalar() {
        double[][] matrizP = {
            {x1, x2, x3, x4},
            {y1, y2, y3, y4},
            {1, 1, 1, 1},
        };

        int filasT = matrizT.length;
        int columnasT = matrizT[0].length;
        
        int filasP = matrizP.length;
        int columnasP = matrizP[0].length;

        if(columnasT != filasP) {
            System.out.println("Las matrices no se pueden multiplicar");
        }

        resultado = new double[columnasP][filasT];

        for(int i=0; i<filasT; i++) {
            for(int j=0; j<columnasP; j++) {
                for(int k=0; k<columnasT; k++) {
                    resultado[j][i] += matrizT[i][k] * matrizP[k][j];
                }
            }
        }
        return resultado;
    }
}
