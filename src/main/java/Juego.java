
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends JPanel {

    Laberinto laberinto = new Laberinto();
    Personaje personaje = new Personaje();

    public Juego() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics grafico) {
        laberinto.paint(grafico);
        personaje.paint(grafico);

    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¿Estas Listo? Para Empezar la Aventura");
        JFrame miventana = new JFrame("The Odyssey");
        Juego game = new Juego();
        miventana.add(game);
        //Propieddes de la ventana de juego
        miventana.setSize(940, 560);       //Tamaño de ventana
        miventana.setLocation(150, 100);   //Ubicación de la ventana en la pantalla
        miventana.setVisible(true);       //Que se muestre en el escritorio
        miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.repaint();
        }

    }

}
