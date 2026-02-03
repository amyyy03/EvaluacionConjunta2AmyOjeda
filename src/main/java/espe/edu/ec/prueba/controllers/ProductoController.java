package espe.edu.ec.prueba.controllers;


import espe.edu.ec.prueba.entities.ProductoFinanciero;
import espe.edu.ec.prueba.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoFinanciero> getAllProductos() {
        return productoService.findAll();
    }

    @PostMapping
    public ProductoFinanciero createProducto(@RequestBody ProductoFinanciero producto) {
        return productoService.save(producto);
    }
}
