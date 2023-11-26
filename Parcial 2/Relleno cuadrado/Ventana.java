import javax.swing.JFrame;

public class Ventana extends JFrame {

    Coordenadas coordenadas = new Coordenadas();
    Bresenham bresenham;

    public Ventana() {}

    protected void iniciarComponentes() {
        this.setTitle("Relleno 1");
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        setCoordenadas();
        this.add(bresenham);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setCoordenadas() {
        bresenham = new Bresenham(coordenadas.getX1(), coordenadas.getY1(), coordenadas.getX2(), coordenadas.getY2());
    }
}
