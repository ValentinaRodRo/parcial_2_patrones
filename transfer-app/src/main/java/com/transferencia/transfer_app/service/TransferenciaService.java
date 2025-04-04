package com.transferencia.transfer_app.service;

import com.transferencia.transfer_app.model.Cuenta;
import com.transferencia.transfer_app.model.Transaccion;
import com.transferencia.transfer_app.repository.CuentaRepository;
import com.transferencia.transfer_app.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

@Service
public class TransferenciaService {

    @Autowired
    private CuentaRepository cuentaRepo;

    @Autowired
    private TransaccionRepository transaccionRepo;

    @Transactional
    public void transferir(String origenId, String destinoId, BigDecimal monto) {
        // Bloqueo pesimista para concurrencia
        /*Cuenta origen = cuentaRepo.findByIdForUpdate(origenId);
        Cuenta destino = cuentaRepo.findByIdForUpdate(destinoId);

        if (origen == null || origen.getMonto().compareTo(monto) < 0) return;*/

        Cuenta cuenta1, cuenta2;

        if (origenId.compareTo(destinoId) < 0) {
            cuenta1 = cuentaRepo.findByIdForUpdate(origenId);
            cuenta2 = cuentaRepo.findByIdForUpdate(destinoId);
        } else {
            cuenta1 = cuentaRepo.findByIdForUpdate(destinoId);
            cuenta2 = cuentaRepo.findByIdForUpdate(origenId);
        }
        Cuenta origen = cuenta1.getId().equals(origenId) ? cuenta1 : cuenta2;
        Cuenta destino = cuenta1.getId().equals(destinoId) ? cuenta1 : cuenta2;

        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Una de las cuentas no existe");
        }
    
        if (origen.getMonto().compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta de origen");
        }

        origen.setMonto(origen.getMonto().subtract(monto));
        destino.setMonto(destino.getMonto().add(monto));

        cuentaRepo.save(origen);
        cuentaRepo.save(destino);

        transaccionRepo.save(new Transaccion(origenId, destinoId, monto));
    }
}

