package com.spring.ecomers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal; // Importa BigDecimal

@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_orden_seq_gen")
    @SequenceGenerator(
            name = "detalle_orden_seq_gen",
            sequenceName = "detalle_orden_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    private Integer cantidad;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio; // Tipo de dato cambiado a BigDecimal

    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private BigDecimal total; // Tipo de dato cambiado a BigDecimal

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne
    private Producto producto;

    public DetalleOrden() {
    }

    public DetalleOrden(Integer id, String nombre, Integer cantidad, BigDecimal precio, BigDecimal total) {
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