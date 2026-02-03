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
        simulacion.setUsuarioid(usuarioId);
        simulacion.setCapital_disponible(capitalDisponible);

        // Crear una lista para los productos seleccionados
        List<ProductoSelecionado> productosSeleccionados = new ArrayList<>();

        BigDecimal gananciaTotal = BigDecimal.ZERO;
        BigDecimal costoTotal = BigDecimal.ZERO;

        // Aquí iría tu lógica de optimización. Por ahora, seleccionamos productos de forma simple
        for (ProductoFinanciero producto : productos) {
            // Verificamos que el costo total no exceda el capital disponible
            if (costoTotal.add(producto.getCosto()).compareTo(capitalDisponible) <= 0) {
                ProductoSelecionado seleccionado = new ProductoSelecionado();
                seleccionado.setNombre(producto.getNombre());
                seleccionado.setPrecio(producto.getCosto());

                // Verificamos que el porcentaje de retorno sea válido antes de calcular
                BigDecimal porcentajeRetorno = producto.getPorcentaje_retorno() != null ? producto.getPorcentaje_retorno() : BigDecimal.ZERO;
                BigDecimal gananciaEsperada = producto.getCosto().multiply(porcentajeRetorno.divide(BigDecimal.valueOf(100)));

                seleccionado.setGanancia_esperada(gananciaEsperada);

                productosSeleccionados.add(seleccionado);

                // Actualizamos el costo total y la ganancia total
                costoTotal = costoTotal.add(producto.getCosto());
                gananciaTotal = gananciaTotal.add(gananciaEsperada);
            }
        }

        // Asignamos los productos seleccionados y las métricas finales a la simulación
        simulacion.setProductosSeleccionados(productosSeleccionados);
        simulacion.setGanancia_total(gananciaTotal);

        // Evitamos la división por cero en el cálculo del retorno
        BigDecimal retornoTotal = BigDecimal.ZERO;
        if (capitalDisponible.compareTo(BigDecimal.ZERO) > 0) {
            retornoTotal = gananciaTotal.divide(capitalDisponible, 2, BigDecimal.ROUND_HALF_UP);
        }

        simulacion.setRetorno_total(retornoTotal);

        // Devolver la simulación calculada
        return simulacion;
    }

    public List<Simulacion> getSimulacionesByUsuario(UUID usuarioId) {
        return SimulacionRepository.findByUsuarioId(usuarioId);
    }
}
