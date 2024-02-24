package com.imp.inventario_app.services;

import com.imp.inventario_app.entities.Rol;

import java.util.List;

public interface RolService {
    List<Rol> listaRoles();
    Rol buscarRol_ID(Long id);
}
