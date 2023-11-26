public class Traslacion {

    private int x1, y1;  
    private int x2, y2;
    private int x3, y3;
    private int x4, y4;

    private int[][] resultado;

    private final int pasosX = 100;
    private final int pasosY = 100;

    private int[][] matrizT = {
        {1, 0, pasosX},
        {0, 1, pasosY},
        {0, 0, 1},
    };

    public Traslacion() {}

    public Traslacion(int x1_, int y1_, int x2_, int y2_, int x3_, int y3_, int x4_, int y4_) {

        this.x1 = x1_;
        this.y1 = y1_;
        
        this.x2 = x2_;
        this.y2 = y2_;
        
        this.x3 = x3_;
        this.y3 = y3_;
        
        this.x4 = x4_;
        this.y4 = y4_; 

    }

    public int[][] trasladar() {
        int[][] matrizP = {
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

        resultado = new int[columnasP][filasT];

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
