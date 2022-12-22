package reticula;

import javax.swing.*;

public class Vista extends JFrame {
    public Vista(){
        this.setTitle("Ingenieria en Sistemas Computacionales.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1175,600);

        add(new Reticula());

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Vista vista = new Vista();
    }
}
