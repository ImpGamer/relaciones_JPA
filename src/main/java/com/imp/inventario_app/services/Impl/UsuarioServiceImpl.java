package com.imp.inventario_app.services.Impl;

import com.imp.inventario_app.entities.Rol;
import com.imp.inventario_app.entities.Usuario;
import com.imp.inventario_app.repositories.RolesRepository;
import com.imp.inventario_app.repositories.UsuarioRepository;
import com.imp.inventario_app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public List<Usuario> mostrarUsuarios(String usuariosRol)throws Exception {
        if(usuariosRol == null || usuariosRol.isEmpty()) {
            return usuarioRepository.findAll();
        } else {
            List<Usuario> usuarios = usuarioRepository.findAll();
            List<Usuario> usuariosConRol = new ArrayList<>();

            Rol rolBuscar = rolesRepository.findRolByName(usuariosRol);
            if(rolBuscar != null) {
                for(Usuario usuario:usuarios) {
                    if(usuario.getRoles().contains(rolBuscar)) {
                        usuariosConRol.add(usuario);
                    }
                }
                return usuariosConRol;
            }
        }
        throw new Exception("No se encontro ningun usuario con el rol '"+usuariosRol+"'");
    }

    @Override
    public Usuario buscarUsuario_ID(Long id) {
       return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(Long id, Usuario usuario)throws Exception {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if(usuarioBBDD != null) {
            if(usuario.getNombre().length() < 2 || usuario.getRoles().isEmpty()) {
                throw new Exception("Los datos son incompletos");
            } else {
                usuarioBBDD.setNombre(usuario.getNombre());
                usuarioBBDD.setRoles(usuario.getRoles());
                usuarioRepository.save(usuarioBBDD);
            }
        } else {
            throw new Exception("El usuario a modificar no se ha encontrado");
        }
    }

    @Override
    public void agregarUsuario(Usuario usuario)throws Exception {
        if(usuario.getNombre().length() < 2 || usuario.getRoles().isEmpty()) {
            throw new Exception("Los datos son incompletos");
        } else {
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public Set<Rol> mostrarRolesUsuario_ID(Long id) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if(usuarioBBDD != null) {
            return usuarioBBDD.getRoles();
        }
        return null;
    }

    @Override
    public Long usuarioRegistrados() {
        return usuarioRepository.count();
    }
}
