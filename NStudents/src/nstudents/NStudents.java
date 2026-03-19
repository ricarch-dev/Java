package nstudents;

import javax.swing.*;

public class NStudents {

    public static void main(String[] args) {
        /*
         * Entrevistadas N personas indique si fue o no seleccionada en base a estos
         * requisitos:
         * Estudiante de Informatica
         * Disponibilidad en la mañana o en la tarde
         * promedio no menor a 15 Puntos
         * NOTA: El promedio se obtendra mediante la lectura de 5 notas que deberan
         * estar
         * en un rango de 1 a 20.
         * Al finalizar mostrar total de Seleccionados y total de no Seleccionados
         */
        int totalSelected = 0;
        int totalNoSelected = 0;
        int personsInterviewed = 0;

        int N = obtainNumberPersons();

        if (N <= 0) {
            JOptionPane.showMessageDialog(null, "El número de personas a entrevistar debe ser mayor que 0.");
            return;
        }

        boolean continueInterview = true;

        while (personsInterviewed < N && continueInterview) {
            String[] turns = { "Mañana", "Tarde" };
            String[] options = { "Si", "No" };

            int responseStudent = JOptionPane.showOptionDialog(
                    null,
                    "¿Es estudiante de Informática?",
                    "Entrevista",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    "");

            int responseAvailability = JOptionPane.showOptionDialog(
                    null,
                    "¿Tiene disponibilidad en la mañana o en la tarde?",
                    "Entrevista",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    turns,
                    "");

            int sumNotes = 0;

            for (int j = 0; j < 5; j++) {
                int note = obtainNote(j + 1);

                if (note < 1 || note > 20) {
                    JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 1 y 20.");
                    continue;
                }

                sumNotes += note;
            }

            double average = sumNotes / 5.0;

            if (responseStudent == 0 && responseAvailability == 0 && average >= 15) {
                totalSelected++;
            } else {
                totalNoSelected++;
            }

            personsInterviewed++;

            if (personsInterviewed < N) {
                int response = JOptionPane.showConfirmDialog(null, "¿Desea entrevistar a otra persona?");
                continueInterview = (response == JOptionPane.YES_OPTION);
            }
        }

        JOptionPane.showMessageDialog(null,
                "Total Seleccionados: " + totalSelected + "\nTotal No Seleccionados: " + totalNoSelected);
    }

    private static int obtainNumberPersons() {
        int N;

        try {
            N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de personas a entrevistar:"));
        } catch (NumberFormatException e) {
            N = 0; // Valor por defecto si no se ingresa un número válido
        }

        return N;
    }

    private static int obtainNote(int number) {
        int note;

        try {
            note = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota " + number + " (1-20):"));
        } catch (NumberFormatException e) {
            note = 0; // Valor por defecto si no se ingresa una nota válida
        }

        return note;
    }

}
