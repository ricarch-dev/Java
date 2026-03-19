package interviewstudents;

import javax.swing.*;

public class InterviewStudents {

    public static void main(String[] args) {
        int totalSelected = 0;
        int totalNotSelected = 0;

        int n = getInteger("Ingrese la cantidad de personas a entrevistar:");

        for (int i = 0; i < n; i++) {
            String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            int careerOption = getCareerOption();

            boolean isProgrammer = (careerOption == 1);
            String availability = getAvailability(
                    "Ingrese disponibilidad (1 para Mañana, 2 para Tarde, 3 para Noche):");
            double average = getAverage();
            String semester = getSemester("Ingresa el semestre cursante (1 primer semestre, 2 para segundo, etc):");
            if (isProgrammer && (availability.equals("1") || availability.equals("2"))
                    && average >= 15) {
                JOptionPane.showMessageDialog(null, name + " (Semestre " + semester + ") fue seleccionado.");
                totalSelected++;
            } else {
                JOptionPane.showMessageDialog(null, name + " (Semestre " + semester + ") no fue seleccionado.");
                totalNotSelected++;
            }
        }

        JOptionPane.showMessageDialog(null, "Total seleccionados: " + totalSelected
                + "\nTotal no seleccionados: " + totalNotSelected);

        if (totalSelected == 0) {
            JOptionPane.showMessageDialog(null, "Ningún estudiante fue seleccionado.");
        } else if (totalNotSelected == 0) {
            JOptionPane.showMessageDialog(null, "Todos los estudiantes fueron seleccionados.");
        } else if (totalSelected > totalNotSelected) {
            JOptionPane.showMessageDialog(null, "La mayoría de los estudiantes fueron seleccionados.");
        } else {
            JOptionPane.showMessageDialog(null, "La mayoría de los estudiantes no fueron seleccionados.");
        }

        System.exit(0);

    }

    public static int getInteger(String message) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                value = Integer.parseInt(JOptionPane.showInputDialog(message));
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero válido.");
            }
        }

        return value;
    }

    public static int getCareerOption() {
        int option = 0;
        boolean validInput = false;

        while (!validInput) {
            option = getInteger("Seleccione la carrera:\n1. Informática\n2. Administración\n3. Otros");
            if (option >= 1 && option <= 3) {
                validInput = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción válida (1, 2 o 3).");
            }
        }

        return option;
    }

    public static String getAvailability(String message) {
        String value = "";
        boolean validInput = false;

        while (!validInput) {
            value = JOptionPane.showInputDialog(message);
            if (value != null && (value.equals("1") || value.equals("2") || value.equals("3"))) {
                validInput = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Por favor, ingrese una opción válida (1 para Mañana, 2 para Tarde, 3 para Noche).");
            }
        }

        return value;
    }

    public static String getSemester(String message) {
        String value = "";
        boolean validInput = false;

        while (!validInput) {
            value = JOptionPane.showInputDialog(message);
            if (value != null && (value.equals("1") || value.equals("2") || value.equals("3") || value.equals("4")
                    || value.equals("5") || value.equals("6"))) {
                validInput = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Por favor, ingrese una opción válida (1 primer semestre, 2 para segundo, etc):");
            }
        }

        return value;
    }

    public static double getAverage() {
        double sum = 0;

        for (int i = 0; i < 5; i++) {
            int note = getInteger("Ingrese la nota " + (i + 1) + " (1-20):");
            if (note < 1 || note > 20) {
                JOptionPane.showMessageDialog(null, "La nota debe estar en el rango de 1 a 20. Ingrese nuevamente.");
                i--;
            } else {
                sum += note;
            }
        }

        return sum / 5;
    }
}
