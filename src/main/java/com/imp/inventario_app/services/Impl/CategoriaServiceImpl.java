package com.imp.inventario_app.services.Impl;

import com.imp.inventario_app.entities.Categoria;
import com.imp.inventario_app.repositories.CategoriaRepository;
import com.imp.inventario_app.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final String errorNombre = "El nombre de la categoria es demasiado corta (minimo 4 caracteres)";
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> mostrarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoria_ID(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void editarCategoria(Long id, Categoria categoria)throws Exception {
        Categoria categoriaBBDD = categoriaRepository.findById(id).orElse(null);
        if(categoriaBBDD != null) {
            if(categoria.getNombre().length() > 3) {
                categoriaBBDD.setNombre(categoria.getNombre());
                categoriaRepository.save(categoriaBBDD);
            } else {
                throw new Exception(errorNombre);
            }
        }
    }

    @Override
    public void agregarCategoria(Categoria categoria)throws Exception {
        if(categoria.getNombre().length() < 3) {
            throw new Exception(errorNombre);
        } else {
            categoriaRepository.save(categoria);
        }
    }
}
