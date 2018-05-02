/*
Dibujar una figura en el plano y moverla con las teclas.
@utora: Laura Maribel Chan Oliva 4A Tópicos Avanzados de programación
*/

import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Principal extends JFrame{

    public Principal(){
        super("Ventana figura");
        Container contenedorprincipal = getContentPane();
        contenedorprincipal.setLayout((LayoutManager) new BoxLayout(contenedorprincipal,BoxLayout.Y_AXIS));

        Lienzo lienzo = new Lienzo();
        contenedorprincipal.add(lienzo);
    }

    public static void main(String[] args) {
        Principal ventana = new Principal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(new Dimension(800,600));
        ventana.setResizable(false);
        ventana.setVisible(true);
    }




}
