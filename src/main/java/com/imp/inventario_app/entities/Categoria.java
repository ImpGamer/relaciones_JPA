package com.imp.inventario_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return this.nombre;
    }
}
