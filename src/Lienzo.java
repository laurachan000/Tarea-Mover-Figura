import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    private Color colorfondo;
    private int coordXOrig = 200;
    private int coordYOrig = 150;
    private int FiguraX = coordXOrig - 150;
    private int FiguraY = coordYOrig -150;
    private Graphics g;

    public void setCoordXOrig(int coordXOrig){
        this.coordXOrig = coordXOrig;
    }

    public void setCoordYOrig(int coordYOrig){
        this.coordYOrig = coordYOrig;
    }

    //constructor
    public Lienzo(){
        super();

        //Crear un JPanel y agregarlo
        this.setPreferredSize(new Dimension(800,400));
        colorfondo = Color.BLACK;
        this.setBackground(Color.BLACK);
        //this.setBackground(colorFondo);


        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    FiguraX = 200;
                    repaint();
                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    FiguraX  = -200;
                    repaint();
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    FiguraY =  200;
                    repaint();
                }

                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    FiguraY =  - 200;
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
        this.setFocusable(true);
        this.requestFocusInWindow();

    } //termina lienzo




    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        coordXOrig = (int) ((this.getWidth()) / 2);
        coordYOrig = (int) ((this.getHeight()) / 2);

        g.setColor(Color.GREEN);

        g.drawLine(0, coordYOrig, this.getWidth() - 1, coordYOrig);
        int XActual = coordXOrig;
        int numValores = (int) (coordXOrig / 40) + 1;
        XActual = coordXOrig - numValores * 40;

        for (int valor = 0 - numValores; valor <= ((this.getWidth() / 2) / 40); valor++) {
            g.drawLine(XActual, coordYOrig - 5, XActual, coordYOrig + 5);
            g.drawString("" + valor, XActual - 10, coordYOrig + 20);
            XActual += 40;

        }

        g.drawLine(coordXOrig, 0, coordXOrig, this.getHeight());
        int YActual = coordYOrig;
        numValores = (int) (coordYOrig / 40) + 1;
        YActual = coordYOrig - numValores * 40;
        int contnumeros = 8;

        for (int valor = 0 - numValores; valor <= ((this.getHeight() / 2) / 40); valor++) {
            g.drawLine(coordXOrig - 5, YActual, coordXOrig + 5, YActual);
            g.drawString("" + contnumeros, coordXOrig + 10, YActual - 5);
            contnumeros -= 1;
            YActual += 40;

        }


        graficarFigura(g);
    }//termina paint component


    public void graficarFigura(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(FiguraX+300,FiguraY+230,100,100);


    }






} //class lienzo