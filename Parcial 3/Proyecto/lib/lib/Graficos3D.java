package lib;

public class Graficos3D {
    
    public Graficos3D() {}

    public double calcularUParalela(int z, int zp) {
        return (z/zp);
    }

    public double calcularXParalela(int x1, double u, int xp) {
        return x1 + (xp * u);
    }

    public double calcularYParalela(int y1, double u, int yp) {
        return y1 + (yp * u);
    }

    public double calcularUPerspectiva(int z, int zp) {
        return ((-1 * zp) / (z - zp));
    }

    public double calcularXPerspectiva(int x1, double u, int xp) {
        return xp + ((x1 - xp) * u);
    }

    public double calcularYPerspectiva(int y1, double u, int yp) {
        return yp + ((y1 - yp) * u);
    }

}
