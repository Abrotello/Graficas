import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    Fondo pantalla = new Fondo();

    public Ventana() {

        setTitle("Simulador de trafico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        executorService.submit(pantalla);
        add(pantalla);
        setSize(1280, 720);
        getContentPane().add(pantalla);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
