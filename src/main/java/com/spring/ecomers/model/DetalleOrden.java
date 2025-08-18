package com.spring.ecomers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_orden_seq_gen")
    @SequenceGenerator(
            name = "detalle_orden_seq_gen",
            sequenceName = "detalle_orden_seq_gen",
            allocationSize = 1
    )
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "cantidad", nullable = false)
    private double cantidad;
    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private double precio;
    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private double total;

    @OneToOne()
    private Orden orden;

    @OneToOne()
    private Producto producto;

    public DetalleOrden() {

    }

    public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
