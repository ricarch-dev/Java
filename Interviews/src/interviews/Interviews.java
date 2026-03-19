package interviews;

import javax.swing.*;

public class Interviews {

    public static void main(String[] args) {

        int totalInterviews = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese el número total de personas entrevistadas:"));
        int studentsSelectedMorning = 0;
        int studentsSelectedAfternoon = 0;
        int studentsNotSelected = 0;

        String[] availability = { "Mañana", "Tarde" };
        String[] careers = { "Informatica", "Administración de Empresas", "Produccion", "Electronica" };

        for (int i = 0; i < totalInterviews; i++) {
            int response, responseCareer;
            double[] notes = new double[5];
            double sum = 0;

            String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1) + ":");

            int semester = Integer
                    .parseInt(JOptionPane.showInputDialog("Ingrese el semestre de " + name + " (entre 1 al 6):"));
            response = JOptionPane.showOptionDialog(null, "Ingrese la disponibilidad de " + name + " (mañana/tarde):",
                    "Responda", 0, JOptionPane.QUESTION_MESSAGE, null, availability, "");

            responseCareer = JOptionPane.showOptionDialog(null, "Ingrese que Carrera estudia " + name + ": ",
                    "Responda", 0,
                    JOptionPane.QUESTION_MESSAGE, null, careers, "");

            for (int j = 0; j < 5; j++) {
                boolean validNote = false;

                while (!validNote) {
                    try {
                        notes[j] = Double
                                .parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " (0-20):"));
                        if (notes[j] >= 0 && notes[j] <= 20) {
                            sum += notes[j];
                            validNote = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 0 y 20.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 0 y 20.");
                    }
                }
            }

            double average = sum / 5.0;
            double finalNote = Math.round(average * 10) / 10.0; // Redondea a un decimal

            if (semester >= 2 && semester <= 4 && (response == 0 || response == 1) && (finalNote > 15)
                    && (responseCareer == 0)) {
                if (response == 0) {
                    studentsSelectedMorning++;
                } else {
                    studentsSelectedAfternoon++;
                }
            } else {
                studentsNotSelected++;
            }
        }

        JOptionPane.showMessageDialog(null, "Resultados de la selección de estudiantes:\n\n" +
                "Estudiantes seleccionados en la mañana: " + studentsSelectedMorning + "\n" +
                "Estudiantes seleccionados en la tarde: " + studentsSelectedAfternoon + "\n" +
                "Estudiantes no seleccionados: " + studentsNotSelected + "\n" +
                "Total de entrevistados: " + totalInterviews);
    }

}
