package com.transferencia.transfer_app.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cuenta {

    @Id
    private String id;

    private BigDecimal monto;

    public Cuenta() {}

    public Cuenta(String id, BigDecimal monto) {
        this.id = id;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
