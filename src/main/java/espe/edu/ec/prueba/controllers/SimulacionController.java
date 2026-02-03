package espe.edu.ec.prueba.controllers;

import espe.edu.ec.prueba.DTO.SimulacionRequestDTO;
import espe.edu.ec.prueba.entities.ProductoFinanciero;
import espe.edu.ec.prueba.entities.Simulacion;
import espe.edu.ec.prueba.services.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/simulaciones")
public class SimulacionController {
    private final SimulacionService simulacionService;

    @Autowired
    public SimulacionController(SimulacionService simulacionService) {
        this.simulacionService = simulacionService;
    }

    @PostMapping
    public Simulacion simulateInvestment(@RequestBody SimulacionRequestDTO request) {
        List<ProductoFinanciero> productosFinancieros = request.getProductos().stream()
                .map(dto -> new ProductoFinanciero(dto.getNombre(), dto.getPrecio(), dto.getPorcentajeGanancia()))
                .collect(Collectors.toList());

        return simulacionService.simulateInvestment(request.getUsuarioId(), request.getCapitalDisponible(), productosFinancieros);
    }

    @GetMapping("/{usuarioId}")
    public List<Simulacion> getSimulaciones(@PathVariable UUID usuarioId) {
        return simulacionService.getSimulacionesByUsuario(usuarioId);
    }

}
