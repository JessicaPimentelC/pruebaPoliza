package com.example.prueba_poliza.service;
import com.example.prueba_poliza.model.Poliza;
import com.example.prueba_poliza.model.Riesgo;
import com.example.prueba_poliza.repository.PolizaRepository;
import com.example.prueba_poliza.repository.RiesgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiesgoService {

    @Autowired
    private RiesgoRepository riesgoRepository;

    @Autowired
    private PolizaRepository polizaRepository;

    public Riesgo agregar(Long polizaId){

        Poliza p = polizaRepository.findById(polizaId).orElseThrow();

        if(!p.getTipo().equals("COLECTIVA")){
            throw new RuntimeException("Solo pólizas colectivas permiten múltiples riesgos");
        }

        Riesgo r = new Riesgo();
        r.setEstado("ACTIVO");
        r.setPoliza(p);

        return riesgoRepository.save(r);
    }

    public void cancelar(Long riesgoId){

        Riesgo r = riesgoRepository.findById(riesgoId).orElseThrow();

        r.setEstado("CANCELADO");

        riesgoRepository.save(r);
    }

}