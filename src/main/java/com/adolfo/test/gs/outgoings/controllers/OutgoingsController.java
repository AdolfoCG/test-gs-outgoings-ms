package com.adolfo.test.gs.outgoings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adolfo.test.gs.outgoings.dto.OutgoingsDto;
import com.adolfo.test.gs.outgoings.service.OutgoingsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class OutgoingsController {
    @Autowired
    private OutgoingsService outgoingsService;

    @PostMapping("/new-egreso")
    public ResponseEntity<?> newOutgoing(@Valid @RequestBody OutgoingsDto outgoings) {
        return outgoingsService.newOutgoing(outgoings);
    }
}
