package com.example.demo.Constants;

public enum statusCuenta {
    ACTIVO("Activo"),
    INACTIVO("Inactiva");

    private String descripcion;

    statusCuenta(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public static statusCuenta fromDescripcion(String descripcion) {
        for (statusCuenta statusCuenta : statusCuenta.values()) {
            if (statusCuenta.descripcion.equals(descripcion)) {
                return statusCuenta;
            }
        }
        throw new IllegalArgumentException("Tipo no válido o no existe: " + descripcion);
    }
}
