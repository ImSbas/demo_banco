package com.example.demo.Constants;

public enum statusCliente {
    ACTIVO("Activo"),
    INACTIVO("Inactiva");

    private final String descripcion;

    statusCliente(String descripcion) {
        this.descripcion = descripcion;
    }

    public final String getDescripcion() {
        return this.descripcion;
    }

    public static statusCliente fromDescripcion(String descripcion) {
        for (statusCliente statusCuenta : statusCliente.values()) {
            if (statusCuenta.descripcion.equals(descripcion)) {
                return statusCuenta;
            }
        }
        throw new IllegalArgumentException("Tipo no válido o no existe: " + descripcion);
    }
}
