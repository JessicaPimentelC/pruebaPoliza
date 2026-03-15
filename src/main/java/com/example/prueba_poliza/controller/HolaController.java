package com.example.prueba_poliza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String inicio(){
        return "API de Polizas y Riesgos activa";
    }
}
