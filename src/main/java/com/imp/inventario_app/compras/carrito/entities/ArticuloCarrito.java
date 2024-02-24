package com.imp.inventario_app.compras.carrito.entities;

import com.imp.inventario_app.entities.Producto;
import com.imp.inventario_app.entities.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "ARTICULOS_CARRITO")
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    public ArticuloCarrito(int cantidad,Producto producto,Usuario usuario) {
        this.cantidad  =cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }
}