package com.imp.inventario_app;

import com.imp.inventario_app.entities.Rol;
import com.imp.inventario_app.entities.Usuario;
import com.imp.inventario_app.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCrearRoles() {
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisit = new Rol("Visitante");
        Rol rolCliente = new Rol("Cliente");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisit);
        entityManager.persist(rolCliente);
    }
    @Test
    public void crearNuevoUsuarioConRol() {
        Rol admin = entityManager.find(Rol.class,1);
        Rol cliente = entityManager.find(Rol.class,4);
        Rol editor = entityManager.find(Rol.class,2);
        Rol visitante = entityManager.find(Rol.class,3);

        HashSet<Rol> rolesUsuario = new HashSet<>();
        rolesUsuario.add(editor);
        rolesUsuario.add(cliente);

        Usuario usuario = new Usuario("Jose",rolesUsuario);
        entityManager.persist(usuario);
    }
}
