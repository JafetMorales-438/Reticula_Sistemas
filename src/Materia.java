/**
 * La clase "Materia" representa una materia ordinaria o de especialidad según
 * el Instituto Tecnológico De Oaxaca (ITO)
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
     * @param nombre nombre de la Materia
     * @param semestre Semestre de la Materia
     * @param creditos Cantidad de creditos de la materia
     * @param estado Estado de la Materia
     * @param esCadena Si tiene cadena con algun otra Materia (En este constructor, es NO)
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
     * Devuelve el nombre de la materia
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el semestre de la materia
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * <html>
     *     <body>
     *         <h3>Devuelve la cantidad de créditos de la materia</h3>
     *         <p>Una materia ordinaria tiene 4 o 5 creditos</p>
     *         <p>Una actividad complementaria tiene 2 a 3 creditos</p>
     *         <p>las materias de esecialidad así como sercicio social tienen 10 creditos</p>
     *     </body>
     * </html>
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * <html>
     *     <body>
     *         <h3>Devuelve la situación de la materia</h3>
     *     </body>
     * </html>
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * <html>
     *     <body>
     *         <h3>Cambia el situación de la materia, teniendo esta 9 estados</h3>
     *         <p>Estatus:</p>
     *         <ol>
     *             <li>Materia no permitida</li>
     *             <li>Materia posible a seleccionar</li>
     *             <li>Cursando Materia</li>
     *             <li>Materia Acreditada</li>
     *             <li>Cursada sin acreditar</li>
     *             <li>Reprobada cursando</li>
     *             <li>A curso especial</li>
     *             <li>Especial cursando</li>
     *             <li>Curso especial reprobado</li>
     *         </ol>
     *     </body>
     * </html>
     * @param status situación de la materia
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Devuelve si la Materia tiene cadena o no
     * @return true o false si tiene cadena o no
     */
    public boolean isCadena() {
        return isCadena;
    }

    public String getCadenaCon() {
        if(!isCadena)
            return "No tiene cadena";
        else
            return cadenaCon;
    }
}