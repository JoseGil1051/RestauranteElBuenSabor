/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

public class Factura {

    private static int contador = 1;

    private int numero;
    private double subtotal;
    private double iva;
    private double propina;
    private double total;

    public Factura(double subtotal, double iva, double propina, double total) {
        this.numero = contador++;
        this.subtotal = subtotal;
        this.iva = iva;
        this.propina = propina;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getPropina() {
        return propina;
    }

    public double getTotal() {
        return total;
    }
}
