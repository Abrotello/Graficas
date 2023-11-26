public class Cartesiano {

    public Cartesiano() {}


    public int[][] productoCartesiano(int[] PuntoA, int[] PuntoB) {

        int columnas = 2;
        int filas = PuntoA.length;

        int[][] puntos = new int[columnas][filas];

        for(int i=0; i<PuntoA.length; i++) {
            for(int j=0; j<PuntoB.length; j++) {
                for(int k=0; k<columnas; k++) {
                    puntos[k][i] = PuntoA[i];
                    puntos[k][j] = PuntoB[j];
                    //System.out.println(puntos[k][i] + "," + puntos[k][j]);
                }
                System.out.println(PuntoA[i] + "," + PuntoB[j]);
                
            }
        }

        return puntos;
    }

}