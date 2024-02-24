package com.imp.inventario_app.repositories;

import com.imp.inventario_app.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Rol,Long> {
    @Query("SELECT p FROM Rol p WHERE p.nombre= ?1")
    Rol findRolByName(String nameRol);
}
