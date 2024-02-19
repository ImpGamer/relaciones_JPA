package com.imp.inventario_app.controllers;

import com.imp.inventario_app.entities.Categoria;
import com.imp.inventario_app.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/lista")
    String mostrarCategorias(Model model) {
        model.addAttribute("categorias",categoriaService.mostrarCategorias());

        return "categoriasLista";
    }
    @GetMapping("/nuevo")
    String mostrarFormularioNuevo(Model model) {
        model.addAttribute("categoria",new Categoria());
        model.addAttribute("direccion","/categorias/nuevo");

        return "formularioCategoria";
    }
    @PostMapping("/nuevo")
    String guardarCategoria(@ModelAttribute Categoria categoria, Model model) {
        try {
            categoriaService.agregarCategoria(categoria);
        }catch (Exception e) {
            model.addAttribute("errorNombre",e.getMessage());
            return "formularioCategoria";
        }
        return "redirect:/inicio";
    }
    @GetMapping("/editar/{id}")
    String formularioEditarCat(@PathVariable Long id,Model model) {
        model.addAttribute("categoria",categoriaService.buscarCategoria_ID(id));
        model.addAttribute("direccion","/categorias/editar/"+id);

        return "formularioCategoria";
    }
    @PostMapping("/editar/{id}")
    String editarCategoria(@PathVariable Long id,Categoria categoria,Model model) {
        try {
            categoriaService.editarCategoria(id,categoria);
        }catch (Exception e) {
            model.addAttribute("errorNombre",e.getMessage());
            return "formularioCategoria";
        }
        return "redirect:/inicio";
    }
    @GetMapping("/lista/{id}")
    String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias/lista";
    }
}