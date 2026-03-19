package selectionstudents;

import javax.swing.*;

public class SelectionStudents {
    /*
     * Desarrollar una aplicacion que solicitandole la carrera a un estudiante
     * muestre un mensaje de seleccionado si el estudiante es de informatica
     */

    public static boolean SelectStudent() {
        String[] career = { "Informatica", "Produccion", "Otro" };
        int response = JOptionPane.showOptionDialog(null, "¿Que Estudia?", "Responda", 0, JOptionPane.QUESTION_MESSAGE,
                null, career, "");
        if (response == 0) {
            JOptionPane.showMessageDialog(null, "Usted ha Sido Seleccionado");
        } else {
            JOptionPane.showMessageDialog(null, "Usted no ha Sido Seleccionado");
        }
        int confirm = JOptionPane.showConfirmDialog(null, "¿Otro estudiante?");
        return (confirm == 0);
    }

    public static void main(String[] args) {

        while (SelectStudent())
            ;
    }

}
