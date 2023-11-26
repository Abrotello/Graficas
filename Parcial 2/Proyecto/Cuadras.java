import java.awt.Color;
import java.awt.image.BufferedImage;

public class Cuadras {
    Color blanco = Color.WHITE;
    Color pasto = new Color(76, 182, 13);
    Color arena = new Color(236, 226, 198);
    Color marfil = new Color(230, 214, 144);

    
    public Cuadras() {}

    public BufferedImage cuadra(BufferedImage image) {
        CoordenadasCuadras coordenadas = new CoordenadasCuadras();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras cuadra = new Figuras(buffer);

        //Cuadra 1
        cuadra.cuadrado(coordenadas.getCuadra1()[0], coordenadas.getCuadra1()[1], coordenadas.getCuadra1()[2], coordenadas.getCuadra1()[3], blanco, image);
        cuadra.rellenarRectangulo(coordenadas.getCuadra1()[0], coordenadas.getCuadra1()[1], coordenadas.getCuadra1()[2], coordenadas.getCuadra1()[3], pasto);
        //Cuadra 2
        cuadra.cuadrado(coordenadas.getCuadra2()[0], coordenadas.getCuadra2()[1], coordenadas.getCuadra2()[2], coordenadas.getCuadra2()[3], blanco, image);
        cuadra.rellenarRectangulo(coordenadas.getCuadra2()[0], coordenadas.getCuadra2()[1], coordenadas.getCuadra2()[2], coordenadas.getCuadra2()[3], arena);
        //Cuadra 3
        cuadra.cuadrado(coordenadas.getCuadra3()[0], coordenadas.getCuadra3()[1], coordenadas.getCuadra3()[2], coordenadas.getCuadra3()[3], blanco, image);
        cuadra.rellenarRectangulo(coordenadas.getCuadra3()[0], coordenadas.getCuadra3()[1], coordenadas.getCuadra3()[2], coordenadas.getCuadra3()[3], marfil);
        //Cuadra 4
        cuadra.cuadrado(coordenadas.getCuadra4()[0], coordenadas.getCuadra4()[1], coordenadas.getCuadra4()[2], coordenadas.getCuadra4()[3], blanco, image);
        cuadra.rellenarRectangulo(coordenadas.getCuadra4()[0], coordenadas.getCuadra4()[1], coordenadas.getCuadra4()[2], coordenadas.getCuadra4()[3], pasto);
        return image;
    }
}
