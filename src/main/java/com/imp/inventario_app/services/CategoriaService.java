package com.imp.inventario_app.services;

import com.imp.inventario_app.entities.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> mostrarCategorias();
    Categoria buscarCategoria_ID(Long id);
    void eliminarCategoria(Long id);
    void editarCategoria(Long id,Categoria categoria)throws Exception;
    void agregarCategoria(Categoria categoria)throws Exception;
}
