package com.imp.inventario_app.repositories;

import com.imp.inventario_app.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
}
