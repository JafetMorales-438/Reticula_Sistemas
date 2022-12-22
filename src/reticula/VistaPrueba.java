package reticula;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VistaPrueba extends JFrame {
    /* ---------- Inicio de la clase Reticula ---------- */
    private ArrayList<Materia> materias = new ArrayList<>();
    public VistaPrueba(){
        this.setTitle("Ingenieria en Sistemas Computacionales.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1175,600);

        agregarMaterias();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void crearMaterias(){
        String ruta = "C:\\Users\\Jafet Morales\\IdeaProjects\\Reticula_Sistemas\\src\\Materias.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));

            String line;
            int contador = 0;

            while ((line = reader.readLine()) != null){
                String[] s = line.split(",");
                //materias.add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),s[5]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void agregarCoordenadas(){
        crearMaterias();
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
    public void agregarMaterias(){
        agregarCoordenadas();
        for (Materia m : materias)
            this.add(m);
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
    public static void main(String[] args) {
        VistaPrueba v = new VistaPrueba();
    }
    /* ---------- Fin de la clase Reticula ---------- */
}