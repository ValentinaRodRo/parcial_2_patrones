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
        Cuenta origen = cuentaRepo.findByIdForUpdate(origenId);
        Cuenta destino = cuentaRepo.findByIdForUpdate(destinoId);

        if (origen.getMonto().compareTo(monto) >= 0) {
            origen.setMonto(origen.getMonto().subtract(monto));
            destino.setMonto(destino.getMonto().add(monto));

            cuentaRepo.save(origen);
            cuentaRepo.save(destino);

            transaccionRepo.save(new Transaccion(origenId, destinoId, monto));
        }
    }
}

