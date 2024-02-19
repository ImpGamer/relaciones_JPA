package com.imp.inventario_app.services;

import com.imp.inventario_app.entities.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listaProductos();
    Producto buscarProducto_ID(Long id);
    void eliminarProducto(Long id);
    void editarProducto(Long id,Producto producto)throws Exception;
    void agregarProducto(Producto producto)throws Exception;
    Long cantProductos();
}
