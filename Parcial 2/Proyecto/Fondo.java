import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Fondo extends JPanel implements Runnable {
    private BufferedImage fondo;
    private BufferedImage animacion;
    private Graphics gAnimacion;

    //Jugadores
    private int paredPortero = 1145, paredPortero2 = 1135;
    private int direccion = 0;
    private int portero1 = 1140, portero2 = portero1;
    private int jugador1 = 1190, jugador2 = jugador1;
    private int jugador3 = 1090, jugador4 = jugador3;
    private int radio = 70;

    //Carros
    int alto = 0;
    int ancho = 0;

    public Fondo() {}

    //Fondo
    private void gloritea() {
        Glorietas glorietas = new Glorietas();
        fondo = glorietas.glorieta(fondo);
    }

    private void cuadras() {
        Cuadras cuadras = new Cuadras();
        fondo = cuadras.cuadra(fondo);
    }

    private void lineas() {
        Carriles carriles = new Carriles();
        fondo = carriles.carril(fondo);
    }

    private void separaciones() {
        Carriles separaciones = new Carriles();
        fondo = separaciones.separaciones(fondo);
    }

    private void edificios() {
        Edificios casas = new Edificios();
        fondo = casas.casas(fondo);
        fondo = casas.canchas(fondo);
        fondo = casas.adornos(fondo);
        fondo = casas.alberca(fondo);
        fondo = casas.casona(fondo);
    }

    //Animacion
    private void jugarFutbol() {
        CoordenadasPersonas coordenadas = new CoordenadasPersonas();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras jugadores = new Figuras(buffer);

        jugadores.circulo(portero1, coordenadas.getJugador1()[1], 4, 0, Color.WHITE, animacion);
        jugadores.floodFillCirculo(portero1, coordenadas.getJugador1()[1], 4, animacion, Color.RED);
        
        jugadores.circulo(portero1, coordenadas.getJugador3()[1], 4, 0, Color.WHITE, animacion);
        jugadores.floodFill(portero1, coordenadas.getJugador3()[1], animacion.getRGB(portero1, coordenadas.getJugador3()[1]), animacion, Color.RED);

        jugadores.circulo(jugador1, coordenadas.getJugador4()[1], 4, 0, Color.WHITE, animacion);
        jugadores.floodFill(jugador1, coordenadas.getJugador4()[1], animacion.getRGB(jugador1, coordenadas.getJugador4()[1]), animacion, Color.RED);

        jugadores.circulo(jugador3, coordenadas.getJugador5()[1], 4, 0, Color.WHITE, animacion);
        jugadores.floodFill(jugador3, coordenadas.getJugador5()[1], animacion.getRGB(jugador3, coordenadas.getJugador5()[1]), animacion, Color.RED);

        //
        jugadores.circulo(portero2, coordenadas.getJugador2()[1], 4, 0, Color.BLACK, animacion);
        jugadores.floodFillCirculo(portero2, coordenadas.getJugador2()[1], 4, animacion, Color.RED);

        jugadores.circulo(portero2, coordenadas.getJugador6()[1], 4, 0, Color.BLACK, animacion);
        jugadores.floodFill(portero2, coordenadas.getJugador6()[1], animacion.getRGB(portero2, coordenadas.getJugador6()[1]), animacion, Color.RED);

        jugadores.circulo(jugador2, coordenadas.getJugador7()[1], 4, 0, Color.BLACK, animacion);
        jugadores.floodFill(jugador2, coordenadas.getJugador7()[1], animacion.getRGB(jugador2, coordenadas.getJugador7()[1]), animacion, Color.RED);

        jugadores.circulo(jugador4, coordenadas.getJugador8()[1], 4, 0, Color.BLACK, animacion);
        jugadores.floodFill(jugador4, coordenadas.getJugador8()[1], animacion.getRGB(jugador4, coordenadas.getJugador8()[1]), animacion, Color.RED);

        jugadores.circulo(1140, 115, radio, 0, Color.BLACK, animacion);
        jugadores.floodFillCirculo(1140, 115, radio, animacion, Color.WHITE);
        
        if(radio > 4) {
            radio-=2;
        }  

        if(direccion == 0) {
            portero1++;
            jugador1++;
            jugador3++;
            
            portero2--;
            jugador2--;
            jugador4--;
        }
        if(direccion == 1) {
            portero1--;
            jugador1--;
            jugador3--;

            portero2++;
            jugador2++;
            jugador4++;
        }

        if(portero1 > paredPortero) {
            direccion = 1;
        }

        if(portero1 < paredPortero2) {
            direccion = 0;
        }
    }

    private void carros() {
        CoordenadasCarros coordenadas = new CoordenadasCarros();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras carros = new Figuras(buffer);

        //Carro1
        carros.cuadrado(coordenadas.getCarro1()[0], coordenadas.getCarro1()[1]+alto, coordenadas.getCarro1()[2], coordenadas.getCarro1()[3]+alto, Color.WHITE, animacion);
        carros.rellenarRectangulo(coordenadas.getCarro1()[0], coordenadas.getCarro1()[1]+alto, coordenadas.getCarro1()[2], coordenadas.getCarro1()[3]+alto, Color.BLUE);
        carros.floodFillCirculo(757, 33+alto, 3, animacion, Color.YELLOW);
        carros.floodFillCirculo(770, 33+alto, 3, animacion, Color.YELLOW);
        //Carro2
        carros.cuadrado(coordenadas.getCarro2()[0], coordenadas.getCarro2()[1]+ancho, coordenadas.getCarro2()[2], coordenadas.getCarro2()[3]+ancho, Color.WHITE, animacion);
        carros.rellenarRectangulo(coordenadas.getCarro2()[0], coordenadas.getCarro2()[1]+ancho, coordenadas.getCarro2()[2], coordenadas.getCarro2()[3]+ancho, Color.WHITE);
        
        carros.cuadrado(coordenadas.getCarro2()[0]+8, coordenadas.getCarro2()[1]+7+ancho, coordenadas.getCarro2()[2]-8, coordenadas.getCarro2()[3]-7+ancho, Color.BLACK, animacion);
        carros.rellenarRectangulo(coordenadas.getCarro2()[0]+8, coordenadas.getCarro2()[1]+7+ancho, coordenadas.getCarro2()[2]-8, coordenadas.getCarro2()[3]-7+ancho, Color.RED);
        
        carros.cuadrado(coordenadas.getCarro2()[0]+2, coordenadas.getCarro2()[1]+15+ancho, coordenadas.getCarro2()[2]-2, coordenadas.getCarro2()[3]-15+ancho, Color.BLACK, animacion);
        carros.rellenarRectangulo(coordenadas.getCarro2()[0]+2, coordenadas.getCarro2()[1]+15+ancho, coordenadas.getCarro2()[2]-2, coordenadas.getCarro2()[3]-15+ancho, Color.RED);
        
        carros.floodFillCirculo(713, 44+ancho, 3, animacion, Color.YELLOW);
        carros.floodFillCirculo(730, 44+ancho, 3, animacion, Color.YELLOW);

        if(alto < fondo.getHeight()) {
            alto+=3;
        } else {
            alto = 0;
        }

        if(ancho < fondo.getHeight()) {
            ancho+=4;
        } else {
            ancho = 0;
        }
    }

    private void dibujarFondo(Graphics g) {
        
        if(fondo == null) {
            fondo = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
            cuadras();
            
            lineas();
            
            separaciones();
            gloritea();
            edificios();
            
        } 
        update(g);
    }

    @Override
    public void update(Graphics g) {
        animacion = new BufferedImage(fondo.getWidth(), fondo.getHeight(), BufferedImage.TYPE_INT_RGB);
        gAnimacion = animacion.getGraphics();
        gAnimacion.drawImage(fondo, 0, 0, this);
        
        jugarFutbol();
        carros();

        g.drawImage(animacion, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {        
        dibujarFondo(g);
    }

    @Override
    public void run() {
        while (true) {

            try {

                repaint();
                Thread.sleep(50);

            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }
    }
}
