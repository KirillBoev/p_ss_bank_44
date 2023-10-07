package com.bank.profile.exception;

import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
@Component
public class EntityNotFoundReturner {
    public EntityNotFoundException getEntityNotFoundException(Long id, String message) {
        return new EntityNotFoundException(message + id);
    }
}
