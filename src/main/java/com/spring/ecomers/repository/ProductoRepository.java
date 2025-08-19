// Asegúrate de que esta interfaz esté dentro del paquete com.spring.ecomers.repository
package com.spring.ecomers.repository;

import com.spring.ecomers.model.Producto; // Importa tu modelo Producto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La interfaz debe extender JpaRepository, indicando el tipo de entidad (Producto)
// y el tipo de su ID (Integer).
@Repository // Aunque JpaRepository ya lo maneja, es una buena práctica para mayor claridad.
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Spring te proporciona automáticamente métodos CRUD aquí, como save(), findAll(), findById(), etc.
    // Puedes añadir tus propios métodos de consulta si lo necesitas.
}