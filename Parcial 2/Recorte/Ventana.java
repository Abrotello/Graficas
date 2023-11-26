import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    Figura cuadrado = new Figura();
    ExecutorService executor = Executors.newFixedThreadPool(10);

    public Ventana() {
        setTitle("Recorte");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void dibujarCuadrado() {
        add(cuadrado);
        executor.submit(cuadrado);
    }
}
