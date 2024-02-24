package com.imp.inventario_app.services.Impl;

import com.imp.inventario_app.entities.Rol;
import com.imp.inventario_app.repositories.RolesRepository;
import com.imp.inventario_app.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public List<Rol> listaRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Rol buscarRol_ID(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }
}
