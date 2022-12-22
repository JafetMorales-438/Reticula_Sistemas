package reticula;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Materias extends ArrayList<Materia> {
    public Materias(){crearMaterias();}
    private void crearMaterias(){
        String ruta = "C:\\Users\\Jafet Morales\\IdeaProjects\\Reticula_Sistemas\\src\\reticula\\Materias.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));

            String line;
            int contador = 0;

            while ((line = reader.readLine()) != null){
                String[] s = line.split(",");

                if (s.length == 6){
                    /* Representa una materia sin cadenas */
                    add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),Boolean.parseBoolean(s[5])));
                } else if (s.length == 7) {
                    if(s[6].equals("50") || s[6].equals("70") || s[6].equals("80")){
                        /* Representa una materia de tipo especial (se desbloquea por porcentaje) */
                        add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),Boolean.parseBoolean(s[5]),Integer.parseInt(s[6])));
                    } else if(s[4].equals("true")){
                        String[] materiasP = {s[6]};
                        String[] materiasA = {"none"};
                        /* Representa una materia que tiene una cadena */
                        add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),Boolean.parseBoolean(s[5]),materiasP,materiasA));
                    }
                } else if (s.length == 8) {
                    if (s[4].equals("true")){
                        String[] materiasP = {s[6],s[7]};
                        String[] materiasA = {"none"};
                        /* Representa una materia que tiene una bi-cadena */
                        add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),Boolean.parseBoolean(s[5]),materiasP,materiasA));
                    } else if(s[5].equals("true")){
                        String[] materiasP = {"none"};
                        String[] materiasA = {s[6],s[7]};
                        /* Representa una materia que pertenece a una bi-cadena */
                        add(new Materia(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Boolean.parseBoolean(s[4]),Boolean.parseBoolean(s[5]),materiasP,materiasA));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
