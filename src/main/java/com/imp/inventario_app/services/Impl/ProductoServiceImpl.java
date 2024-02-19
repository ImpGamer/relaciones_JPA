package com.imp.inventario_app.services.Impl;

import com.imp.inventario_app.entities.Producto;
import com.imp.inventario_app.repositories.ProductoRepository;
import com.imp.inventario_app.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProducto_ID(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editarProducto(Long id, Producto producto) throws Exception {
        Producto productoBBDD = productoRepository.findById(id).orElse(null);
        if(productoBBDD != null) {
            if(producto.getNombre().length() > 3 && producto.getPrecio() > 1 || producto.getPrecio() == null) {
                productoBBDD.setNombre(producto.getNombre());
                productoBBDD.setCategoria(producto.getCategoria());
                productoBBDD.setPrecio(producto.getPrecio());
                productoRepository.save(productoBBDD);
            } else {
                throw new Exception("El nombre del producto es demasiado corto o el precio es menor a $1. Verifique los datos");
            }
        }
    }

    @Override
    public void agregarProducto(Producto producto) throws Exception {
        if(producto.getNombre().length() > 3 && producto.getPrecio() > 1 || producto.getPrecio() == null) {
            productoRepository.save(producto);
        } else {
            throw new Exception("El nombre del producto es demasiado corto o el precio es menor a $1. Verifique los datos");
        }
    }
    @Override
    public Long cantProductos() {
        return productoRepository.count();
    }
}
