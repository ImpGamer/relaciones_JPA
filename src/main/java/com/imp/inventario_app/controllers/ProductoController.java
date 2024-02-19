package com.imp.inventario_app.controllers;

import com.imp.inventario_app.entities.Producto;
import com.imp.inventario_app.services.CategoriaService;
import com.imp.inventario_app.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    String mostrarProductos(Model model) {
        model.addAttribute("productos",productoService.listaProductos());
        model.addAttribute("cantProductos",productoService.cantProductos());
        return "productosTabla";
    }
    @GetMapping("/nuevo")
    String formularioNuevoProducto(Model model) {
        model.addAttribute("categoriasLista",categoriaService.mostrarCategorias());
        model.addAttribute("producto",new Producto());
        model.addAttribute("direccion","/productos/nuevo");
        return "formularioProducto";
    }
    @PostMapping("/nuevo")
    String agregarProducto(Model model,@ModelAttribute Producto producto) {
        try {
            productoService.agregarProducto(producto);
        }catch(Exception e) {
            model.addAttribute("msgError",e.getMessage());
            model.addAttribute("categoriasLista",categoriaService.mostrarCategorias());
            return "formularioProducto";
        }
        return "redirect:/productos";
    }
    @GetMapping("/editar/{id}")
    String formularioEditarProducto(@PathVariable Long id,Model model) {
        model.addAttribute("producto",productoService.buscarProducto_ID(id));
        model.addAttribute("categoriasLista",categoriaService.mostrarCategorias());
        model.addAttribute("direccion","/productos/editar/"+id);
        return "formularioProducto";
    }
    @PostMapping("/editar/{id}")
    String editarProducto(@PathVariable Long id,Model model,Producto producto) {
        try {
            productoService.editarProducto(id,producto);
        }catch (Exception e) {
            model.addAttribute("msgError",e.getMessage());
            model.addAttribute("categoriasLista",categoriaService.mostrarCategorias());
            return "formularioProducto";
        }
        return "redirect:/productos";
    }
    @GetMapping("/{id}")
    String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/";
    }
}