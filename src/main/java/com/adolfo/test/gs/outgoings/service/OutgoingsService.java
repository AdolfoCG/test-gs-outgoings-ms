package com.adolfo.test.gs.outgoings.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adolfo.test.gs.outgoings.dto.OutgoingsDto;

@Service
public interface OutgoingsService {
    public ResponseEntity<?> newOutgoing(OutgoingsDto income);
}
