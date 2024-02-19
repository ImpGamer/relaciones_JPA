package com.imp.inventario_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class AppController {
    @GetMapping
    String inicio() {
        return "index";
    }
}
