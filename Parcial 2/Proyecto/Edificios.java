import java.awt.Color;
import java.awt.image.BufferedImage;

public class Edificios {

    CoordenadasEdificios coordenadas = new CoordenadasEdificios();
    Color negro = Color.BLACK;
    Color blanco = new Color(255, 255, 255);
    Color sombra = new Color(0, 0, 0, 100);
    Color techo = new Color(227, 230, 230);
    Color arena = new Color(236, 226, 198);
    Color pasto = new Color(76, 182, 13);
    Color pastoClaro = new Color(100, 215, 30);
    Color agua = new Color(200, 242, 235);
    Color cafe = new Color(128, 64, 0);

    public Edificios() {}

    public BufferedImage casas(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras casitas = new Figuras(buffer);

        //Casita 1 
        casitas.cuadrado(coordenadas.getCasa1()[0], coordenadas.getCasa1()[1], coordenadas.getCasa1()[2], coordenadas.getCasa1()[3], blanco, image);
        casitas.rellenarRectangulo(coordenadas.getCasa1()[0]+5, coordenadas.getCasa1()[1]+5, coordenadas.getCasa1()[2]+5, coordenadas.getCasa1()[3]+5, sombra);
        casitas.rellenarRectangulo(coordenadas.getCasa1()[0], coordenadas.getCasa1()[1], coordenadas.getCasa1()[2], coordenadas.getCasa1()[3], blanco);
        casitas.rellenarRectangulo(coordenadas.getTecho1()[0], coordenadas.getTecho1()[1], coordenadas.getTecho1()[2], coordenadas.getTecho1()[3], techo);
        //Casita 2 
        casitas.cuadrado(coordenadas.getCasa2()[0], coordenadas.getCasa2()[1], coordenadas.getCasa2()[2], coordenadas.getCasa2()[3], blanco, image);
        casitas.rellenarRectangulo(coordenadas.getCasa2()[0]+5, coordenadas.getCasa2()[1]+5, coordenadas.getCasa2()[2]+5, coordenadas.getCasa2()[3]+5, sombra);
        casitas.rellenarRectangulo(coordenadas.getCasa2()[0], coordenadas.getCasa2()[1], coordenadas.getCasa2()[2], coordenadas.getCasa2()[3], blanco);
        casitas.rellenarRectangulo(coordenadas.getTecho2()[0], coordenadas.getTecho2()[1], coordenadas.getTecho2()[2], coordenadas.getTecho2()[3], techo);
        //Casita 3 
        casitas.cuadrado(coordenadas.getCasa3()[0], coordenadas.getCasa3()[1], coordenadas.getCasa3()[2], coordenadas.getCasa3()[3], blanco, image);
        casitas.rellenarRectangulo(coordenadas.getCasa3()[0]+5, coordenadas.getCasa3()[1]+5, coordenadas.getCasa3()[2]+5, coordenadas.getCasa3()[3]+5, sombra);
        casitas.rellenarRectangulo(coordenadas.getCasa3()[0], coordenadas.getCasa3()[1], coordenadas.getCasa3()[2], coordenadas.getCasa3()[3], blanco);
        casitas.rellenarRectangulo(coordenadas.getTecho3()[0], coordenadas.getTecho3()[1], coordenadas.getTecho3()[2], coordenadas.getTecho3()[3], techo);        
        //Casita 4 
        casitas.cuadrado(coordenadas.getCasa4()[0], coordenadas.getCasa4()[1], coordenadas.getCasa4()[2], coordenadas.getCasa4()[3], blanco, image);
        casitas.rellenarRectangulo(coordenadas.getCasa4()[0]+5, coordenadas.getCasa4()[1]+5, coordenadas.getCasa4()[2]+5, coordenadas.getCasa4()[3]+5, sombra);
        casitas.rellenarRectangulo(coordenadas.getCasa4()[0], coordenadas.getCasa4()[1], coordenadas.getCasa4()[2], coordenadas.getCasa4()[3], blanco);
        casitas.rellenarRectangulo(coordenadas.getTecho4()[0], coordenadas.getTecho4()[1], coordenadas.getTecho4()[2], coordenadas.getTecho4()[3], techo);
        //Casita 5
        casitas.cuadrado(coordenadas.getCasa5()[0], coordenadas.getCasa5()[1], coordenadas.getCasa5()[2], coordenadas.getCasa5()[3], blanco, image);
        casitas.rellenarRectangulo(coordenadas.getCasa5()[0]+5, coordenadas.getCasa5()[1]+5, coordenadas.getCasa5()[2]+5, coordenadas.getCasa5()[3]+5, sombra);
        casitas.rellenarRectangulo(coordenadas.getCasa5()[0], coordenadas.getCasa5()[1], coordenadas.getCasa5()[2], coordenadas.getCasa5()[3], blanco);
        casitas.rellenarRectangulo(coordenadas.getTecho5()[0], coordenadas.getTecho5()[1], coordenadas.getTecho5()[2], coordenadas.getTecho5()[3], techo);        
        
        return image;
    }

