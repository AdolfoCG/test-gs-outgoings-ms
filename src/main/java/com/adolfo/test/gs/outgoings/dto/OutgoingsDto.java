package com.adolfo.test.gs.outgoings.dto;

import com.adolfo.test.gs.outgoings.entities.Empleado;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OutgoingsDto {
    @NotNull
    @Positive
    private Float monto;

    @NotNull
    private Empleado empleado;
}
