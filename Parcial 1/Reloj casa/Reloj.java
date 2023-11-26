import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Reloj extends JFrame {

    public static void main(String[] args) {
        Reloj ventana = new Reloj();
        ventana.setSize(600, 900);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    Analogico analogico;

    public Reloj() {
        super("reloj");
        setResizable(false); 
        Container content = this.getContentPane(); 
        content.setLayout(new BorderLayout());
        analogico= new Analogico();
        content.add(analogico, BorderLayout.CENTER);
        this.pack();
        analogico.start();

    }

}
