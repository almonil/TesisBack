package com.project.security.services;

import com.project.security.models.Producto;
import com.project.security.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductoService implements ProductoRepository {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public <S extends Producto> S save(S entity) {
        return productoRepository.save(entity);
    }

    @Override
    public <S extends Producto> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Producto> findById(Integer integer) {
        return productoRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return productoRepository.existsById(integer);
    }

    @Override
    public Iterable<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Iterable<Producto> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Producto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Producto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean deleteProductoById(Integer id_producto) {
        return productoRepository.deleteProductoById(id_producto);
    }

    @Override
    public Integer existsByCodigo(String codigo) {
        return productoRepository.existsByCodigo(codigo);
    }
}
