package com.spring.ecomers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_seq_gen")
    @SequenceGenerator(
            name = "productos_seq_gen",
            sequenceName = "productos_seq",
            allocationSize = 1
    )
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private String cantidad;

    //Creamos una relacion de muchos a uno con el usuario
    @ManyToOne
    //@JoinColumn(name = "usuario_id")
    private Usuario usuario;

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
