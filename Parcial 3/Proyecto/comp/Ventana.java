package comp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;


public class Ventana extends JFrame {

    public Ventana() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Fondo fondo = new Fondo();
        
        setTitle("Tren - Animacion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        executorService.submit(fondo);
        add(fondo);
        setSize(1280, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
