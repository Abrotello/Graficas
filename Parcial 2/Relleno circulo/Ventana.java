import javax.swing.JFrame;

public class Ventana extends JFrame {
    Circulo circulo;

    public Ventana() {}

    protected void iniciarComponentes() {
        this.setTitle("Relleno 2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        circulo = new Circulo(250, 250, 150);
        this.add(circulo);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
