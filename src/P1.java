import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class P1 {
    public static void main(String[] args) {
        // Crea la ventana principal
        JFrame ventanaPrincipal = new JFrame("¿Quieres ver a un gato?");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(300, 200);

        // Crea un panel para contener los botones
        JPanel panel = new JPanel();

        // Crea un botón que abrirá una nueva ventana y cerrará la ventana principal
        JButton boton1 = new JButton("Dos Gatos");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGato(ventanaPrincipal, "https://th.bing.com/th/id/R.da68d04eed8bcd0ee0849776e2a72886?rik=YlMj%2bvBpHnoqmA&pid=ImgRaw&r=0");
            }
        });

        // Crea un segundo botón que hace lo mismo que el primero pero muestra un GIF diferente
        JButton boton2 = new JButton("Gato Bailando");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGato(ventanaPrincipal, "https://www.aldia.co/sites/default/files/ezgif.com-resize.gif");
            }
        });

        // Añade los botones al panel
        panel.add(boton1);
        panel.add(boton2);

        // Añade el panel a la ventana principal
        ventanaPrincipal.getContentPane().add(panel);

        // Muestra la ventana principal
        ventanaPrincipal.setVisible(true);
    }

    private static void mostrarGato(JFrame ventanaPrincipal, String urlGif) {
        // Cierra la ventana principal
        ventanaPrincipal.dispose();

        // Abre una nueva ventana con un GIF
        JFrame ventanaGif = new JFrame("Gatos");
        ventanaGif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Crea un ImageIcon a partir de la URL del GIF
            URL url = new URL(urlGif);
            ImageIcon icon = new ImageIcon(url);

            // Crea una etiqueta con el ImageIcon
            JLabel label = new JLabel(icon);
            ventanaGif.getContentPane().add(label);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        // Muestra la nueva ventana
        ventanaGif.pack();
        ventanaGif.setVisible(true);
    }
}