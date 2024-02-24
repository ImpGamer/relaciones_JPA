package com.imp.inventario_app.compras.carrito.repositories;

import com.imp.inventario_app.compras.carrito.entities.ArticuloCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ArticuloCarritoRepository extends JpaRepository<ArticuloCarrito, UUID> {
}