    public BufferedImage canchas(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        BufferedImage buffer2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras pista = new Figuras(buffer);
        Figuras cancha = new Figuras(buffer2);

        //Pista
        pista.cuadrado(coordenadas.getPista()[0], coordenadas.getPista()[1], coordenadas.getPista()[2], coordenadas.getPista()[3], arena, image);
        pista.rellenarRectangulo(coordenadas.getPista()[0], coordenadas.getPista()[1], coordenadas.getPista()[2], coordenadas.getPista()[3], arena);
        //Cancha
        cancha.cuadrado(coordenadas.getCancha()[0], coordenadas.getCancha()[1], coordenadas.getCancha()[2], coordenadas.getCancha()[3], pasto, image);
        cancha.rellenarRectangulo(coordenadas.getCancha()[0], coordenadas.getCancha()[1], coordenadas.getCancha()[2], coordenadas.getCancha()[3], pasto);
        cancha.cuadrado(coordenadas.getPasto()[0], coordenadas.getPasto()[1], coordenadas.getPasto()[2], coordenadas.getPasto()[3], pastoClaro, image);
        cancha.rellenarRectangulo(coordenadas.getPasto()[0], coordenadas.getPasto()[1], coordenadas.getPasto()[2], coordenadas.getPasto()[3], pastoClaro);
        cancha.rellenarRectangulo(coordenadas.getPasto()[0], coordenadas.getPasto()[1]+48, coordenadas.getPasto()[2], coordenadas.getPasto()[3]+50, pastoClaro);
        cancha.rellenarRectangulo(coordenadas.getPasto()[0], coordenadas.getPasto()[1]+100, coordenadas.getPasto()[2], coordenadas.getPasto()[3]+100, pastoClaro);
        //Lineas
        cancha.cuadrado(coordenadas.getCancha()[0]+6, coordenadas.getCancha()[1]+6, coordenadas.getCancha()[2]-6, coordenadas.getCancha()[3]-6, Color.WHITE, image);
        cancha.circulo(1140, 115, 16, 0, Color.WHITE, image);
        cancha.bresenham(1065, 115, 1215, 115, Color.WHITE, image);
        return image;
    }

    public BufferedImage adornos(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Curvas reja = new Curvas(buffer);
        Curvas solCurvas = new Curvas(buffer);

        reja.parametrica(image, 820, 230, 2, 4, blanco);
        reja.parametrica(image, 870, 230, 2, 4, blanco);
        reja.parametrica(image, 920, 230, 2, 4, blanco);
        reja.parametrica(image, 1020, 230, 2, 4, blanco);
        reja.parametrica(image, 1120, 230, 2, 4, blanco);
        
        solCurvas.sol(image, 640, 345, 2, 2, Color.BLUE);
        
        reja.parametrica(image, 800, 650, 2, 4, negro);
        reja.parametrica(image, 850, 650, 2, 4, negro);
        reja.parametrica(image, 900, 650, 2, 4, negro);
        reja.parametrica(image, 950, 650, 2, 4, negro);
        reja.parametrica(image, 1000, 650, 2, 4, negro);
        reja.parametrica(image, 1050, 650, 2, 4, negro);
        reja.parametrica(image, 1100, 650, 2, 4, negro);
        reja.parametrica(image, 1150, 650, 2, 4, negro);

        return image;
    }

