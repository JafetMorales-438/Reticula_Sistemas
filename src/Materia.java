/**
 * La clase "Materia" representa una materia ordinaria o de especialidad segun
 * el plan reticular del "Instituto Tecnologico De Oaxaca" (ITO)
 * @author Limni Jafet Morales Morales (JafetD438)
 * @version 1.0 (02/08/22)
 */
public class Materia {
    private final String name;
    private String cadenaCon;
    private final int semester, credits;
    private int status;
    private final boolean isCadena;

    /**
     * Contructor de la clase Materia (Sin cadena)
     * @param nombre    nombre de la Materia
     * @param semestre  Semestre de la Materia
     * @param creditos  Cantidad de creditos de la materia
     * @param estado    Estado de la Materia
     * @param esCadena  Si tiene cadena con algun otra Materia (En este constructor, es NO)
     */
    public Materia(String nombre, int semestre, int creditos, int estado, boolean esCadena){
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.isCadena = esCadena;
    }

    /**
     * Contructuctor de la clase Materia (Con cadena)
     *
     * @param nombre    Nombre de la Materia
     * @param semestre  Semestre de la Materia
     * @param creditos  Creditos de la Materia
     * @param estado    Estado de la Materia
     * @param esCadena  Si tiene cadena con algun otra Materia (En este contructor, es SI)
     * @param cadenaCon La Materia con la que es cadena esta misma Materia.
     */
    public Materia(String nombre, int semestre, int creditos, int estado, boolean esCadena, String cadenaCon){
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.isCadena = esCadena;
        this.cadenaCon = cadenaCon;
    }

    /**
     * Devuelve el nombre de la materia.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el semestre en que se posiciona la Materia.
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * <html>
     *     <body>
     *         <h3>Devuelve la cantidad de creditos de la materia.</h3>
     *         <p>Una materia ordinaria tiene 4 o 5 creditos.</p>
     *         <p>Una actividad complementaria tiene 2 a 3 creditos.</p>
     *         <p>Las materias de especialidad y el servicio social tienen 10 creditos.</p>
     *     </body>
     * </html>
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Devuelve la situacion de la materia.
     * @return Situación de la Materia segun sea el caso.
     */
    public int getStatus() {
        return status;
    }

    /**
     * <html>
     *     <body>
     *         <h3>Cambia la situacion de la Materia, teniendo esta 9 estados.</h3>
     *         <p>Estatus:</p>
     *         <ol>
     *             <li>Materia no permitida.</li>
     *             <li>Materia posible a seleccionar.</li>
     *             <li>Cursando Materia.</li>
     *             <li>Materia Acreditada.</li>
     *             <li>Cursada sin acreditar.</li>
     *             <li>Reprobada cursando.</li>
     *             <li>A curso especial.</li>
     *             <li>Especial cursando.</li>
     *             <li>Curso especial reprobado.</li>
     *         </ol>
     *     </body>
     * </html>
     * @param status situacion de la materia.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Devuelve "true" si la Materia tiene cadena o "false" si no la tiene.
     * @return true o false según el caso.
     */
    public boolean isCadena() {
        return isCadena;
    }

    /**
     * Devuelve el nombre de la Materia con la que es cadena
     * o devuelve "No tiene cadena" en caso de no tener una.
     * @return Nombre de la materia según sea el caso.
     */
    public String getCadenaCon() {
        if(!isCadena)
            return "No tiene cadena";
        else
            return cadenaCon;
    }
}