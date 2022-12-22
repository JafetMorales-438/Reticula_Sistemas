package reticula;

import reticula.Materia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Materias extends ArrayList<Materia> {
    public Materias(){crearMaterias();}
    /* ArrayList<reticula.Materia> */
    private void crearMaterias(){
        String ruta = "C:\\Users\\Jafet Morales\\IdeaProjects\\Reticula_Sistemas\\src\\materias.txt";

        File file = new File("materias.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));

            String line;
            int contador = 0;

            while ((line = reader.readLine()) != null){
                String[] s = line.split(",");
                //add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),s[5]));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
