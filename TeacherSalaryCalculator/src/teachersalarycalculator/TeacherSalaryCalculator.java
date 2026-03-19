package teachersalarycalculator;

import javax.swing.*;

/* Develop an application that calculates a teacher's pay based on an hourly rate of 200.
If they work on Saturday, they receive a 25% bonus, and if
they have more than one year at the institution, they receive a 20% bonus. */

public class TeacherSalaryCalculator {

    public static void main(String[] args) {
        double hourlyRate = 200;
        boolean continueCalculating = true;

        while (continueCalculating) {
            double hoursWorked = getHoursWorked();
            boolean workedOnSaturday = workedOnSaturday();
            int yearsWorked = getYearsWorked();

            double salary = calculateSalary(hourlyRate, hoursWorked, workedOnSaturday, yearsWorked);

            displayResult(salary);

            int choice = JOptionPane.showConfirmDialog(null, "Calculate the salary of another teacher?", "Continue",
                    JOptionPane.YES_NO_OPTION);
            continueCalculating = (choice == JOptionPane.YES_OPTION);
        }
    }

    public static double getHoursWorked() {
        String hoursWorkedStr = JOptionPane.showInputDialog("Enter hours worked:");
        return Double.parseDouble(hoursWorkedStr);
    }

    public static boolean workedOnSaturday() {
        int option = JOptionPane.showConfirmDialog(null, "Did they work on Saturday?", "Saturday",
                JOptionPane.YES_NO_OPTION);
        return (option == JOptionPane.YES_OPTION);
    }

    public static int getYearsWorked() {
        String yearsWorkedStr = JOptionPane.showInputDialog("Enter years worked:");
        return Integer.parseInt(yearsWorkedStr);
    }

    public static double calculateSalary(double hourlyRate, double hoursWorked, boolean workedOnSaturday,
            int yearsWorked) {
        double salary = hourlyRate * hoursWorked;

        if (workedOnSaturday) {
            salary += salary * 0.25; // 25% bonus for working on Saturday
        }

        if (yearsWorked > 1) {
            salary += salary * 0.20; // 20% bonus for over 1 year of experience
        }

        return salary;
    }

    public static void displayResult(double salary) {
        JOptionPane.showMessageDialog(null, "Salary: $" + salary);
    }
}
