package Presentacion;

import Modelos.DetallePedido;
import Modelos.Factura;
import Modelos.Pedido;
import Modelos.Producto;


/**
 *
 * @author alfre
 */
public class Imprimir {
    public static void mostrarCarta(Producto[] productos) {

        System.out.println("===== CARTA =====");

        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%d. %s - $%.0f%n",
                    i + 1,
                    productos[i].getNombre(),
                    productos[i].getPrecio());
        }
    }

    public static void mostrarPedido(Pedido pedido) {

        System.out.println("===== PEDIDO =====");

        for (DetallePedido item : pedido.getItems()) {
            System.out.printf("%s x%d - $%.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getSubtotal());
        }
    }

    public static void imprimirFactura(Factura factura, Pedido pedido) {

        System.out.println("\n===== FACTURA =====");
        System.out.println("Factura No: " + factura.getNumero());
        System.out.println("---------------------------");

        for (DetallePedido item : pedido.getItems()) {
            System.out.printf("%s x%d - $%.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getSubtotal());
        }

        System.out.println("---------------------------");
        System.out.printf("Subtotal: $%.0f%n", factura.getSubtotal());
        System.out.printf("IVA: $%.0f%n", factura.getIva());

        if (factura.getPropina() > 0) {
            System.out.printf("Propina: $%.0f%n", factura.getPropina());
        }

        System.out.printf("TOTAL: $%.0f%n", factura.getTotal());
        System.out.println("===========================");
    }
}