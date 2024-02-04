package com.edson.crudspring.enums;

public enum Status {
    ACTIVO("Ativo"),
    INACTIVO("Inativo");
    private final String value;
    Status(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }
}
