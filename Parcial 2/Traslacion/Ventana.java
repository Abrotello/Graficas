import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    Coordenadas coordenadas = new Coordenadas();
    Bresenham bresenham;
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Ventana() {}

    protected void iniciarComponentes() {
        this.setTitle("Relleno 1");
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        setCoordenadas();
        this.add(bresenham);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setCoordenadas() {
        bresenham = new Bresenham(coordenadas.getX1(), coordenadas.getY1(), coordenadas.getX2(), coordenadas.getY2(), coordenadas.getX3(), coordenadas.getY3(), coordenadas.getX4(), coordenadas.getY4());
        executorService.submit(bresenham);
    }
}
