package com.transferencia.transfer_app.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;
    private String destino;
    private BigDecimal monto;
    private Timestamp timestamp;

    public Transaccion() {}

    public Transaccion(String origen, String destino, BigDecimal monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
