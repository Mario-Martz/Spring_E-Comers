package com.spring.ecomers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal; // Importa BigDecimal
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordenes_seq_gen")
    @SequenceGenerator(
            name = "ordenes_seq_gen",
            sequenceName = "ordenes_seq",
            allocationSize = 1
    )
    private Integer id;
    @Column(name = "numero", nullable = false)
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private BigDecimal total; // Tipo de dato cambiado a BigDecimal

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detallesOrden;

    public Orden() {
    }

    public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, BigDecimal total) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaRecibida=" + fechaRecibida +
                '}';
    }
}