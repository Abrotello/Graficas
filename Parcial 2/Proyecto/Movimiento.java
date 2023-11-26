public class Movimiento {

    private int dx = 0, dy = 0;
    private double[][] matrizTraslacion = {{1, 0, dx},{0, 1, dy},{0, 0, 1}};
    private double[][] matrizEscalacion = {{dx, 0, 0}, {0, dy, 0}, {0, 0, 1}};

    public Movimiento(int dx_, int dy_) {
        this.dx = dx_;
        this.dy = dy_;
    }


    public double[][] traslacionCuadrado(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        
        double[][] matrizPuntos = {{x1, x2, x3, x4}, {y1, y2, y3, y4}, {1, 1, 1, 1}};


        int filasTraslacion = matrizTraslacion.length;
        int columnasTraslacion = matrizTraslacion[0].length;

        int filasPuntos = matrizPuntos.length;
        int columnasPuntos = matrizPuntos[0].length;

        if(columnasTraslacion != filasPuntos) {
            System.out.println("Las matrices no se pueden multiplicar");
        }
        
        double[][] resultado = new double[columnasPuntos][filasTraslacion];

        for(int i=0; i<filasTraslacion; i++) {
            for(int j=0; j<columnasPuntos; j++) {
                for(int k=0; k<columnasTraslacion; k++) {
                    resultado[j][i] += matrizTraslacion[i][k] * matrizPuntos[k][j];
                }
            }
        }


        return resultado;
    }

    public double[][] escalacionCuadrado(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        
        double[][] matrizPuntos = {{x1, x2, x3, x4}, {y1, y2, y3, y4}, {1, 1, 1, 1}};

        int filasEscalacion = matrizEscalacion.length;
        int columnasEscalacion = matrizEscalacion[0].length;

        int filasPuntos = matrizPuntos.length;
        int columnasPuntos = matrizPuntos[0].length;

        if(columnasEscalacion != filasPuntos) {
            System.out.println("Las matrices no se pueden multiplicar");
        }
        
        double[][] resultado = new double[columnasPuntos][filasEscalacion];

        for(int i=0; i<filasEscalacion; i++) {
            for(int j=0; j<columnasPuntos; j++) {
                for(int k=0; k<columnasEscalacion; k++) {
                    resultado[j][i] += matrizEscalacion[i][k] * matrizPuntos[k][j];
                }
            }
        }

        return resultado;
    }

    public int[][] traslacionCirculo(int xc, int yc) {
        
        int[][] matrizPuntos = {{xc, yc, 1}};

        int filasTraslacion = matrizTraslacion.length;
        int columnasTraslacion = matrizTraslacion[0].length;

        int filasPuntos = matrizPuntos[0].length;


        if(columnasTraslacion != filasPuntos) {
            System.out.println("Las matrices no se pueden multiplicar");
        }
        
        int[][] resultado = new int[filasTraslacion][1];
        
        for(int i=0; i<filasTraslacion; i++) {
            int suma = 0;
            for(int j=0; j<columnasTraslacion; j++) {
                suma += matrizTraslacion[i][j] * matrizPuntos[0][j];     
                System.out.println(matrizTraslacion[i][j] * matrizPuntos[0][j]);           
            }
            resultado[i][0] = suma;
        }
        
        return resultado;
    }

    public double[][] traslacionTriangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
        
        double[][] matrizPuntos = {{x1, x2, x3}, {y1, y2, y3}, {1, 1, 1}};


        int filasTraslacion = matrizTraslacion.length;
        int columnasTraslacion = matrizTraslacion[0].length;

        int filasPuntos = matrizPuntos.length;
        int columnasPuntos = matrizPuntos[0].length;

        if(columnasTraslacion != filasPuntos) {
            System.out.println("Las matrices no se pueden multiplicar");
        }
        
        double[][] resultado = new double[columnasPuntos][filasTraslacion];

        for(int i=0; i<filasTraslacion; i++) {
            for(int j=0; j<columnasPuntos; j++) {
                for(int k=0; k<columnasTraslacion; k++) {
                    resultado[j][i] += matrizTraslacion[i][k] * matrizPuntos[k][j];
                }
            }
        }


        return resultado;
    }

}
