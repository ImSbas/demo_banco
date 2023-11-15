package com.example.demo.Constants;

public enum tipoCuenta {

    DEBITO("Debito"),
    CREDITO("Credito");

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    tipoCuenta(String descripcion) {
        this.descripcion = descripcion;
    }

    public static tipoCuenta fromDescripcion(String descripcion) {
        for (tipoCuenta tipoCuenta : tipoCuenta.values()) {
            if (tipoCuenta.descripcion.equals(descripcion)) {
                return tipoCuenta;
            }
        }
        throw new IllegalArgumentException("Tipo no válido o no existe: " + descripcion);
    }
}
