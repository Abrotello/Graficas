public class CoordenadasCuadras {

    //Cuadras
    private int[] cuadra1 = { 780, -10, 1280, 280 }; //Futbol
    private int[] cuadra2 = { 780, 420, 1280, 730 }; //Alberca
    private int[] cuadra3 = { -10, -10, 490, 280 }; //Casona
    private int[] cuadra4 = {0, 420, 490, 1280}; //Parque
 
    //Uniones
    private int[] union1 = { 490, 200, 450, 280 };
    private int[] union2 = { 450, 420, 490, 495 };
    private int[] union3 = { 790, 200, 820, 280 };
    private int[] union4 = { 820, 420, 790, 495 };

    public CoordenadasCuadras() {}

    //Cuadras
    public int[] getCuadra1() {
        return this.cuadra1;
    }

    public int[] getCuadra2() {
        return this.cuadra2;
    }

    public int[] getCuadra3() {
        return this.cuadra3;
    }

    public int[] getCuadra4() {
        return this.cuadra4;
    }

    //Uniones
    public int[] getUnion1() {
        return this.union1;
    }

    public int[] getUnion2() {
        return this.union2;
    }

    public int[] getUnion3() {
        return this.union3;
    }

    public int[] getUnion4() {
        return this.union4;
    }

}
