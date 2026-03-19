package average;

import javax.swing.*;

public class Average {

    public static void main(String[] args) {
        int totalStudents = getTotalStudents();

        if (totalStudents <= 0) {
            JOptionPane.showMessageDialog(null, "El número de estudiantes debe ser mayor que 0.");
            return;
        }

        for (int i = 1; i <= totalStudents; i++) {
            double[] notes = new double[5];
            double sum = 0;

            for (int j = 0; j < 5; j++) {
                boolean noteValid = false;

                while (!noteValid) {
                    try {
                        notes[j] = Double
                                .parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " (0-20):"));
                        if (notes[j] >= 0 && notes[j] <= 20) {
                            sum += notes[j];
                            noteValid = true;
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

            String result = "Student #" + i + "\n";
            result += "Notas: ";
            for (int j = 0; j < notes.length; j++) {
                result += notes[j];
                if (j < notes.length - 1) {
                    result += ", ";
                }
            }
            result += "\nAverage: " + finalNote + "\n";

            if (finalNote >= 10) {
                result += "Estado: Aprobado";
            } else {
                result += "Estado: Reprobado";
            }

            JOptionPane.showMessageDialog(null, result);
        }
    }

    private static int getTotalStudents() {
        int totalStudents;
        try {
            totalStudents = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estudiantes:"));
        } catch (NumberFormatException e) {
            totalStudents = 0; // Valor por defecto si no se ingresa un número válido
        }
        return totalStudents;
    }

}
