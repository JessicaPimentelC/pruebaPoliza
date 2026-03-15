package com.example.prueba_poliza.model;
import jakarta.persistence.*;

@Entity
public class Riesgo {

    @Id
    @GeneratedValue
    private Long id;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "poliza_id")
    private Poliza poliza;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
}