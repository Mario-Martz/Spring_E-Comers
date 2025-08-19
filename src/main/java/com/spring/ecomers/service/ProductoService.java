package com.spring.ecomers.service;

import com.spring.ecomers.model.Producto;

import java.util.Optional;

public interface ProductoService {
    public Producto save(Producto producto);
    public Optional<Producto> get(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    //public List<Producto> findAll();
}
