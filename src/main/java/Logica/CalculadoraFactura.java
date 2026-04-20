package Logica;

import Modelos.Pedido;
import Modelos.DetallePedido;
import Modelos.Factura;

public class CalculadoraFactura {

    private static final double IVA = 0.19;
    private static final double PROPINA = 0.10;
    private static final double DESCUENTO = 0.05;
    private static final double LIMITE_PROPINA = 50000;

    public Factura generarFactura(Pedido pedido) {

        double subtotal = 0;
        int cantidadItems = 0;

        for (DetallePedido item : pedido.getItems()) {
            subtotal += item.getSubtotal();
            cantidadItems++;
        }

        if (cantidadItems > 3) {
            subtotal -= subtotal * DESCUENTO;
        }

        double iva = subtotal * IVA;
        double total = subtotal + iva;

        double propina = 0;

        if (subtotal > LIMITE_PROPINA) {
            propina = total * PROPINA;
            total += propina;
        }

        return new Factura(subtotal, iva, propina, total);
    }
}