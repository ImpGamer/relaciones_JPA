package com.imp.inventario_app;

import com.imp.inventario_app.compras.carrito.entities.ArticuloCarrito;
import com.imp.inventario_app.compras.carrito.repositories.ArticuloCarritoRepository;
import com.imp.inventario_app.entities.Producto;
import com.imp.inventario_app.entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

public class ArticuloCarritoTest {
    @Autowired
    private ArticuloCarritoRepository articuloRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void agregarProducto() {
        Producto producto = entityManager.find(Producto.class,1);
        Usuario usuario = entityManager.find(Usuario.class,4);

        ArticuloCarrito articulo = new ArticuloCarrito(2,producto,usuario);
        articuloRepository.save(articulo);
    }
}
