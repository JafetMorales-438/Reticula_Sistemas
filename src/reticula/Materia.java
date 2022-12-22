package reticula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase "Materia" es un botón que representa una materia ordinaria o de especialidad según
 * el plan reticular del "Instituto Tecnológico De Oaxaca" (ITO).
 * @author Limni Jafet Morales Morales (JafetD438).
 * @version 3.0 (22/12/22)
 */
public class Materia extends JButton{
    private String name;
    private String[] cadenasPos, cadenasAnt;
    private int semester, credits, status, percentage;
    private boolean haveCadena, isACadena;

    /**
     * Constructor de la clase Materia (sin cadenas).
     * @param nombre    Nombre de la Materia
     * @param semestre  Semestre al que pertenece la Materia.
     * @param creditos  Cantidad de créditos que posee la Materia.
     * @param estado    Situación de la Materia.
     * @param tCadena   Si tiene cadena con alguna otra Materia (en este constructor, es NO).
     * @param eCadena   Si es cadena con alguna otra Materia (en este constructor, es NO).
     */
    public Materia(String nombre, int semestre, int creditos, int estado, boolean tCadena, boolean eCadena){
        /* Propiedades Materia */
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.haveCadena = tCadena;
        this.isACadena = eCadena;
        /* Propiedades JButton*/
        this.setText("<html><center>"+getName());
        this.setFormat();
        this.setSize(100,50);
        this.click_status();
        if(getStatus() == 0){
            this.setEnabled(false);
        }
    }

    /**
     * Constructor de la clase Materia (Con cadenas).
     * @param nombre    Nombre de la Materia.
     * @param semestre  Semestre al que pertenece la Materia.
     * @param creditos  Cantidad de créditos que posee la Materia.
     * @param estado    Situación de la Materia.
     * @param tCadena   Si tiene cadena con alguna otra Materia (en este constructor puede variar).
     * @param eCadena   Si es cadena con alguna otra Materia (en este constructor puede variar).
     * @param cadenaPos Nombre(s) de las materias posteriores a esta (en caso de tener cadena).
     * @param cadenaAnt Nombre(s) de las materias anteriores a esta (en caso de ser cadena).
     */
    public Materia(String nombre, int semestre, int creditos, int estado, boolean tCadena, boolean eCadena,String[] cadenaPos, String[] cadenaAnt){
        /* Propiedades Materia */
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.haveCadena = tCadena;
        this.isACadena = eCadena;
        this.cadenasPos = cadenaPos;
        this.cadenasAnt = cadenaAnt;
        /* Propiedades JButton*/
        this.setText("<html><center>"+getName());
        this.setFormat();
        this.setSize(100,50);
        this.click_status();
        if(getStatus() == 0){
            this.setEnabled(false);
        }
    }

    /**
     * Constructor de la clase Materia (Materias especiales que se desbloquean con porcentajes).
     * @param nombre     Nombre de la Materia
     * @param semestre   Semestre al que pertenece la Materia.
     * @param creditos   Cantidad de créditos que posee la Materia.
     * @param estado     Situación de la Materia.
     * @param tCadena    Si tiene cadena con alguna otra Materia (en este constructor, es NO).
     * @param eCadena    Si es cadena con alguna otra Materia (en este constructor, es NO).
     * @param porcentaje Porcentaje para "desbloquear" esta Materia.
     */
    public Materia(String nombre, int semestre, int creditos, int estado, boolean tCadena, boolean eCadena, int porcentaje){
        /* Propiedades Materia */
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.haveCadena = tCadena;
        this.isACadena = eCadena;
        this.percentage = porcentaje;
        /* Propiedades JButton*/
        this.setText("<html><center>"+getName());
        this.setFormat();
        this.setSize(100,50);
        this.click_status();
        if(getStatus() == 0){
            this.setEnabled(false);
        }
    }

    /* ----------------------- Inicio de propiedades de la Materia ----------------------- */

    /**
     * Devuelve el nombre de la Materia.
     * @return El nombre de la Materia.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve un arreglo con el nombre de todas las Materias posteriores a esta (en caso de ser cadena).
     * @return Arreglo con nombres de Materias posteriores.
     */
    public String[] getCadenasPos(){return cadenasPos;}

    /**
     * Devuelve un arreglo con el nombre de todas las Materias anteriores a esta (en caso de ser cadena).
     * @return Arreglo con nombres de Materias anteriores.
     */
    public String[] getCadenasAnt() {return cadenasAnt;}

    /**
     * Devuelve el número del semestre al que pertenece la Materia.
     * @return El semestre de la Materia.
     */
    public int getSemester() {return semester;}

    /**
     * <html>
     *     <body>
     *         <h3>Devuelve la cantidad de créditos de la materia.</h3>
     *         <p>Una materia ordinaria tiene 4 o 5 créditos.</p>
     *         <p>Una actividad complementaria tiene 2 a 3 créditos.</p>
     *         <p>Las materias de especialidad y el servicio social tienen 10 créditos.</p>
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
     *         <h3>Devuelve la situación de la Materia, teniendo esta 9 estados.</h3>
     *         <p>Estatus:</p>
     *         <ol>
     *             <li>--> Materia no permitida = 0</li>
     *             <li>--> Materia posible a seleccionar = 1</li>
     *             <li>--> Cursando Materia = 2</li>
     *             <li>--> Materia Acreditada =3</li>
     *             <li>--> Cursada sin acreditar = 4</li>
     *             <li>--> Reprobada cursando = 5</li>
     *             <li>--> A curso especial = 6</li>
     *             <li>--> Especial cursando = 7</li>
     *             <li>--> Curso especial reprobado = 8</li>
     *         </ol>
     *     </body>
     * </html>
     * @return Situación de la Materia según sea el caso.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Devuelve "true" si la Materia tiene cadena o "false" si no la tiene.
     * @return true o false según el caso.
     */
    public boolean isHaveCadena() {
        return haveCadena;
    }

