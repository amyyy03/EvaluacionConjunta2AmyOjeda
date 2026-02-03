package espe.edu.ec.prueba.services;

import espe.edu.ec.prueba.Repository.ProductoRepository;
import espe.edu.ec.prueba.entities.ProductoFinanciero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoFinanciero save(ProductoFinanciero producto) {
        return productoRepository.save(producto);
    }

    public List<ProductoFinanciero> findAll() {
        return productoRepository.findAll();
    }
}
