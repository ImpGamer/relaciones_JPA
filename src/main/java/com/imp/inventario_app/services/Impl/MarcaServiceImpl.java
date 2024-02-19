package com.imp.inventario_app.services.Impl;

import com.imp.inventario_app.entities.Marca;
import com.imp.inventario_app.repositories.MarcaRepository;
import com.imp.inventario_app.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;
    @Override
    public List<Marca> mostrarMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca buscarMarca_ID(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMarca(Integer id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public void editarMarca(Integer id, Marca marca)throws Exception {
        Marca marcaBBDD = marcaRepository.findById(id).orElse(null);
        if(marcaBBDD != null) {
            if(marca.getNombre().length() > 3) {
                marcaBBDD.setNombre(marca.getNombre());
                marcaBBDD.setCategorias(marca.getCategorias());
                marcaRepository.save(marcaBBDD);
            } else {
                throw new Exception("El nombre de la marca es muy corto");
            }
        }
    }

    @Override
    public void agregarMarca(Marca marca)throws Exception {
        if(marca.getNombre().length() > 3) {
            marcaRepository.save(marca);
        } else {
            throw new Exception("El nombre de la marca es muy corto");
        }
    }
}
