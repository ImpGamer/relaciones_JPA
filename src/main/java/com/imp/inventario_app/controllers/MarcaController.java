package com.imp.inventario_app.controllers;

import com.imp.inventario_app.entities.Marca;
import com.imp.inventario_app.services.CategoriaService;
import com.imp.inventario_app.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    String mostrarMarcas(Model model) {
        model.addAttribute("listaMarcas",marcaService.mostrarMarcas());
        return "marcasLista";
    }
    @GetMapping("/nuevo")
    String formularioNuevaMarca(Model model) {
        model.addAttribute("marca",new Marca());
        model.addAttribute("listaCategorias",categoriaService.mostrarCategorias());
        model.addAttribute("direccion","/marcas/nuevo");

        return "formularioMarca";
    }
    @PostMapping("/nuevo")
    String capturarNuevaMarca(Model model,@ModelAttribute Marca marca) {
        try {
            marcaService.agregarMarca(marca);
        }catch (Exception e) {
            model.addAttribute("msgError",e.getMessage());
            return "formularioMarca";
        }
        return "redirect:/marcas";
    }
}
