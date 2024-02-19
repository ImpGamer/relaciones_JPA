package com.imp.inventario_app.services;

import com.imp.inventario_app.entities.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> mostrarMarcas();
    Marca buscarMarca_ID(Integer id);
    void eliminarMarca(Integer id);
    void editarMarca(Integer id,Marca marca)throws Exception;
    void agregarMarca(Marca marca)throws Exception;
}