    /**
     * Devuelve "true" si la Materia es parte de una cadena o "false" si no lo es.
     * @return true o false según el caso.
     */
    public boolean isACadena() {return isACadena;}

    /**
     * Devuelve el número del porcentaje que tiene la Materia para "desbloquearse".
     * @return El "porcentaje" de la Materia.
     */
    public int getPercentage() {return percentage;}

    /**
     * <html>
     *     <body>
     *         <p>Cambia la situación de la Materia y las desactiva si su estado es 0.</p>
     *         <h3>0 = Materia no permitida.</h3>
     *     </body>
     * </html>
     * @param status situación de la materia.
     */
    public void setStatus(int status) {
        this.status = status;
        if(getStatus() == 0){
            this.setEnabled(false);
        } else {
            this.setEnabled(true);
        }
    }

    /**
     * Muestra en una ventana Emergente toda la información acerca de la Materia.
     * @return Información General.
     */
    public String getInfo(){
        return "Materia: "+getName();
    }

    /* ----------------------- Fin de propiedades de la materia ------------------------ */
    // --------------------------------------------------------------------------------- //
    /* ------------------------ Inicio propiedades del JButton ------------------------- */

    /**
     * Cambia el color del JButton recibiendo 3 números enteros como parámetros
     * para pasarlos nuevamente como parámetros para crear un Color.
     * @param R Red
     * @param G Green
     * @param B Blue
     */
    private void setColor(int R, int G, int B){
        this.setBackground(new Color(R,G,B));
    }
    /**
     * El método click_status agrega un evento al JButton para que muestre un JFrame.
     */
    private void click_status(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame v = ventanaEstado();
            }
        });
    }
    /**
     * Crea una ventana con todos los estados que puede tener una Materia,
     * los cuales se pueden seleccionar, cambiando su estado de la Materia
     * y cambiando el color del JButon según sea el caso.
     * @return Una ventana temporal.
     */
    private JFrame ventanaEstado(){
        JFrame ventana2 = new JFrame("Estado");

        ventana2.setSize(300,400);
        ventana2.setLocationRelativeTo(null);
        ventana2.setLayout(null);

        ButtonGroup group = new ButtonGroup();

        JRadioButton btn1 = new JRadioButton("Cursando");
        btn1.setBounds(25,20,200,30);
        JRadioButton btn2 = new JRadioButton("Acreditada");
        btn2.setBounds(25,50,200,30);
        JRadioButton btn3 = new JRadioButton("Cursada: Sin Acreditar");
        btn3.setBounds(25,80,200,30);
        JRadioButton btn4 = new JRadioButton("Reprobada: Cursando");
        btn4.setBounds(25,110,200,30);
        JRadioButton btn5 = new JRadioButton("A Curso Especial");
        btn5.setBounds(25,140,200,30);
        JRadioButton btn6 = new JRadioButton("Especial: Cursando");
        btn6.setBounds(25,170,200,30);
        JRadioButton btn7 = new JRadioButton("Curso Especial: Reprobado");
        btn7.setBounds(25,200,200,30);
        JRadioButton info = new JRadioButton("Información");
        info.setBounds(25,230,200,30);

        group.add(btn1);
        group.add(btn2);
        group.add(btn3);
        group.add(btn4);
        group.add(btn5);
        group.add(btn6);
        group.add(btn7);
        group.add(info);

        JButton btn = new JButton("Aceptar");
        btn.setBounds(100,300,85,40);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btn1.isSelected()){
                    setColor(149,76,199);
                    setStatus(2);
                    ventana2.dispose();
                } else if(btn2.isSelected()) {
                    setColor(30,188,150);
                    setStatus(3);
                    ventana2.dispose();
                } else if(btn3.isSelected()) {
                    setColor(253,240,109);
                    setStatus(4);
                    ventana2.dispose();
                } else if(btn4.isSelected()) {
                    setColor(226,52,167);
                    setStatus(5);
                    ventana2.dispose();
                } else if(btn5.isSelected()) {
                    setColor(252,149,64);
                    setStatus(6);
                    ventana2.dispose();
                } else if(btn6.isSelected()) {
                    setColor(225,66,66);
                    setStatus(7);
                    ventana2.dispose();
                } else if (btn7.isSelected()) {
                    setColor(255,0,0);
                    setStatus(8);
                    ventana2.dispose();
                } else if (info.isSelected()) {
                    JOptionPane.showMessageDialog(null, getInfo());
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona Una Opción");
                    ventana2.dispose();
                }
            }
        });

        ventana2.add(btn1);
        ventana2.add(btn2);
        ventana2.add(btn3);
        ventana2.add(btn4);
        ventana2.add(btn5);
        ventana2.add(btn6);
        ventana2.add(btn7);
        ventana2.add(info);
        ventana2.add(btn);

        ventana2.setVisible(true);
        return ventana2;
    }
    public void setFormat(){
        this.setFont(new Font("Arial",1,8));
    }

    /* ------------------------ Fin de propiedades del JButton ------------------------- */
}