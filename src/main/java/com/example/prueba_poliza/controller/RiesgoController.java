package com.example.prueba_poliza.controller;

import com.example.prueba_poliza.model.Riesgo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.prueba_poliza.service.*;

@RestController
@RequestMapping("/riesgos")
public class RiesgoController {

    @Autowired
    private RiesgoService riesgoService;

    @GetMapping("/")
    public String inicio(){
        return "API de Riesgos funcionando";
    }
    @PostMapping("/polizas/{id}/riesgos")
    public Riesgo agregar(@PathVariable Long id){
        return riesgoService.agregar(id);
    }

    @PostMapping("/riesgos/{id}/cancelar")
    public void cancelar(@PathVariable Long id){
        riesgoService.cancelar(id);
    }

}