    public BufferedImage alberca(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
        BufferedImage buffer1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Curvas curvas = new Curvas(buffer);
        Figuras relleno = new Figuras(buffer);
        Curvas humitos = new Curvas(buffer1);

        curvas.infinito(image, 1050, 550, 3, 3, 40, negro);
        relleno.floodFill(1040, 550, image.getRGB(1055, 550), image, agua);
        relleno.floodFill(1100, 550, image.getRGB(1100, 550), image, agua);

        BufferedImage buffer2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras arenero = new Figuras(buffer2);

        //Arenero 1
        arenero.cuadrado(coordenadas.getArenero1()[0], coordenadas.getArenero1()[1], coordenadas.getArenero1()[2], coordenadas.getArenero1()[3], negro, image);
        arenero.rellenarRectangulo(coordenadas.getArenero1()[0]+2, coordenadas.getArenero1()[1]+2, coordenadas.getArenero1()[2]+2, coordenadas.getArenero1()[3]+2, sombra);
        arenero.rellenarRectangulo(coordenadas.getArenero1()[0], coordenadas.getArenero1()[1], coordenadas.getArenero1()[2], coordenadas.getArenero1()[3], cafe);
        arenero.circulo(820, 460, 5, 0, negro, image);
        arenero.floodFill(820, 460, image.getRGB(821, 461), image, negro);
        humitos.humito(image, 820, 455, 5, 4, blanco);

        //Arenero 2
        arenero.cuadrado(coordenadas.getArenero2()[0], coordenadas.getArenero2()[1], coordenadas.getArenero2()[2], coordenadas.getArenero2()[3], negro, image);
        arenero.rellenarRectangulo(coordenadas.getArenero2()[0]+2, coordenadas.getArenero2()[1]+2, coordenadas.getArenero2()[2]+2, coordenadas.getArenero2()[3]+2, sombra);
        arenero.rellenarRectangulo(coordenadas.getArenero2()[0], coordenadas.getArenero2()[1], coordenadas.getArenero2()[2], coordenadas.getArenero2()[3], cafe);
        arenero.circulo(820, 530, 5, 0, negro, image);
        arenero.floodFill(820, 530, image.getRGB(821, 531), image, negro);
        humitos.humito(image, 820, 525, 5, 4, blanco);

        //Arenero 3
        arenero.cuadrado(coordenadas.getArenero3()[0], coordenadas.getArenero3()[1], coordenadas.getArenero3()[2], coordenadas.getArenero3()[3], negro, image);
        arenero.rellenarRectangulo(coordenadas.getArenero3()[0]+2, coordenadas.getArenero3()[1]+2, coordenadas.getArenero3()[2]+2, coordenadas.getArenero3()[3]+2, sombra);
        arenero.rellenarRectangulo(coordenadas.getArenero3()[0], coordenadas.getArenero3()[1], coordenadas.getArenero3()[2], coordenadas.getArenero3()[3], cafe);
        arenero.circulo(820, 600, 5, 0, negro, image);
        arenero.floodFill(820, 600, image.getRGB(821, 601), image, negro);
        humitos.humito(image, 820, 595, 5, 4, blanco);

        return image;
    }

    public BufferedImage casona(BufferedImage image) {
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras casona = new Figuras(buffer);
        Curvas curvas = new Curvas(bufferedImage);

        //Casa
        casona.cuadrado(coordenadas.getCasa6()[0], coordenadas.getCasa6()[1], coordenadas.getCasa6()[2], coordenadas.getCasa6()[3], negro, image);
        casona.rellenarRectangulo(coordenadas.getCasa6()[0]+5, coordenadas.getCasa6()[1]+5, coordenadas.getCasa6()[2]+5, coordenadas.getCasa6()[3]+5, sombra);
        casona.rellenarRectangulo(coordenadas.getCasa6()[0], coordenadas.getCasa6()[1], coordenadas.getCasa6()[2], coordenadas.getCasa6()[3], blanco);
        casona.rellenarRectangulo(coordenadas.getTecho6()[0], coordenadas.getTecho6()[1], coordenadas.getTecho6()[2], coordenadas.getTecho6()[3], techo);

        //Jardin
        casona.cuadrado(coordenadas.getJardin()[0], coordenadas.getJardin()[1], coordenadas.getJardin()[2], coordenadas.getJardin()[3], pasto, image);
        casona.rellenarRectangulo(coordenadas.getJardin()[0]-5, coordenadas.getJardin()[1]-5, coordenadas.getJardin()[2]+5, coordenadas.getJardin()[3]+5, arena);
        casona.rellenarRectangulo(coordenadas.getJardin()[0], coordenadas.getJardin()[1], coordenadas.getJardin()[2], coordenadas.getJardin()[3], pasto);
        casona.cuadrado(coordenadas.getPastoJardin()[0]+1, coordenadas.getPastoJardin()[1], coordenadas.getPastoJardin()[2]-1, coordenadas.getPastoJardin()[3], pastoClaro, image);     
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1], coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3], pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+20, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+20, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+40, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+40, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+60, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+60, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+80, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+80, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+100, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+100, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+120, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+120, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+140, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+140, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+160, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+160, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+180, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+180, pastoClaro);
        casona.rellenarRectangulo(coordenadas.getPastoJardin()[0], coordenadas.getPastoJardin()[1]+200, coordenadas.getPastoJardin()[2], coordenadas.getPastoJardin()[3]+200, pastoClaro);
        
        casona.circulo(50, 220, 25, 0, negro, image);
        casona.floodFill(50, 220, image.getRGB(55, 225), image, negro);
        casona.circulo(50, 220, 15, 0, techo, image);
        casona.floodFill(50, 220, image.getRGB(52, 222), image, techo);
        casona.circulo(50, 220, 10, 0, Color.blue, image);
        casona.floodFill(50, 220, image.getRGB(50, 220), image, agua);

        curvas.flor(image, 150, 190, 10, 10, cafe);
        curvas.flor(image, 190, 190, 10, 10, cafe);
        curvas.flor(image, 150, 230, 10, 10, cafe);
        curvas.flor(image, 190, 230, 10, 10, cafe);
        
        curvas.curva100pts(image, 410, 35, 2, 2, negro);
        curvas.curva100pts(image, 415, 55, 2, 2, negro);
        curvas.curva100pts(image, 410, 75, 2, 2, negro);
        
        return image;
    }
}
