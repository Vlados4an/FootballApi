package ru.erma.footballapplication.util;




public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long id) {
        super(entityName + " not found with id: " + id);
    }
}
