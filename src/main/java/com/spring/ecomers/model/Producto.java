package com.spring.ecomers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal; // Importa BigDecimal

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
    @Column(name = "nombre", nullable = false,length = 50)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio; // Tipo de dato cambiado a BigDecimal
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne
    private Usuario usuario;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, String imagen, BigDecimal precio, Integer cantidad) {
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
                ", cantidad=" + cantidad +
                '}';
    }
}