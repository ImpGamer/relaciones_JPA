package com.imp.inventario_app.services;

import com.imp.inventario_app.entities.Rol;
import com.imp.inventario_app.entities.Usuario;

import java.util.List;
import java.util.Set;

public interface UsuarioService {
    List<Usuario> mostrarUsuarios(String usuariosRol)throws Exception;
    Usuario buscarUsuario_ID(Long id);
    void eliminarUsuario(Long id);
    void editarUsuario(Long id,Usuario usuario)throws Exception;
    void agregarUsuario(Usuario usuario)throws Exception;
    Set<Rol> mostrarRolesUsuario_ID(Long id);
    Long usuarioRegistrados();
}
