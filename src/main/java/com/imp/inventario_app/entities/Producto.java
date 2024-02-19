package com.imp.inventario_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Se hace el mapeo @ManyToOne de producto-categoria, debido a que muchos productos solo poseen
* una categoria, pero una categoria puede tener muchos productos
 */
@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 150)
    private String nombre;
    private Float precio;
    @ManyToOne
    @JoinColumn(name = "categorias_id") //A que columna se va enlazar este Foreing key
    private Categoria categoria;
}