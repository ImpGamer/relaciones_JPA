package com.imp.inventario_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "marcas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50,unique = true)
    private String nombre;
    @OneToMany
    @JoinColumn(name = "categorias_id")
    private List<Categoria> categorias = new ArrayList<>();
}
