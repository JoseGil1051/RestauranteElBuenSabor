/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<DetallePedido> items;

    public Pedido() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {

        // si ya existe el producto, suma cantidad
        for (DetallePedido item : items) {
            if (item.getProducto().getNombre().equals(producto.getNombre())) {
                int nuevaCantidad = item.getCantidad() + cantidad;
                items.remove(item);
                items.add(new DetallePedido(producto, nuevaCantidad));
                return;
            }
        }

        // si no existe, lo agrega
        items.add(new DetallePedido(producto, cantidad));
    }

    public List<DetallePedido> getItems() {
        return items;
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }
}