package com.example.PsicologiaSystemBackEnd.Util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraints.br.CPF;

public class CpfValidator implements ConstraintValidator<CPF,String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
