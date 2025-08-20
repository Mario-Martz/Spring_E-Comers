package com.spring.ecomers.controller;

import com.spring.ecomers.model.Producto;
import com.spring.ecomers.model.Usuario;
import com.spring.ecomers.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    //Variable de tipo Logger para registrar mensajes de log
    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired //Inyeccion de dependencias mediante @Autowired Spring Boot inyecte automáticamente la dependencia en tiempo de ejecución, sin necesidad de que tú crees manualmente la instancia con new.
    private ProductoService productoService; //Variable de tipo ProductoService para acceder a los metodos de la interface ProductoService

    /*
    //Inyeccion de dependencias mediante constructor
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }*/

    @GetMapping("")
    public String Show(){
        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }
    public String Update(){
        return "productos/update";
    }

    @PostMapping("/save")
    //Metodo para mapar la informacion de la vista a la clase Producto
    public String save(Producto producto){
        logger.info("Este es el objeto producto: {}", producto);
        Usuario u = new Usuario(1,"","","","","","","");
        producto.setUsuario(u);
        productoService.save(producto);
        return "redirect:/productos";
    }
}
