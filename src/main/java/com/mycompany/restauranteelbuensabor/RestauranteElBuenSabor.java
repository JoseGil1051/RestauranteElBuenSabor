/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import Logica.CalculadoraFactura;
import Modelos.Factura;
import Modelos.Pedido;
import Modelos.Producto;
import Presentacion.Imprimir;
import Repositorio.Datos;
import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Producto[] productos = Datos.obtenerProductos();

        Pedido pedido = new Pedido();
        CalculadoraFactura calculadora = new CalculadoraFactura();

        boolean ejecutar = true;

        while (ejecutar) {

            System.out.println("\n===== RESTAURANTE EL BUEN SABOR =====");
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver pedido");
            System.out.println("4. Generar factura");
            System.out.println("5. Nuevo pedido");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    Imprimir.mostrarCarta(productos);
                    break;

                case 2:
                    System.out.print("Seleccione producto: ");
                    int index = sc.nextInt() - 1;

                    if (index >= 0 && index < productos.length) {

                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();

                        if (cantidad > 0) {
                            pedido.agregarProducto(productos[index], cantidad);
                            System.out.println("Producto agregado.");
                        } else {
                            System.out.println("Cantidad inválida.");
                        }

                    } else {
                        System.out.println("Producto no existe.");
                    }
                    break;

                case 3:
                    if (pedido.estaVacio()) {
                        System.out.println("No hay productos en el pedido.");
                    } else {
                        Imprimir.mostrarPedido(pedido);
                    }
                    break;

                case 4:
                    if (pedido.estaVacio()) {
                        System.out.println("No hay pedido para facturar.");
                    } else {
                        Factura factura = calculadora.generarFactura(pedido);
                        Imprimir.imprimirFactura(factura, pedido);
                    }
                    break;

                case 5:
                    pedido = new Pedido(); // reinicia pedido
                    System.out.println("Nuevo pedido iniciado.");
                    break;

                case 0:
                    ejecutar = false;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}