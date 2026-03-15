package com.example.prueba_poliza.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.prueba_poliza.service.PolizaService;
import com.example.prueba_poliza.model.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polizas")
public class PolizaController {

    @Autowired
    private PolizaService polizaService;

    @GetMapping("/")
    public String inicio(){
        return "API de Polizas funcionando";
    }

    @GetMapping
    public List<Poliza> listar(
            @RequestParam String tipo,
            @RequestParam String estado){

        return polizaService.listar(tipo, estado);
    }

    @GetMapping("/{id}/riesgos")
    public List<Riesgo> riesgos(@PathVariable Long id){
        return polizaService.riesgos(id);
    }

    @PostMapping("/{id}/renovar")
    public Poliza renovar(@PathVariable Long id){
        return polizaService.renovar(id);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id){
        polizaService.cancelar(id);
    }

}