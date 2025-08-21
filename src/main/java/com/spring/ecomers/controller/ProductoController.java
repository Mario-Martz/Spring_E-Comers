package com.spring.ecomers.controller;

import com.spring.ecomers.model.Producto;
import com.spring.ecomers.model.Usuario;
import com.spring.ecomers.service.ProductoService;
import com.spring.ecomers.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String Show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        logger.info("Este es el objeto producto: {}", producto);
        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);
        // Guardar imagen si se adjunta
        if (!file.isEmpty()) {
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Producto> optionalProducto = productoService.get(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            logger.info("Producto buscado: {}", producto);
            model.addAttribute("producto", producto);
            return "productos/edit";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        logger.info("Actualizando producto: {}", producto);

        Producto p = productoService.get(producto.getId()).orElse(null);

        if (p == null) {
            return "redirect:/productos";
        }
        // Verificamos si viene una nueva imagen
        if (!file.isEmpty()) {
            // Eliminar imagen anterior si existe
            if (p.getImagen() != null && !p.getImagen().isEmpty()) {
                upload.deleteImage(p.getImagen());
            }
            // Guardar la nueva imagen
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {
            // Si no se carga nueva imagen, se mantiene la anterior
            producto.setImagen(p.getImagen());
        }
        producto.setUsuario(new Usuario(1, "", "", "", "", "", "", ""));
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Producto> optionalProducto = productoService.get(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            // Borrar imagen si existe
            if (producto.getImagen() != null && !producto.getImagen().isEmpty()) {
                upload.deleteImage(producto.getImagen());
            }
        }
        productoService.delete(id);
        return "redirect:/productos";
    }
}
