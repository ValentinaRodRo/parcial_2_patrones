package com.transferencia.transfer_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.transferencia.transfer_app.model.Cuenta;
import com.transferencia.transfer_app.repository.CuentaRepository;
import com.transferencia.transfer_app.service.TransferenciaService;

@RestController
public class Controller {

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private CuentaRepository cuentaRepository;

    @RequestMapping("/")
    public String index() {
        BigDecimal monto = new BigDecimal("5");
        Cuenta origen = cuentaRepository.findById("abc").orElse(null);

        if(origen == null || origen.getMonto().compareTo(monto) < 0) return "No hay suficiente saldo en la cuenta origen.";
        
        transferenciaService.transferir("abc", "cbd", monto);

        Cuenta cuentaA = cuentaRepository.findById("abc").orElse(null);
        Cuenta cuentaB = cuentaRepository.findById("cbd").orElse(null);

        String resultado = "Cuenta abc: $" + (cuentaA != null ? cuentaA.getMonto() : "No encontrada") + "\n" +
                           "Cuenta cbd: $" + (cuentaB != null ? cuentaB.getMonto() : "No encontrada");

        return resultado;
    }

    @RequestMapping("/hola")
    public String hola() {
        return "Hola desde el controlador!";
    }

}
