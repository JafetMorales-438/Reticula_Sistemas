import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase "Materia" representa una materia ordinaria o de especialidad segun
 * el plan reticular del "Instituto Tecnologico De Oaxaca" (ITO)
 * @author Limni Jafet Morales Morales (JafetD438)
 * @version 2.0 (27/08/22)
 */
public class Materia extends JButton{
    private final String name, cadenaCon;
    private final int semester, credits;
    private int status;
    private final boolean isCadena;

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
        /* Propiedades Materia */
        this.name = nombre;
        this.semester = semestre;
        this.credits = creditos;
        this.status = estado;
        this.isCadena = esCadena;
        this.cadenaCon = cadenaCon;
        /* Propiedades JButton*/
        this.setText("<html><center>"+getName());
        this.setFormat();
        this.setSize(100,50);
        this.click_status();
        if(getStatus() == 0){
            this.setEnabled(false);
        }
    }

    /* ----------------------- Inicio de propieades de la Materia ----------------------- */

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
     *             <li>0 = Materia no permitida.</li>
     *             <li>1 = Materia posible a seleccionar.</li>
     *             <li>2 = Cursando Materia.</li>
     *             <li>3 = Materia Acreditada.</li>
     *             <li>4 = Cursada sin acreditar.</li>
     *             <li>5 = Reprobada cursando.</li>
     *             <li>6 = A curso especial.</li>
     *             <li>7 = Especial cursando.</li>
     *             <li>8 = Curso especial reprobado.</li>
     *         </ol>
     *     </body>
     * </html>
     * @param status situacion de la materia.
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

    /**
     * Muestra en una ventana Emergente toda la información acerca de la Materia.
     * @return Información Gral.
     */
    public String getInfo(){
        return "Materia: "+getName();
    }


    /* ----------------------- Fin de propiedades de la materia ------------------------ */
    // --------------------------------------------------------------------------------- //
    /* ------------------------ Inicio propiedades del JButton ------------------------- */

    /**
     * Cambia el color del JButtton recibiendo 3 números enteros como parametros
     * para pasarlos nuevamente como parametros para crear un Color.
     * @param R Red
     * @param G Green
     * @param B Blue
     */
    private void setColor(int R, int G, int B){
        this.setBackground(new Color(R,G,B));
    }

    /**
     * El metodo click_status agrega un evento al JButton para que muestre un JFrame.
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
                    ventana2.dispose();
                } else if(btn2.isSelected()) {
                    setColor(30,188,150);
                    ventana2.dispose();
                } else if(btn3.isSelected()) {
                    setColor(253,240,109);
                    ventana2.dispose();
                } else if(btn4.isSelected()) {
                    setColor(226,52,167);
                    ventana2.dispose();
                } else if(btn5.isSelected()) {
                    setColor(252,149,64);
                    ventana2.dispose();
                } else if(btn6.isSelected()) {
                    setColor(225,66,66);
                    ventana2.dispose();
                } else if (btn7.isSelected()) {
                    setColor(255,0,0);
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