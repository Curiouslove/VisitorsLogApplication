package com.termii.visitorslogapplication.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
    public ResourceNotFound(Class<?> klass, Long id){
        super(String.format("Entity of class %s with id %d not found.", klass.getSimpleName(), id));
    }
    public ResourceNotFound(Class<?> klass){
        super(String.format("Entity %s not found", klass.getSimpleName()));
    }
    public ResourceNotFound(Class<?> klass, String value){
        super(String.format("Entity %s with value %s not found", klass.getSimpleName(), value));
    }

    public ResourceNotFound(Class<?> klass, Long id, String value){
        super(String.format("Entity of class %s and id %d with value %s not found.", klass.getSimpleName(), id, value));
    }
}
