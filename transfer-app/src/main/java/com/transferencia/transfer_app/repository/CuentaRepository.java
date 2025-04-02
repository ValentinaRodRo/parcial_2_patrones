package com.transferencia.transfer_app.repository;

import com.transferencia.transfer_app.model.Cuenta;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Cuenta c WHERE c.id = :id")
    Cuenta findByIdForUpdate(@Param("id") String id);
}

