import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
        Dibujo pantalla = new Dibujo();
        setTitle("Transformacion");
        executorService.submit(pantalla);
        add(pantalla);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
