package com.example.prueba_poliza.repository;

import com.example.prueba_poliza.model.Poliza;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, Long> {

    List<Poliza> findByTipoAndEstado(String tipo, String estado);

}