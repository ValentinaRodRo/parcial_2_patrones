package com.transferencia.transfer_app.controller;

import com.transferencia.transfer_app.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private TransferenciaService service;

    @PostMapping("/transfer")
    public String transferir(@RequestParam String origen,
                             @RequestParam String destino,
                             @RequestParam BigDecimal monto) {

        service.transferir(origen, destino, monto);
        return "Transferencia completada";
    }
}