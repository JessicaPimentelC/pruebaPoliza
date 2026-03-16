package com.example.prueba_poliza.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prueba_poliza.repository.PolizaRepository;
import com.example.prueba_poliza.repository.RiesgoRepository;
import java.util.List;
import com.example.prueba_poliza.model.*;

@Service
public class PolizaService {

    @Autowired
    private PolizaRepository polizaRepository;

    @Autowired
    private RiesgoRepository riesgoRepository;

    public List<Poliza> listar(String tipo, String estado){

        if(tipo == null && estado == null){
            return polizaRepository.findAll();
        }

        if(tipo != null && estado != null){
            return polizaRepository.findByTipoAndEstado(tipo, estado);
        }

        if(tipo != null){
            return polizaRepository.findByTipo(tipo);
        }

        return polizaRepository.findByEstado(estado);
    }

    public List<Riesgo> riesgos(Long polizaId){
        return riesgoRepository.findByPolizaId(polizaId);
    }

    public Poliza renovar(Long id){

        Poliza p = polizaRepository.findById(id).orElseThrow();

        if(p.getEstado().equals("CANCELADA")){
            throw new RuntimeException("No se puede renovar póliza cancelada");
        }

        double ipc = 0.10;

        p.setCanon(p.getCanon() + (p.getCanon()*ipc));
        p.setPrima(p.getPrima() + (p.getPrima()*ipc));
        p.setEstado("RENOVADA");

        return polizaRepository.save(p);
    }

    public void cancelar(Long id){

        Poliza p = polizaRepository.findById(id).orElseThrow();

        p.setEstado("CANCELADA");

        List<Riesgo> riesgos = riesgoRepository.findByPolizaId(id);

        for(Riesgo r : riesgos){
            r.setEstado("CANCELADO");
        }

        riesgoRepository.saveAll(riesgos);
        polizaRepository.save(p);
    }

}