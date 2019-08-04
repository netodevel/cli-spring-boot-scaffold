package br.com.templates.entity;

public class EntityValidator extends RuntimeException {

    public EntityValidator(String msg) {
        super(msg);
    }
}
