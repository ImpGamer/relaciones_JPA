package com.imp.inventario_app.controllers;

import com.imp.inventario_app.entities.Usuario;
import com.imp.inventario_app.services.RolService;
import com.imp.inventario_app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @GetMapping
    String mostrarUsuariosRegistrados(Model model, @Param("usuariosRol")String usuariosRol) {
        model.addAttribute("usuariosRol",usuariosRol);
        try {
            model.addAttribute("listaUsuarios",usuarioService.mostrarUsuarios(usuariosRol));
        }catch (Exception e) {
            model.addAttribute("msgError",e.getMessage());
            return "tablaUsuarios";
        }
        model.addAttribute("usuariosReg",usuarioService.usuarioRegistrados());

        return "tablaUsuarios";
    }
    @GetMapping("/nuevo")
    String formularioNuevoUsuario(Model model) {
        model.addAttribute("usuario",new Usuario());
        model.addAttribute("direccion","/usuarios/nuevo");
        model.addAttribute("listaRoles",rolService.listaRoles());

        return "formularioUsuario";
    }
    @PostMapping("/nuevo")
    String agregarNuevoUsuario(Model model, @ModelAttribute Usuario usuario) {
        try {
            usuarioService.agregarUsuario(usuario);
        }catch (Exception e) {
            model.addAttribute("msgError",e.getMessage());
            model.addAttribute("listaRoles",rolService.listaRoles());
            return "formularioUsuario";
        }
        return "redirect:/";
    }
    @GetMapping("/editar/{id}")
    String formularioEditarUsuario(@PathVariable Long id,Model model) {
        model.addAttribute("usuario",usuarioService.buscarUsuario_ID(id));
        model.addAttribute("listaRoles",rolService.listaRoles());
        model.addAttribute("direccion","/usuarios/editar/"+id);

        return "formularioUsuario";
    }
    @PostMapping("/editar/{id}")
    String editarUsuario(@PathVariable Long id,Model model,Usuario usuario) {
        try {
            usuarioService.editarUsuario(id,usuario);
        }catch (Exception e) {
            model.addAttribute("msgError",e.getMessage());
            model.addAttribute("listaRoles",rolService.listaRoles());
            return "formularioUsuario";
        }
        return "redirect:/usuarios";
    }
    @GetMapping("/{id}")
    String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}