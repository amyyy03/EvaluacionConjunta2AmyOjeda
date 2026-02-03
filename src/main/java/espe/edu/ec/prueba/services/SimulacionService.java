package espe.edu.ec.prueba.services;

import espe.edu.ec.prueba.Repository.SimulacionRepository;
import espe.edu.ec.prueba.entities.ProductoFinanciero;
import espe.edu.ec.prueba.entities.ProductoSelecionado;
import espe.edu.ec.prueba.entities.Simulacion;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SimulacionService {

    public Simulacion simulateInvestment(UUID usuarioId, BigDecimal capitalDisponible, List<ProductoFinanciero> productos) {
        // Crear una instancia de Simulacion
        Simulacion simulacion = new Simulacion();
        simulacion.setId(UUID.randomUUID());
        simulacion.setUsuarioId(usuarioId);
        simulacion.setCapital_disponible(capitalDisponible);

        // Crear una lista para los productos seleccionados
        List<ProductoSelecionado> productosSeleccionados = new ArrayList<>();

        BigDecimal gananciaTotal = BigDecimal.ZERO;
        BigDecimal costoTotal = BigDecimal.ZERO;

        // Lógica para seleccionar productos (simplificada)
        for (ProductoFinanciero producto : productos) {
            if (costoTotal.add(producto.getCosto()).compareTo(capitalDisponible) <= 0) {
                ProductoSelecionado seleccionado = new ProductoSelecionado();
                seleccionado.setNombre(producto.getNombre());
                seleccionado.setPrecio(producto.getCosto());
                seleccionado.setGanancia_esperada(producto.getCosto().multiply(producto.getPorcentaje_retorno().divide(BigDecimal.valueOf(100))));

                productosSeleccionados.add(seleccionado);

                costoTotal = costoTotal.add(producto.getCosto());
                gananciaTotal = gananciaTotal.add(seleccionado.getGanancia_esperada());
            }
        }

        simulacion.setProductosSeleccionados(productosSeleccionados);
        simulacion.setGanancia_total(gananciaTotal);

        BigDecimal retornoTotal = BigDecimal.ZERO;
        if (capitalDisponible.compareTo(BigDecimal.ZERO) > 0) {
            retornoTotal = gananciaTotal.divide(capitalDisponible, 2, BigDecimal.ROUND_HALF_UP);
        }

        simulacion.setRetorno_total(retornoTotal);

        return simulacion;
    }


    public List<Simulacion> getSimulacionesByUsuario(UUID usuarioId) {
        return SimulacionRepository.findByUsuarioId(usuarioId);
    }
}
