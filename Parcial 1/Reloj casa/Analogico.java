import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JPanel;

public class Analogico extends JPanel {
    Color verdeIntenso, negro, blanco, cafe, dorado;

    Color color1, color2, color3, color4, color5, color6, color7, color8;
    GradientPaint degradado1, degradado2, degradado3, degradado4;

    private int horas;
    private int minutos;
    private int segundos;

    //private static final float dosPi = (float)(2.0 * Math.PI);
    private static final float tresPi = (float) (3.0 * Math.PI);
    private static final float rad = (float) (Math.PI / 30.0);

    private int tamano;
    private int xCentro;
    private int yCentro;
    private javax.swing.Timer t;

    public Analogico() {
        t = new javax.swing.Timer(1000,
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
    }

    public void update() {
        this.repaint();//Siempre que queramos que un componente se vuelva a pintar, necesitamos llamar al método repaint.
    }

    public void start() {
        t.start();
    }

    public void stop() {
        t.stop();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();
        //marcas de segundos*** esta linea
        tamano = ((ancho < alto) ? ancho : alto) - 2 * 192;
        xCentro = 300;
        yCentro = 370;

        disenoReloj(g);

        Calendar now = Calendar.getInstance();
        horas = now.get(Calendar.HOUR);
        minutos = now.get(Calendar.MINUTE);
        segundos = now.get(Calendar.SECOND);

        Manecillas(g);
        //sonido();

    }

    private void disenoReloj(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        verdeIntenso = new Color(14, 102, 85);
        negro = new Color(0, 0, 0);
        blanco = new Color(255, 255, 255);
        cafe = new Color(76, 59, 20);
        dorado = new Color(225, 172, 0); 

        color1 = (new Color(232, 218, 211));//reloj
        color2 = (new Color(129, 78, 37));//numeros
        color3 = (new Color(185, 140, 101));//cafe claro
        color4 = (new Color(76, 59, 20));//cafe 
        color5 = (new Color(132, 21, 21));//rojo
        color6 = (new Color(225, 172, 0));//dorado
        color7 = (new Color(69, 179, 157));//verde bajo
        color8 = (new Color(14, 102, 85));//verde intenso

        degradado1 = new GradientPaint(0, 100, color5, 0, 255, color4, true);
        degradado2 = new GradientPaint(0, 200, color3, 0, 255, Color.white, true);
        degradado3 = new GradientPaint(0, 155, color3, 0, 250, color4, true);
        degradado4 = new GradientPaint(0, 155, color7, 0, 250, color8, true);

        //casita
        int[] coorx1 = {200, 400, 450, 300, 150};
        int[] coory1 = {500, 500, 225, 100, 225};
        g2.setPaint(verdeIntenso);
        g2.fillPolygon(coorx1, coory1, 5);
        g2.setPaint(negro);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(coorx1, coory1, 5);

        //techo
        int[] coorx2 = {500, 300, 100, 100, 300, 500};
        int[] coory2 = {265, 100, 265, 215, 50, 215};
        g2.setPaint(negro);
        g2.fillPolygon(coorx2, coory2, 6);
        g2.setColor(negro);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(coorx2, coory2, 6);

        //ventana
        g2.setPaint(blanco);
        g2.fillRect(270, 175, 65, 85);
        g2.setColor(negro);
        g2.fillArc(270, 160, 65, 30, 0, 180);
        g2.drawRect(270, 175, 65, 85);
        g2.drawArc(270, 160, 65, 30, 0, 180);

        //circulo
        g2.setColor(negro);
        g2.fillOval(200, 270, 200, 200);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(blanco);
        g2.drawOval(200, 270, 200, 200);

        //segundo circulo
        g2.setPaint(blanco);
        g2.fillOval(230, 300, 140, 140);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(verdeIntenso);
        g2.drawOval(230, 300, 140, 140);

        //decorcion
        g2.setPaint(negro);
        g2.drawLine(250, 500, 250, 650);
        g2.fillOval(245, 650, 10, 100);
        g2.drawLine(350, 500, 350, 750);
        g2.fillOval(345, 750, 10, 100);
        //simulacion de pendulo
        
        /*g2.setPaint(dorado);
        int[] coorx3 = {300, 308, 370, 362};
        int[] coory3 = {500, 500, 700, 700};
        g2.fillPolygon(coorx3, coory3, 4);
        g2.fillOval(345, 690, 70, 70);*/

        //color de las marcas de los segundos
        g2.setPaint(blanco);
        for (int seg = 0; seg < 60; seg++) {
            int inicio;
            if (seg % 5 == 0) {
                //grosor de las marcas de las horas
                g2.setStroke(new BasicStroke(2));
                inicio = tamano / 2 - 10;
                diseno(g, xCentro, yCentro, rad * seg, inicio, tamano / 2);
            } else {
                //grosor de las marcas de los segundos
                g2.setStroke(new BasicStroke(1));
                inicio = tamano / 2 - 5;
            }
            diseno(g, xCentro, yCentro, rad * seg, inicio, tamano / 2);
        }

        //Acomoda los numeros (numero, x, y) 
        g.setColor(blanco);
        Font font = new Font("Arial", Font.BOLD, 16);
        g.setFont(font);
        g.drawString("12", 292, 295);
        g.drawString("1", 332, 305);
        g.drawString("2", 363, 335);
        g.drawString("3", 380, 375);
        g.drawString("4", 365, 415);
        g.drawString("5", 338, 445);
        g.drawString("6", 298, 458);
        g.drawString("7", 258, 445);
        g.drawString("8", 228, 415);
        g.drawString("9", 215, 375);
        g.drawString("10", 225, 335);
        g.drawString("11", 253, 307);
        Font font1 = new Font("Arial", Font.BOLD, 12);
        g.setFont(font1);

    }

    private void Manecillas(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.red);//color de manecillas
        g2.setStroke(new BasicStroke(1));//grosor de segundero
        float fsegundos = segundos;
        float anguloSegundero = tresPi - (rad * fsegundos);
        diseno(g, xCentro, yCentro, anguloSegundero, 0, 100);

        g2.setPaint(negro);
        g2.setStroke(new BasicStroke(2));//grosor de minutero
        float fminutos = (float) (minutos + fsegundos / 60.0);
        float anguloMinutero = tresPi - (rad * fminutos);
        diseno(g, xCentro, yCentro, anguloMinutero, 0, 68);

        g2.setStroke(new BasicStroke(3));//grosor de hora
        float fhours = (float) (horas + fminutos / 60.0);
        float anguloHora = tresPi - (5 * rad * fhours);
        diseno(g, xCentro, yCentro, anguloHora, 0, 34);

    }

    private void diseno(Graphics g, int x, int y, double angulo, int minRadius, int maxRadius) {
        float sine = (float) Math.sin(angulo);
        float cosine = (float) Math.cos(angulo);

        int dxmin = (int) (minRadius * sine);
        int dymin = (int) (minRadius * cosine);

        int dxmax = (int) (maxRadius * sine);
        int dymax = (int) (maxRadius * cosine);
        g.drawLine(x + dxmin, y + dymin, x + dxmax, y + dymax);
    }

}
