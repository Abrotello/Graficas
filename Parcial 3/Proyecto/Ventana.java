import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import comp.Fondo;

public class Ventana extends JFrame {

    public Ventana() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Fondo fondo = new Fondo();
        
        setTitle("Titan Soul - Animacion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        executorService.submit(fondo);
        add(fondo);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
