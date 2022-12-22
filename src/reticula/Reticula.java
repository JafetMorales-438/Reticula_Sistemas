package reticula;

import javax.swing.*;

public class Reticula extends JPanel {
    public JTextField campoCreditos;
    Materias materias;
    public Reticula(){
        this.setLayout(null);
        this.setSize(1175,600);
        creditos();
        agregarMaterias();
    }
    public void agregarMaterias(){
        agregarCoordenadas();
        for (Materia m : materias)
            this.add(m);
    }
    private void agregarCoordenadas(){
        materias = new Materias();
        int x = 25, y = 25, cont = 0;
        for (Materia m : materias) {
            if(m.getSemester() == 1 || m.getSemester() == 2 || m.getSemester() == 6){
                if(cont != 7){
                    m.setLocation(x,y);
                    y += 75;
                    cont++;
                } if(cont == 7){
                    x += 125;
                    y = 25;
                    cont = 0;
                }
            } else if (m.getSemester() == 8) {
                if(cont != 5){
                    y += 75;
                    m.setLocation(x,y);
                    cont++;
                } if(cont == 5){
                    x += 125;
                    y = 25;
                    cont = 0;
                }
            } else {
                if(cont != 6){
                    m.setLocation(x,y);
                    y += 75;
                    cont++;
                } if(cont == 6){
                    x += 125;
                    y = 25;
                    cont = 0;
                }
            }
        }
    }
    public void creditos(){
        JLabel c = new JLabel("Créditos:");
        c.setBounds(1000,525,70,25);
        add(c);

        campoCreditos = new JTextField("260");
        campoCreditos.setBounds(1060,527,30,20);
        campoCreditos.setEditable(false);
        add(campoCreditos);
    }
}
