package com.spring.ecomers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private String cantidad;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, String imagen, Double precio, String cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}
