package espe.edu.ec.prueba.entities;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class ProductoSelecionado {

        private String nombre;
        private BigDecimal precio;
        private BigDecimal ganancia_esperada;


        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public BigDecimal getPrecio() {
            return precio;
        }

        public void setPrecio(BigDecimal precio) {
            this.precio = precio;
        }

        public BigDecimal getGanancia_esperada() {
            return ganancia_esperada;
        }

        public void setGanancia_esperada(BigDecimal ganancia_esperada) {
            this.ganancia_esperada = ganancia_esperada;
        }

}
