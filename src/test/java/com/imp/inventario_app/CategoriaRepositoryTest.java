package com.imp.inventario_app;

import static org.assertj.core.api.Assertions.assertThat;
import com.imp.inventario_app.entities.Categoria;
import com.imp.inventario_app.repositories.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoriaRepositoryTest {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Test
    public void testCrearCategoria() {
        Categoria categoriaGuradada = categoriaRepository.save(new Categoria("Electronicos"));
        assertThat(categoriaGuradada.getId()).isGreaterThan(0);
    }
}