package com.adolfo.test.gs.outgoings.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adolfo.test.gs.outgoings.dto.OutgoingsDto;
import com.adolfo.test.gs.outgoings.entities.Empleado;
import com.adolfo.test.gs.outgoings.entities.Movimiento;
import com.adolfo.test.gs.outgoings.exception.RepositoryException;
import com.adolfo.test.gs.outgoings.repositories.MovimientoRepository;
import com.adolfo.test.gs.outgoings.service.OutgoingsService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OutgoingsServiceImpl implements OutgoingsService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    @Transactional
    public ResponseEntity<?> newOutgoing(OutgoingsDto outgoing) {
        Movimiento egreso = new Movimiento();

        try {
            Empleado empleado = outgoing.getEmpleado();
    
            egreso.setTipoMovimiento(2);
            egreso.setMonto(outgoing.getMonto()); 
            egreso.setFecha(new Date());
            egreso.setEmpleado(empleado);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(movimientoRepository.save(egreso));
        } catch (RepositoryException e) {
            throw new RepositoryException("Error en base de datos: " + e);
        }
    }
}
