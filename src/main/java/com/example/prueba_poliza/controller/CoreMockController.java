package com.example.prueba_poliza.controller;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/core-mock")
public class CoreMockController {

    @PostMapping("/evento")
    public void evento(@RequestBody Map<String,Object> body){

        System.out.println("Evento enviado al CORE: " + body);

    }

}