package burgersales;

import javax.swing.*;

public class BurgerSales {

    public static void main(String[] args) {
        String username = null, name = null, id = null;
        int module = 0, discount = 0, burguer = 0, day, drinker = 0;
        double burguerPrice = 0.00, drinkPrice = 0.00, totalDayCost = 0.00;
        String[] days = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" };

        username = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");

        JOptionPane.showMessageDialog(null, "Bienvenido " + username);

        burguerPrice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de las hamburguesas: "));

        drinkPrice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de las Bedidas: "));

        module = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje de Icremento: "));

        day = JOptionPane.showOptionDialog(null, "Ingrese el dia de descuento: ", "Responda", 0,
                JOptionPane.QUESTION_MESSAGE, null, days, "");

        if (day == 2) {
            discount = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje de Descuento: "));
        } else {
            discount = 0;
        }

        int clients = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos clientes serán atendidos?"));

        for (int x = 1; x <= clients; x++) {
            JOptionPane.showMessageDialog(null, "Bienvenido");

            name = JOptionPane.showInputDialog("Indique su nombre: ");

            id = JOptionPane.showInputDialog("Indique su Identificacion: ");

            burguer = Integer.parseInt(JOptionPane
                    .showInputDialog(
                            "¿Cuantas Hamburguesas Desea? \n El Precio de las Hamburguesas es: " + burguerPrice + "$"));

            drinker = Integer.parseInt(JOptionPane
                    .showInputDialog(
                            "¿Cuantas Bebidas Desea? \n El Precio de las Hamburguesas es: " + drinkPrice + "$"));

            double totalCost = (burguer * burguerPrice + drinker * drinkPrice);

            if (day == 2) {
                totalCost -= (totalCost * discount / 100);
            }

            int paymentMethod = JOptionPane.showOptionDialog(null, "Seleccione el método de pago:",
                    "Método de Pago", 0, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "Efectivo", "Tarjeta de Crédito" }, "");

            if (paymentMethod == 1) {
                totalCost += (totalCost * module / 100);
            }

            totalDayCost += totalCost;

            // Formatear el costo con dos decimales
            String formattedCost = String.format("%.2f", totalCost);

            JOptionPane.showMessageDialog(null, "Cliente: " + name + "\nIdentificación: " + id +
                    "\nHamburguesas: " + burguer + " x $" + burguerPrice + " = $" + (burguer * burguerPrice) +
                    "\nBebidas: " + drinker + " x $" + drinkPrice + " = $" + (drinker * drinkPrice) +
                    "\nDescuento: " + (day == 2 ? discount + "%" : "0%") +
                    "\nIncremento: " + (paymentMethod == 1 ? module + "%" : "0%") +
                    "\nTotal a Pagar: $" + formattedCost);
        }

        // Formatear el total acumulado del día con dos decimales
        String formattedTotalDayCost = String.format("%.2f", totalDayCost);
        JOptionPane.showMessageDialog(null, "Total acumulado del día: $" + formattedTotalDayCost);

    }

}
