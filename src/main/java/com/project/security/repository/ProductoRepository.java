package com.project.security.repository;

import com.project.security.models.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    @Override
    @Query("select new Producto(p.id, p.nombre, p.codigo, p.descripcion, p.precio) " +
            "from Producto p where p.habilitado=1")
    public Iterable<Producto> findAll();

    @Override
    @Query("select new Producto(p.id, p.nombre, p.codigo, p.descripcion, p.precio) " +
            "from Producto p where p.id=:id_producto and p.habilitado=1")
    public Optional<Producto> findById(@Param("id_producto") Integer integer);

    @Modifying
    @Transactional
    @Query("update Producto p set p.habilitado=0 where p.id=:id_producto")
    public boolean deleteProductoById(@Param("id_producto") Integer id_producto);

    @Query("select count(p.codigo) from Producto p where p.codigo=:codigo and p.habilitado=1")
    public Integer existsByCodigo(@Param("codigo") String codigo);
}
